package com.longyi.module_usercenter.ui.func

import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.manager.ARouterManager
import com.example.lib_common.utils.ToastUtils
import com.longyi.module_usercenter.R
import com.longyi.module_usercenter.data.DataSource
import com.longyi.module_usercenter.ui.mine.TestAccessibilityService
import io.reactivex.rxjava3.core.Observable
import kotlinx.android.synthetic.main.activity_func_main.*
import java.util.concurrent.TimeUnit

@Route(path = RouterPath.UserCenter.FUNC, name = "功能型页面")
class FuncMainActivity : BaseActivity() {
    private lateinit var mFuncMainAdapter: FuncMainAdapter


    override fun getLayoutId(): Int {
        return R.layout.activity_func_main
    }

    override fun initView() {
        initToolbar()

        val funcMainDatas = DataSource.getFuncMainData()
        mFuncMainAdapter = FuncMainAdapter(funcMainDatas)
        rv_func_main.apply {
            layoutManager = GridLayoutManager(this@FuncMainActivity, 2)
            adapter = mFuncMainAdapter
        }

        mFuncMainAdapter.setOnItemClickListener { adapter, view, position ->

            when (funcMainDatas[position].mID) {
                DataSource.DOWN_LOAD_FILE -> ToastUtils.show(BaseApplication.context,"正在开发中")
                DataSource.DOWN_UPLOAD_FILE -> ToastUtils.show(BaseApplication.context,"正在开发中")
                DataSource.TO_SHARE_MODULE -> ARouterManager.toActivity(RouterPath.Share.SHARE_APP)
                DataSource.TO_MAP_MODULE -> ARouterManager.toActivity(RouterPath.Map.MAP_APP)
                DataSource.TO_GANK_MODULE -> ARouterManager.toActivity(RouterPath.Gank.GANK_PHOTO)
                DataSource.TO_JETPACK_MODULE -> ARouterManager.toActivity(RouterPath.AndroidJetPack.CUSTOM_TAB)
                DataSource.GET_ALL_SERVICE -> getAllService()
            }
        }
    }

    override fun initData() {}

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "探索新功能"
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun getAllService() {
        val isCheck = TestAccessibilityService.checkEnabledAccessibilityService(BaseApplication.context)
        val isRun = TestAccessibilityService.isRun(
            BaseApplication.context,
            "com.longyi.module_usercenter.ui.mine.MyAccessibilityService"
        )
        if (isCheck) {
            if (isRun){
                TestAccessibilityService.getAllServiceName(BaseApplication.context, object :IAllService{
                    override fun success(serviceNames: MutableList<String>) {
                        AllServicePopup(BaseApplication.context,serviceNames).showPopupWindow()
                    }
                })
                ToastUtils.show(this, "已运行权限")
            }else{
                ToastUtils.show(this, "未运行权限")

            }

        } else {
            ToastUtils.show(this, "未获取权限")
        }
    }


}