package com.longyi.module_usercenter.ui.mine


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.isGone
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.framedemo.data.bean.MineItemBean
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
import com.longyi.module_usercenter.R
import com.maiml.library.config.ConfigAttrs
import com.maiml.library.config.Mode
import com.tencent.bugly.beta.Beta
import kotlinx.android.synthetic.main.fragment_mine.*
import kotlinx.android.synthetic.main.motion_coordinatorlayout_header.*


/**
 * 用户中心
 *
 */
@Route(path =  RouterPath.UserCenter.MINE,name = "我的")
class MineFragment : BaseFragment(), MineContract.View {


    private val TAG = "MineFragment"
    private var mToolBarLayoutTitle = "点击加号按钮登录"
    private var mMineItems = mutableListOf<MineItemBean>()
//    private var mMineAdapter = MineAdapter(mMineItems)

    private lateinit var container: View

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

    override fun onResume() {
        super.onResume()
        // 检测是否登录
        checkUserLogin()
    }

    fun changeState(v: View?) {
        val motionLayout = container as? MotionLayout ?: return
        if (motionLayout.progress > 0.5f) {
            motionLayout.transitionToStart()
        } else {
            motionLayout.transitionToEnd()
        }
    }

    override fun initView() {
        container = requireActivity().findViewById(R.id.motionLayout)
        val icon = requireActivity().findViewById<ImageView>(R.id.icon)
        icon?.clipToOutline = true

        // 从gank 组件获取一张图片
        val mineHeadImg = PreferenceUtils.getString("mine_head_img")
        if (mineHeadImg.isNotEmpty()){
            GlideUtils.showImageView(BaseApplication.context,background,mineHeadImg)
        }
        val gankService = ARouter.getInstance().build("/gank/IGankService").navigation() as IGankService
        gankService.getHeaderPhoto(object :IGankPhotoCallBack{
            override fun success(imageUrl: String) {
                PreferenceUtils.saveValue("mine_head_img",imageUrl)
                if (mineHeadImg.isEmpty()){
                    // 初次进入，显示返回的图片
                    GlideUtils.showImageView(BaseApplication.context,background,imageUrl)
                }
            }

            override fun fail(msg: String) {
                ToastUtils.show(BaseApplication.context,msg)
            }
        })


        name.text = mToolBarLayoutTitle

//        mMineAdapter.setOnItemClickListener { adapter, view, position ->
//            when(mMineItems[position].mID){
//                DataSource.DOWN_LOAD_APK -> Beta.checkUpgrade()
//                DataSource.DOWN_LOAD_FILE -> ToastUtils.show(BaseApplication.context,"下载文件使用")
//                DataSource.DOWN_UPLOAD_FILE -> ToastUtils.show(BaseApplication.context,"上传文件使用")
//                DataSource.TO_SHARE_MODULE -> ARouter.getInstance().build(RouterPath.Share.SHARE_APP).navigation()
//                DataSource.TO_MAP_MODULE -> ARouter.getInstance().build(RouterPath.Map.MAP_APP).navigation()
//                DataSource.TO_GANK_MODULE -> ARouter.getInstance().build(RouterPath.Gank.GANK_PHOTO).navigation()
//                DataSource.TO_JETPACK_MODULE ->  ARouter.getInstance().build(RouterPath.AndroidJetPack.CUSTOM_TAB).navigation()
//                DataSource.GET_ALL_SERVICE -> getAllService()
//                DataSource.GET_COLLECT -> ARouter.getInstance().build(RouterPath.UserCenter.COLLECT).navigation()
//                DataSource.LOG_OUT -> mPresenter.loginOut()
//            }
//        }

        layout.setOnBaseItemClick { position ->
            Log.e(TAG, "----- position = $position")
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
                DataSource.ABOUT -> ARouter.getInstance().build(RouterPath.UserCenter.ABOUT).navigation()
            }
        }
    }


    // TODO 优化展示获取的所有服务
    private fun getAllService(){
        val isCheck = TestService.checkEnabledAccessibilityService(BaseApplication.context)
        if (isCheck){
            val isRun = TestService.isRun(BaseApplication.context,"com.longyi.module_usercenter.ui.mine.MyAccessibilityService")
            val enabled = TestService.enabled("",BaseApplication.context)
            ToastUtils.show(requireActivity(),"已获取权限")
        }else{
            ToastUtils.show(requireActivity(),"未获取权限")
        }
    }
    override fun setTvTitleBackgroundColor() {
//        tv_title.setBackgroundColor(resources.getColor(R.color.colorPrimary))
//        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    private fun checkUserLogin() {
        mMineItems.clear()

        if (UserControl.isLogin()) {
            val username = PreferenceUtils.getString(BaseConstant.USER_NAME)
            val user = UserControl.getUserByName(username)
            Log.e(TAG,"当前user：$user")
            if (user == null){
                // 未登录
                Log.e(TAG,"当前处于未登录状态 user == null ")
                mToolBarLayoutTitle = "点击加号按钮登录"
                name.text = mToolBarLayoutTitle
                // 显示登录按钮
                fabButton.isGone = false
                mMineItems.addAll(DataSource.getFunData(false))
            }else{
                mToolBarLayoutTitle = "欢迎你，${user.username}"
                name.text = mToolBarLayoutTitle
                // 隐藏登录按钮
                fabButton.isGone = true
                // 刷新下方列表
                mMineItems.addAll(DataSource.getFunData(true))
            }
        } else {
            // 未登录
            mToolBarLayoutTitle = "点击加号按钮登录"
            name.text = mToolBarLayoutTitle
            // 显示登录按钮
            fabButton.isGone = false
            mMineItems.addAll(DataSource.getFunData(false))
            Log.e(TAG,"当前处于未登录状态 user.isLogin == false")
        }
        Log.e(TAG,"当前处于未登录状态 mMineItems.size:"+mMineItems.size)
        val valueList = arrayListOf<String>()
        val resIdList = arrayListOf<Int>()

        for (i in mMineItems){
            valueList.add(i.mName)
            resIdList.add(R.mipmap.ic_launcher)
        }
        // 移除所有view
        layout.removeAllViews()
        val attrs = ConfigAttrs() // 把全部参数的配置，委托给ConfigAttrs类处理。
        //参数 使用链式方式配置
        attrs.setValueList(valueList)  // 文字 list
            .setResIdList(resIdList) // icon list
            .setIconWidth(24)  //设置icon 的大小
            .setIconHeight(24)
            .setItemMarginTop(10)  //设置 全部item的间距
            .setItemMode(Mode.TEXT)
        layout.setConfigAttrs(attrs)
            .create() //
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

}
