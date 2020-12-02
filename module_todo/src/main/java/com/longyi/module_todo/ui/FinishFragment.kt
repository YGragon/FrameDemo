package com.longyi.module_todo.ui


import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Todo
import com.example.lib_common.utils.ToastUtils
import com.longyi.module_todo.R
import com.longyi.module_todo.contract.ToDoContract
import com.longyi.module_todo.presenter.ToDoPresenter
import kotlinx.android.synthetic.main.fragment_finish.*

/**
 * 已完成页面
 *
 */
class FinishFragment : BaseFragment(), ToDoContract.View {


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
        return R.layout.fragment_finish
    }

    override fun initData() {
    }

    override fun initView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        rv_finish.layoutManager = linearLayoutManager
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

        rv_finish.addOnScrollListener(object :RecyclerView.OnScrollListener(){
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

    // LinearLayoutManager 获取滑动的高度
    private fun getScrolledYDistance(layoutManager: LinearLayoutManager): Int {
        val position = layoutManager.findFirstVisibleItemPosition()
        val firstVisibleChildView = layoutManager.findViewByPosition(position)
        val itemHeight = firstVisibleChildView!!.height
        return position * itemHeight - firstVisibleChildView.top
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun onResume() {
        super.onResume()
        mUnFinishList.clear()
        mPresenter.getList(page = 0,status = 1)
    }
    override fun fragmentShowToUser() {

    }

    override fun fragmentHideToUser() {}

    override fun showError(errorMsg: String) {
        srl_refresh_layout.isRefreshing = false
        ToastUtils.show(BaseApplication.context,errorMsg)
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

        if (mUnFinishList.isEmpty()){
            val emptyView = LayoutInflater.from(activity).inflate(R.layout.layout_empty,null)
            mAdapter.emptyView = emptyView
        }
        srl_refresh_layout.isRefreshing = false
        mAdapter.notifyDataSetChanged()
    }


    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}
