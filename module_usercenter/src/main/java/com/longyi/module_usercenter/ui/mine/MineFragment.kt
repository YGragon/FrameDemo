package com.longyi.module_usercenter.ui.mine


import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
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
import com.example.lib_common.utils.PreferenceUtils
import com.example.lib_common.utils.ToastUtils
import com.longyi.module_usercenter.R
import com.longyi.module_usercenter.ui.login.LoginContract
import com.longyi.module_usercenter.ui.login.LoginPresenter
import com.tencent.bugly.beta.Beta
import kotlinx.android.synthetic.main.fragment_mine.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * 用户中心
 *
 */
@Route(path =  RouterPath.UserCenter.MINE,name = "我的")
class MineFragment : BaseFragment(), MineContract.View, LoginContract.View {


    private val TAG = "MineFragment"
    private lateinit var mMineAdapter:MineAdapter
    private lateinit var mItemDatas:MutableList<MineItemBean>
    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { MinePresenter() }
    private val mLoginPresenter by lazy { LoginPresenter() }

    init {
        mPresenter.attachView(this)
        mLoginPresenter.attachView(this)

    }

    companion object {
        fun newInstance() = MineFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initData() {
        tv_login.setOnClickListener {
            if (UserControl.isLogin()){
                val userName = PreferenceUtils.getString(BaseConstant.USER_NAME)
                ToastUtils.show(BaseApplication.context,"当前登录的用户是：$userName")
            }else{
                ARouter.getInstance().build(RouterPath.UserCenter.LOGIN).navigation()
            }
        }

    }

    override fun initView() {
        checkUserLogin()

        rv_mine_list.layoutManager = LinearLayoutManager(activity)
        mMineAdapter = MineAdapter(mItemDatas)
        rv_mine_list.adapter = mMineAdapter
        mMineAdapter.notifyDataSetChanged()

        mMineAdapter.setOnItemClickListener { adapter, view, position ->
            when(mItemDatas[position].mID){
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

    // TODO 提供 接口给外部(首页收藏、详情收藏)判断用户是否登录
    private fun checkUserLogin() {
        if (UserControl.isLogin()) {
            val username = PreferenceUtils.getString(BaseConstant.USER_NAME)
            val user = UserControl.getUserByName(username)
            if (user == null){
                // 未登录
                Log.e(TAG,"当前处于未登录状态")
            }else{
                mLoginPresenter.postLoginInfo(user.username,user.password)

            }
        } else {
            // 未登录
            Log.e(TAG,"当前处于未登录状态")
        }
    }
    override fun showLoginSuccess(successMsg: String) {
        val username = PreferenceUtils.getString(BaseConstant.USER_NAME)
        tv_login.text = "欢迎你，$username"

        // 刷新下方列表
        mItemDatas = DataSource.getFunData(true)
        mMineAdapter.notifyDataSetChanged()
    }
    override fun showLoginError(errorMsg: String) {
        tv_login.text = "点击登录"
        mItemDatas = DataSource.getFunData(false)
        mMineAdapter.notifyDataSetChanged()
    }

    override fun fragmentShowToUser() {
        if (isAdded){
            checkUserLogin()
        }
    }

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
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        super.onPause()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onMessageEvent(event: LoginEvent) {
        checkUserLogin()
    }

}
