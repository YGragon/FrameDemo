package com.longyi.module_todo.ui

import android.util.Log
import android.view.LayoutInflater
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.model.Todo
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.fragment_un_finish.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.longyi.module_todo.R
import com.longyi.module_todo.contract.ToDoContract
import com.longyi.module_todo.presenter.ToDoPresenter
import kotlinx.android.synthetic.main.fragment_un_finish.srl_refresh_layout

/**
 * 未完成
 */
class UnFinishFragment : BaseFragment(), ToDoContract.View {


    private var mUnFinishList = mutableListOf<Todo>()
    private lateinit var mAdapter: TodoAdapter

    private var mPage = 1

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { ToDoPresenter() }

    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_un_finish
    }

    override fun initData() {}

    override fun initView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        rv_un_finish.layoutManager = linearLayoutManager
        mAdapter = TodoAdapter(mUnFinishList)
        rv_un_finish.adapter = mAdapter

        srl_refresh_layout.setOnRefreshListener {
            mUnFinishList.clear()
            mPage = 0
            mPresenter.getList(page = mPage, status = 0)
        }

        mAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getList(page = mPage, status = 0)
        }, rv_un_finish)

        mAdapter.setOnItemClickListener { _, _, position ->
            ARouter.getInstance().build(RouterPath.Todo.TODO_DETAIL)
                .withSerializable(ParameterConstant.ToDo.todoBean, mUnFinishList[position])
                .navigation()
        }
        rv_un_finish.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (parentFragment is TodoHomeFragment) {
                    val todoHomeFragment = parentFragment as TodoHomeFragment
                    if (dy > 0) {
                        todoHomeFragment.hideFloatActionButton()

                    } else {
                        todoHomeFragment.showFloatActionButton()
                    }
                }
            }
        })
    }



    override fun setTvTitleBackgroundColor() {}

    override fun fragmentShowToUser() {}

    override fun onResume() {
        mUnFinishList.clear()
        mPresenter.getList(page = 0, status = 0)
        super.onResume()

    }

    override fun fragmentHideToUser() {}

    override fun showError(errorMsg: String) {
        srl_refresh_layout.isRefreshing = false
        ToastUtils.show(BaseApplication.context, errorMsg)
    }

    override fun showSuccess(successMsg: String) {}

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

        if (mUnFinishList.isEmpty()) {
            val emptyView = LayoutInflater.from(activity).inflate(R.layout.layout_empty, null)
            mAdapter.emptyView = emptyView
        }
        LogUtils.d("集合数据：" + mUnFinishList.size)
        srl_refresh_layout.isRefreshing = false
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {}

    override fun hideLoading() {}
}