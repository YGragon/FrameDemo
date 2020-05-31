package com.longyi.module_android_jetpack

import android.app.Application
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.AppConfig
import com.example.lib_common.utils.LogUtils
import java.lang.Exception


class JetpackApplication : BaseApplication()  {

    private val sTAG:String = JetpackApplication::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        // 初始化组件 Application
        initData(this)
    }

    /**
     * 通过反射，完成了组件 Application 的初始化操作，也实现了组件与化中的解耦需求
     */
    override fun initData(application: Application) {
        for (moduleApp in AppConfig.moduleApps) {
            try {
                val clazz = Class.forName(moduleApp)
                val baseApp = clazz.newInstance() as BaseApplication
                baseApp.initData(this)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }catch (e:Exception){
                LogUtils.d("MainApplication   Exception.e.message()" + e.message)
            }
        }

    }


}