package com.longyi.module_course.course


import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.launcher.ARouter
import com.longyi.module_course.course.presenter.TodoPresenter
import com.longyi.module_course.course.contract.TodoContract
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Todo
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import com.longyi.module_course.R
import kotlinx.android.synthetic.main.fragment_finish.*

/**
 * 已完成页面
 *
 */
class FinishFragment : BaseFragment(), TodoContract.View {


    private var mUnFinishList = mutableListOf<Todo>()
    private lateinit var mAdapter: TodoAdapter

    private var mPage = 1

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { TodoPresenter() }
    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_finish
    }

    override fun initData() {
    }

    override fun initView() {
        rv_finish.layoutManager = LinearLayoutManager(activity)
        mAdapter = TodoAdapter(mUnFinishList)
        rv_finish.adapter = mAdapter

        srl_refresh_layout.setOnRefreshListener {
            mUnFinishList.clear()
            mPage = 0
            mPresenter.getList(page = mPage,status = 1)
        }

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getList(page = mPage,status = 1)
        },rv_finish)

        mAdapter.setOnItemClickListener { _, _, position ->
            ARouter.getInstance().build(RouterPath.Todo.TODO_DETAIL)
                .withSerializable(ParameterConstant.ToDo.todoBean,mUnFinishList[position])
                .navigation()
        }
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun fragmentShowToUser() {
        mUnFinishList.clear()
        mPresenter.getList(page = 0,status = 1)
    }

    override fun fragmentHideToUser() {
    }

    override fun showError(errorMsg: String) {
        srl_refresh_layout.isRefreshing = false
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showList(curPage: Int, totalPage: Int, list: MutableList<Todo>) {
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

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}
