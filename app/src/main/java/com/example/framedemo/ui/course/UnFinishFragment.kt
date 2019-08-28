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

    override fun initData() {
        mPresenter.getUnFinishList(page = mPage,type = mType,priority = mPriority)
    }

    override fun initView() {
        rv_un_finish.layoutManager = GridLayoutManager(activity,2)
        mAdapter = TodoAdapter(mUnFinishList)
        rv_un_finish.adapter = mAdapter

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getUnFinishList(page = mPage,type = mType,priority = mPriority)
        },rv_un_finish)
    }

    override fun setTvTitleBackgroundColor() {}

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showUnFinishList(list: MutableList<Todo>) {
        if (list.size > 0){
            mUnFinishList.addAll(list)
            mAdapter.loadMoreComplete()
        }else{
            mAdapter.loadMoreEnd()
        }

        if (mUnFinishList.isEmpty()){
            val emptyView = LayoutInflater.from(activity).inflate(R.layout.layout_empty,null)
            mAdapter.emptyView = emptyView
        }
        LogUtils.d("集合数据："+mUnFinishList.size)
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {}

    override fun hideLoading() {}
}