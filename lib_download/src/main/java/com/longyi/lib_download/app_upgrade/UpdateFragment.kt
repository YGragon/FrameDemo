package com.longyi.lib_download.app_upgrade


import android.Manifest
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.utils.NetworkUtil
import com.longyi.lib_download.R
import kotlinx.android.synthetic.main.fragment_update.*


/**
 * 升级弹窗
 *
 */
class UpdateFragment : DialogFragment() {

    private val TAG = "UpdateFragment"
    private var descApp: String? = null
    private var urlApp: String? = null
    private var canCancel = true
    private var downloadManager: AppDownloadManager? = null


    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val displayMetrics = DisplayMetrics()
            activity!!.windowManager.defaultDisplay.getMetrics(displayMetrics)
            dialog.window.setLayout((displayMetrics.widthPixels * 0.75).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE) // 去掉标题
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val view = inflater.inflate(R.layout.fragment_update, container)

        val bundle = arguments
        descApp = bundle!!.getString("desc")
        urlApp = bundle.getString("url")

        val tvDesc = view.findViewById<TextView>(R.id.tv_desc)
        tvDesc.text = descApp


        val updateNowBtn = view.findViewById(R.id.update_now_btn) as Button
        updateNowBtn.setOnClickListener {

            this@UpdateFragment.requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            // 首页升级弹窗
            downloadManager = AppDownloadManager(activity!!)
            downloadManager!!.setUpdateListener(object :
                AppDownloadManager.OnUpdateListener {
                override fun update(currentByte: Int, totalByte: Int) {
                    Log.e(TAG, "update: 当前进度------>"+currentByte );
                    Log.e(TAG, "update: 总的大小---------------------->"+totalByte );
                }
            })

            // wifi 监听
            if (NetworkUtil.isWifi(BaseApplication.context)) {
                if (isAdded) {
                    downloadManager!!.downloadApk(
                        urlApp!!,
                        resources.getString(R.string.app_name),
                        getStringData().toString()
                    )
                }
            } else {
                // 弹窗提示
                AlertDialog.Builder(activity!!)
                    .setTitle("提示信息")
                    .setMessage("当前不是 wifi 环境，确定下载吗？")
                    .setPositiveButton("确定") { dialog, which ->
                        if (isAdded) {
                            downloadManager!!.downloadApk(
                                urlApp!!,
                                resources.getString(R.string.app_name),
                                getStringData().toString()
                            )
                            dialog.dismiss()
                        }
                    }
                    .setNegativeButton("取消") { dialog, which -> dialog.dismiss() }
                    .create()
                    .show()
            }
            dismiss()
        }
        return view
    }


    /**
     * 服务器返回的升级描述
     * @return
     */
    private fun getStringData(): List<String> {
        val list = arrayListOf<String>()
        descApp?.let { list.add(it) }
        return list
    }

    /**
     * api11 后，如果在onPause 和 onStop 之间调用 commit ，将有可能抛出一个IllegalStateException异常告知状态丢失
     * java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
     *
     * show 方法就是直接 commit ，这里改用  commitAllowingStateLoss
     *
     * @param manager
     * @param tag
     */
    override fun show(manager: FragmentManager, tag: String?) {
        try {
            val c = Class.forName("android.support.v4.app.DialogFragment")
            val con = c.getConstructor()
            val obj = con.newInstance()
            val dismissed = c.getDeclaredField(" mDismissed")
            dismissed.isAccessible = true
            dismissed.set(obj, false)
            val shownByMe = c.getDeclaredField("mShownByMe")
            shownByMe.isAccessible = true
            shownByMe.set(obj, false)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val ft = manager.beginTransaction()
        ft.add(this, tag)
        ft.commitAllowingStateLoss()

    }

}
