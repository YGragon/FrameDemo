package com.longyi.lib_download

import android.app.Activity
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.database.ContentObserver
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import java.io.File
import java.lang.ref.WeakReference

/**
 * apk 下载管理
 */
class AppDownloadManager {
    val TAG = AppDownloadManager::class.java.simpleName
    private lateinit var weakReference: WeakReference<Activity>
    private lateinit var mDownloadManager: DownloadManager
    private lateinit var mDownLoadChangeObserver: DownloadChangeObserver
    private lateinit var mDownloadReceiver: DownloadReceiver
    private var mReqId: Long = 0
    private var mUpdateListener: OnUpdateListener? = null
    private var appFileName: String? = null

    constructor(activity: Activity){
        weakReference = WeakReference<Activity>(activity)
        mDownloadManager = weakReference.get()!!.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        mDownLoadChangeObserver = DownloadChangeObserver(Handler())
        mDownloadReceiver = DownloadReceiver()
        // 注册内容观察者，监听URI是否有添加
        weakReference.get()!!.getContentResolver().registerContentObserver(
            Uri.parse("content://downloads/my_downloads"), true,
            mDownLoadChangeObserver
        )
        // 注册广播，监听APK是否下载完成
        Log.e(TAG, "resume: 注册广播")
        weakReference.get()!!.registerReceiver(mDownloadReceiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }


    fun setUpdateListener(mUpdateListener: OnUpdateListener) {
        this.mUpdateListener = mUpdateListener
    }

    fun downloadApk(apkUrl: String, title: String, desc: String) {
        // fix bug : 装不了新版本，在下载之前应该删除已有文件
        Log.e(TAG, "downloadApk: apk------>$apkUrl")
        val split = apkUrl.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        appFileName = split[split.size - 1]
        val apkFile = File(weakReference.get()!!.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), appFileName)

        if (apkFile != null && apkFile.exists()) {
            apkFile.delete()
        }
        // 启动 DownLoadManager 下载
        val request = DownloadManager.Request(Uri.parse(apkUrl))
        // 设置title
        request.setTitle(title)
        // 设置描述
        request.setDescription(desc)
        // 完成后显示通知栏
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalFilesDir(weakReference.get(), Environment.DIRECTORY_DOWNLOADS, appFileName)
        //在手机SD卡上创建一个download文件夹
        // Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdir() ;
        //指定下载到SD卡的/download/my/目录下
        // request.setDestinationInExternalPublicDir("/codoon/","codoon_health.apk");

        request.setMimeType("application/vnd.android.package-archive")
        // 异步下载
        mReqId = mDownloadManager.enqueue(request)
    }

    /**
     * 取消下载
     */
    fun cancel() {
        mDownloadManager.remove(mReqId)
    }

//    /**
//     * 对应 {@link Activity }
//     */
//    public void resume() {
//        //设置监听Uri.parse("content://downloads/my_downloads")
//        weakReference.get().getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true,
//                mDownLoadChangeObserver);
//        // 注册广播，监听APK是否下载完成
//        Log.e(TAG, "resume: 注册广播" );
//        weakReference.get().registerReceiver(mDownloadReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
//    }

    /**
     * 对应[Activity.onPause] ()}
     */
    fun onPause() {
        weakReference.get()!!.getContentResolver().unregisterContentObserver(mDownLoadChangeObserver)
        weakReference.get()!!.unregisterReceiver(mDownloadReceiver)
    }

