package com.longyi.module_usercenter.ui.mine


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.longyi.module_usercenter.data.DataSource

import com.longyi.module_usercenter.ui.mine.contract.MineContract
import com.longyi.module_usercenter.ui.mine.presenter.MinePresenter
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.event.LoginEvent
import com.example.lib_common.model.UserControl
import com.example.lib_common.service.gank.IGankPhotoCallBack
import com.example.lib_common.service.gank.IGankService
import com.example.lib_common.utils.GlideUtils
import com.example.lib_common.utils.PreferenceUtils
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.utils.rxbus.bus.RxBus
import com.example.lib_common.utils.rxbus.bus.RxBusReceiver
import com.longyi.lib_base_item.BaseItemLayout
import com.longyi.module_usercenter.R
import com.tencent.bugly.beta.Beta
import kotlinx.android.synthetic.main.fragment_mine.*
import com.longyi.lib_base_item.config.ConfigAttrs
import com.longyi.lib_base_item.config.Mode


/**
 * 用户中心
 *
 */
@Route(path =  RouterPath.UserCenter.MINE,name = "我的")
class MineFragment : BaseFragment(), MineContract.View {


    private val TAG = "MineFragment"
    private var mToolBarLayoutTitle = "点击加号按钮登录"
    private var mMineItems = DataSource.getFunData(false)
    private var mMineAdapter = MineAdapter(mMineItems)
    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { MinePresenter() }

    init {
        mPresenter.attachView(this)
    }

    companion object {
        fun newInstance() = MineFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initData() {
        fabButton.setOnClickListener {
            if (UserControl.isLogin()){
                val userName = PreferenceUtils.getString(BaseConstant.USER_NAME)
                ToastUtils.show(BaseApplication.context,"当前登录的用户是：$userName")
            }else{
                ARouter.getInstance().build(RouterPath.UserCenter.LOGIN).navigation()
            }
        }

    }

    override fun initView() {
        val baseItemLayout = BaseItemLayout(requireActivity())
        val valueList = mutableListOf<String>()
        val resIdList = mutableListOf<Int>()
        for (i in mMineItems){
            valueList.add(i.mName)
            resIdList.add(R.mipmap.ic_launcher)
        }
        val attrs = ConfigAttrs() // 把全部参数的配置，委托给ConfigAttrs类处理。
        //参数 使用链式方式配置
        attrs.setValueList(valueList)  // 文字 list
            .setResIdList(resIdList) // icon list
            .setIconWidth(24)  //设置icon 的大小
            .setIconHeight(24)
            .setItemMode(Mode.NORMAL)
        baseItemLayout.setConfigAttrs(attrs)
            .create(requireActivity()) //
        layout.addView(baseItemLayout)

        // 从gank 组件获取一张图片
        val mineHeadImg = PreferenceUtils.getString("mine_head_img")
        if (mineHeadImg.isNotEmpty()){
            GlideUtils.showImageView(BaseApplication.context,iv_bg,mineHeadImg)
        }
        val gankService = ARouter.getInstance().build("/gank/IGankService").navigation() as IGankService
        gankService.getHeaderPhoto(object :IGankPhotoCallBack{
            override fun success(imageUrl: String) {
                PreferenceUtils.saveValue("mine_head_img",imageUrl)
                if (mineHeadImg.isEmpty()){
                    // 初次进入，显示返回的图片
                    GlideUtils.showImageView(BaseApplication.context,iv_bg,imageUrl)
                }
            }

            override fun fail(msg: String) {
                ToastUtils.show(BaseApplication.context,msg)
            }
        })

        RxBus.receiveSticky(this,"login_success",object :RxBusReceiver<Any>(){
            override fun receive(data: Any) {
                val loginData = data as LoginEvent
                Log.e("222","登录回调："+loginData)
                checkUserLogin()
            }
        })

//        rv_mine_list.layoutManager = LinearLayoutManager(activity)
//        rv_mine_list.adapter = mMineAdapter




        // 检测是否登录
        checkUserLogin()
        toolbar_layout.title = mToolBarLayoutTitle

        mMineAdapter.setOnItemClickListener { adapter, view, position ->
            when(mMineItems[position].mID){
                DataSource.DOWN_LOAD_APK -> Beta.checkUpgrade()
                DataSource.DOWN_LOAD_FILE -> ToastUtils.show(BaseApplication.context,"下载文件使用")
                DataSource.DOWN_UPLOAD_FILE -> ToastUtils.show(BaseApplication.context,"上传文件使用")
                DataSource.TO_SHARE_MODULE -> ARouter.getInstance().build(RouterPath.Share.SHARE_APP).navigation()
                DataSource.TO_MAP_MODULE -> ARouter.getInstance().build(RouterPath.Map.MAP_APP).navigation()
                DataSource.TO_GANK_MODULE -> ARouter.getInstance().build(RouterPath.Gank.GANK_PHOTO).navigation()
                DataSource.TO_JETPACK_MODULE ->  ARouter.getInstance().build(RouterPath.AndroidJetPack.CUSTOM_TAB).navigation()
                DataSource.GET_ALL_SERVICE -> getAllService()
                DataSource.GET_COLLECT -> ARouter.getInstance().build(RouterPath.UserCenter.COLLECT).navigation()
                DataSource.LOG_OUT -> mPresenter.loginOut()
            }
        }
    }


    // TODO 优化展示获取的所有服务
    private fun getAllService(){
        val isCheck = TestService.checkEnabledAccessibilityService(BaseApplication.context)
        if (isCheck){
            val isRun = TestService.isRun(BaseApplication.context,"")
            val enabled = TestService.enabled("",BaseApplication.context)
            Log.e(TAG, "getAllService:$isRun")
            Log.e(TAG, "getAllService:$enabled")
        }else{
            Log.e(TAG, "getAllService :未获取权限")
        }
    }
    override fun setTvTitleBackgroundColor() {
//        tv_title.setBackgroundColor(resources.getColor(R.color.colorPrimary))
//        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    private fun checkUserLogin() {
        if (UserControl.isLogin()) {
            val username = PreferenceUtils.getString(BaseConstant.USER_NAME)
            val user = UserControl.getUserByName(username)
            Log.e(TAG,"当前user：$user")
            if (user == null){
                // 未登录
                Log.e(TAG,"当前处于未登录状态 user == null ")

            }else{
                mToolBarLayoutTitle = "欢迎你，${user.username}"
                toolbar_layout.title = mToolBarLayoutTitle
                // 隐藏登录按钮
                fabButton.isGone = true
                // 刷新下方列表
                mMineItems.clear()
                mMineItems.addAll(DataSource.getFunData(true))
                mMineAdapter.notifyDataSetChanged()
            }
        } else {
            // 未登录
            mToolBarLayoutTitle = "点击加号按钮登录"
            toolbar_layout.title = mToolBarLayoutTitle
            // 显示登录按钮
            fabButton.isGone = false
            mMineItems.clear()
            mMineItems.addAll(DataSource.getFunData(false))
            mMineAdapter.notifyDataSetChanged()
            Log.e(TAG,"当前处于未登录状态 user.isLogin == false")
        }
    }

    override fun fragmentShowToUser() {}

    override fun fragmentHideToUser() {}

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showUserInfo() {}

    override fun showLoginOutSuccess(){
        PreferenceUtils.remove(BaseConstant.IS_LOGIN_KEY)
        PreferenceUtils.remove(BaseConstant.USER_NAME)
        checkUserLogin()
        ToastUtils.show(BaseApplication.context,"已退出登录")
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onResume() {
        super.onResume()
        checkUserLogin()
    }
}
