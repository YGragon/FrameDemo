package com.longyi.lib_download.app_upgrade

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.lib_common.base.BaseActivity
import com.longyi.lib_download.R
import com.permissionx.guolindev.PermissionX

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
    @RequiresApi(Build.VERSION_CODES.O)
    private fun checkDownLoadPermission() {

        PermissionX.init(this)
            .permissions(Manifest.permission.REQUEST_INSTALL_PACKAGES)
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    // 拥有权限
                    sListener?.permissionSuccess()
                    finish()
                    Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
                } else {
                    showDialog()
                    Toast.makeText(this, "These permissions are denied: $deniedList", Toast.LENGTH_LONG).show()
                }
            }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.app_name)
        builder.setMessage("为了正常升级"+ R.string.app_name +"，请点击设置按钮，允许安装未知来源应用，本功能只限用于" + R.string.app_name + "APP版本升级")
        builder.setPositiveButton("设置") { _, _ ->
            startInstallPermissionSettingActivity()
            mAlertDialog?.dismiss()
        }
        builder.setNegativeButton("取消") { _, _ ->
            sListener?.permissionFail()
            mAlertDialog?.dismiss()
            finish()
        }
        mAlertDialog = builder.create()
        mAlertDialog?.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
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
