package com.example.framedemo.ui.course

import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.framedemo.R
import com.example.framedemo.ui.course.presenter.TodoPresenter
import com.example.framedemo.ui.mine.contract.TodoContract
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.model.Todo
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.fragment_un_finish.*
import android.widget.Toast
import android.view.Gravity
import com.example.lib_common.widget.popupview.ToDoPopup
import razerdp.basepopup.QuickPopupConfig
import razerdp.basepopup.QuickPopupBuilder

/**
 * 未完成
 */
class UnFinishFragment:BaseFragment(),TodoContract.View {


    private var mUnFinishList = mutableListOf<Todo>()
    private lateinit var mAdapter:TodoAdapter

    private var mPage = 1
    private var mType = 1
    private var mPriority = 1

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { TodoPresenter() }
    init {
        mPresenter.attachView(this)
    }
    override fun getLayoutId(): Int {
        return R.layout.fragment_un_finish
    }

    override fun initData() {}

    override fun initView() {
        rv_un_finish.layoutManager = GridLayoutManager(activity,2)
        mAdapter = TodoAdapter(mUnFinishList)
        rv_un_finish.adapter = mAdapter

        srl_refresh_layout.setOnRefreshListener {
            mUnFinishList.clear()
            mPage = 0
            mPresenter.getUnFinishList(page = mPage,type = mType,priority = mPriority)
        }

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getUnFinishList(page = mPage,type = mType,priority = mPriority)
        },rv_un_finish)

        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            ToastUtils.show(BaseApplication.context, "开发中...")
//            ToDoPopup(BaseApplication.context).showPopupWindow(R.id.iv_more)
        }
    }

    override fun setTvTitleBackgroundColor() {}

    override fun fragmentShowToUser() {
        mPresenter.getUnFinishList(page = mPage,type = mType,priority = mPriority)
    }

    override fun fragmentHideToUser() {}

    override fun showError(errorMsg: String) {
        srl_refresh_layout.isRefreshing = false
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showUnFinishList(curPage:Int, totalPage:Int, list: MutableList<Todo>) {
        when (curPage) {
            in 1..totalPage -> {
                mUnFinishList.addAll(list)
                mAdapter.loadMoreComplete()
            }
            else -> {
                mUnFinishList.addAll(list)
                mAdapter.loadMoreEnd()
            }
        }

        if (mUnFinishList.isEmpty()){
            val emptyView = LayoutInflater.from(activity).inflate(R.layout.layout_empty,null)
            mAdapter.emptyView = emptyView
        }
        LogUtils.d("集合数据："+mUnFinishList.size)
        srl_refresh_layout.isRefreshing = false
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {}

    override fun hideLoading() {}
}