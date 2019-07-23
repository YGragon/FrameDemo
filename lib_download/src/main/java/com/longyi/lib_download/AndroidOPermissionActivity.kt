package com.longyi.lib_download

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.lib_common.base.BaseActivity
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class AndroidOPermissionActivity : BaseActivity() {
    private var mAlertDialog: AlertDialog? = null
    companion object{
        var sListener: AppDownloadManager.AndroidOInstallPermissionListener? = null
    }

    override fun getLayoutId(): Int {
        return 0
    }

    override fun initView() {
        // 弹窗
        if (Build.VERSION.SDK_INT >= 26) {
            checkDownLoadPermission()
        } else {
            finish()
        }
    }

    override fun initData() {
    }

    /**
     * 6.0以下版本(系统自动申请) 不会弹框
     * 有些厂商修改了6.0系统申请机制，他们修改成系统自动申请权限了
     */
    @NeedsPermission(Manifest.permission.REQUEST_INSTALL_PACKAGES)
    fun checkDownLoadPermission() {

//        PermissionsDispatcherActivityPermissionsDispatcher.getSingleWithCheck(this)

    }

    @SuppressLint("NeedOnRequestPermissionsResult")
    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        PermissionsDispatcherActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults)
    }

//    @RequiresApi(Build.VERSION_CODES.O)
//    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
//        if (requestCode == 0) {
//            if (perms.isNotEmpty()) {
//                if (perms.contains(Manifest.permission.READ_PHONE_STATE)
//                    && perms.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                    && perms.contains(Manifest.permission.CAMERA)
//                ) {
//                    // 拥有权限
//                    sListener?.permissionSuccess()
//                    finish()
//                }
//            }else{
//                //startInstallPermissionSettingActivity();
//                showDialog();
//            }
//        }
//    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("配电运维管控App")
        builder.setMessage("为了正常升级 配电运维管控APP，请点击设置按钮，允许安装未知来源应用，本功能只限用于" + R.string.app_name + "APP版本升级")
        builder.setPositiveButton("设置") { dialogInterface, i ->
            startInstallPermissionSettingActivity()
            mAlertDialog?.dismiss()
        }
        builder.setNegativeButton("取消") { dialogInterface, i ->
            sListener?.permissionFail()
            mAlertDialog?.dismiss()
            finish()
        }
        mAlertDialog = builder.create()
        mAlertDialog?.show()
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun startInstallPermissionSettingActivity() {
        //注意这个是8.0新API
        val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, Uri.parse("package:$packageName"))
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            // 授权成功
            sListener?.permissionSuccess()
        } else {
            // 授权失败
            sListener?.permissionFail()
        }
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        sListener = null
    }
}