    /**
     * 传递下载进度，用于更新视图
     */
    private fun updateView() {
        val bytesAndStatus = intArrayOf(0, 0, 0)
        val query = DownloadManager.Query().setFilterById(mReqId)
        var c: Cursor? = null
        try {
            c = mDownloadManager.query(query)
            if (c != null && c!!.moveToFirst()) {
                //已经下载的字节数
                bytesAndStatus[0] =
                    c!!.getInt(c!!.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                //总需下载的字节数
                bytesAndStatus[1] = c!!.getInt(c!!.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                //状态所在的列索引
                bytesAndStatus[2] = c!!.getInt(c!!.getColumnIndex(DownloadManager.COLUMN_STATUS))
            }
        } finally {
            if (c != null) {
                c!!.close()
            }
        }
        if (mUpdateListener != null) {
            mUpdateListener!!.update(bytesAndStatus[0], bytesAndStatus[1])
        }

        Log.e(TAG, "下载进度：" + bytesAndStatus[0] + "/" + bytesAndStatus[1] + "")
    }

    /**
     * 内容观察者：观察(捕捉)特定 Uri 引起的数据库的变化，继而做一些相应的处理
     * 这里是下载的安装包信息
     */
    private inner class DownloadChangeObserver
    /**
     * Creates a content observer.
     *
     * @param handler The handler to run [.onChange] on, or null if none.
     */
        (handler: Handler) : ContentObserver(handler) {

        override fun onChange(selfChange: Boolean) {
            super.onChange(selfChange)
            updateView()
        }
    }

    /**
     * 下载广播：用于通知自动安装
     */
    private inner class DownloadReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val haveInstallPermission: Boolean
            // 兼容Android 8.0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                //先获取是否有安装未知来源应用的权限
                haveInstallPermission = context.getPackageManager().canRequestPackageInstalls()
                if (!haveInstallPermission) {
                    // 没有权限 弹窗，并去设置页面授权
                    val listener = object : AndroidOInstallPermissionListener {
                        override fun permissionSuccess() {
                            installApk(context, intent)
                        }

                        override fun permissionFail() {
                            Toast.makeText(context, "授权失败，无法安装应用", Toast.LENGTH_SHORT).show()
                        }
                    }
                    AndroidOPermissionActivity.sListener = listener
                    val intent1 = Intent(context, AndroidOPermissionActivity::class.java)
                    context.startActivity(intent1)

                } else {
                    installApk(context, intent)
                }
            } else {
                installApk(context, intent)
            }

        }
    }

    /**
     * 安装apk
     * @param context
     * @param intent
     */
    private fun installApk(context: Context, intent: Intent) {
        val completeDownLoadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)

        Log.e(TAG, "收到广播")
        val uri: Uri
        val intentInstall = Intent()
        intentInstall.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intentInstall.action = Intent.ACTION_VIEW

        if (completeDownLoadId == mReqId) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                // 6.0以下
                uri = mDownloadManager.getUriForDownloadedFile(completeDownLoadId)
            } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                // 6.0 - 7.0
                val apkFile = queryDownloadedApk(context, completeDownLoadId)
                uri = Uri.fromFile(apkFile)
            } else {
                // Android 7.0 以上
                uri = FileProvider.getUriForFile(
                    context,
                    "com.meiqu.wehere.MyFileProvider",
                    File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), appFileName)
                )
                intentInstall.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            }

            // 安装应用
            Log.e(TAG, "下载完成了")

            intentInstall.setDataAndType(uri, "application/vnd.android.package-archive")
            context.startActivity(intentInstall)

            // 注销广播
            weakReference.get()!!.getContentResolver().unregisterContentObserver(mDownLoadChangeObserver)
            weakReference.get()!!.unregisterReceiver(mDownloadReceiver)
        }
    }

    /**
     * 通过downLoadId查询下载的apk，解决6.0以后安装的问题
     * @param context
     * @param downloadId
     * @return
     */
    fun queryDownloadedApk(context: Context, downloadId: Long): File? {
        var targetApkFile: File? = null
        val downloader = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        if (downloadId.toInt() != -1) {
            val query = DownloadManager.Query()
            query.setFilterById(downloadId)
            query.setFilterByStatus(DownloadManager.STATUS_SUCCESSFUL)
            val cur = downloader.query(query)
            if (cur != null) {
                if (cur.moveToFirst()) {
                    val uriString = cur.getString(cur.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))
                    if (!TextUtils.isEmpty(uriString)) {
                        targetApkFile = File(Uri.parse(uriString).getPath())
                    }
                }
                cur.close()
            }
        }
        return targetApkFile
    }

    /**
     * 监听进度接口
     */
    interface OnUpdateListener {
        fun update(currentByte: Int, totalByte: Int)
    }

    /**
     * 允许安装未知应用权限监听
     */
    interface AndroidOInstallPermissionListener {
        fun permissionSuccess()

        fun permissionFail()
    }

}