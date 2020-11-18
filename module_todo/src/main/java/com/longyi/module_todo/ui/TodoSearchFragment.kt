package com.longyi.module_todo.ui

import android.annotation.SuppressLint
import android.text.TextUtils
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.launcher.ARouter
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.runRxViewModel
import com.example.lib_common.model.Todo
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.utils.rx.RxUtil
import com.longyi.module_todo.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_todo_publish.*
import kotlinx.android.synthetic.main.fragment_todo_search.*
import kotlinx.android.synthetic.main.fragment_un_finish.*
import java.util.concurrent.TimeUnit

class TodoSearchFragment : BaseFragment() {

    private var mSearchList = mutableListOf<Todo>()
    private lateinit var mAdapter: TodoAdapter

    private var mPage = 1
    private var mType = 1
    private var mPriority = 1
    private var mStatus = 1
    private var mOrderby = 4 // 默认

    private val mStatusItems  = listOf("未完成", "已完成")
    private val mTypeItems = listOf("工作","生活","娱乐")
    private val mPriorityItems = listOf("重要", "一般", "很普通")
    private val mTimeOrderItems = listOf("完成日期顺序", "完成日期逆序", "创建日期顺序", "创建日期逆序(默认)")


    override fun getLayoutId(): Int {
        return R.layout.fragment_todo_search
    }

    override fun initData() {
    }

    override fun initView() {
        initListener()

        rv_todo_search.layoutManager = LinearLayoutManager(requireActivity())
        mAdapter = TodoAdapter(mSearchList)
        rv_todo_search.adapter = mAdapter


        mAdapter.setOnLoadMoreListener({
            mPage++
            getList(page = mPage, status = mStatus, orderby = mOrderby, type = mType, priority = mPriority)
        }, rv_todo_search)

        mAdapter.setOnItemClickListener { _, _, position ->
            ARouter.getInstance().build(RouterPath.Todo.TODO_DETAIL)
                .withSerializable(ParameterConstant.ToDo.todoBean, mSearchList[position])
                .navigation()
        }
    }

    @SuppressLint("AutoDispose")
    private fun initListener() {
        sp_type.setOnClickListener {
            selectType()
        }
        sp_status.setOnClickListener {
            selectStatus()
        }
        sp_priority.setOnClickListener {
            selectPriority()
        }
        sp_time_order.setOnClickListener {
            selectDateOrder()
        }
    }

    private fun selectType() {
        val pvOptions = OptionsPickerBuilder(requireContext(),
            OnOptionsSelectListener { options1, options2, options3, v ->
                val tx = mTypeItems[options1]
                mType = options1 + 1
                sp_type.text = tx

                getList(page = mPage, status = mStatus, orderby = mOrderby, type = mType, priority = mPriority)
            })
            .setTitleText("类型")
            .setContentTextSize(20)
            .build<Any>()

        pvOptions.setPicker(mTypeItems)
        pvOptions.show()

    }

    private fun selectStatus() {
        val pvOptions = OptionsPickerBuilder(requireContext(),
            OnOptionsSelectListener { options1, options2, options3, v ->
                val tx = mStatusItems[options1]
                mStatus = options1
                sp_status.text = tx

                getList(page = mPage, status = mStatus, orderby = mOrderby, type = mType, priority = mPriority)
            })
            .setTitleText("状态")
            .setContentTextSize(20)
            .build<Any>()

        pvOptions.setPicker(mStatusItems)
        pvOptions.show()

    }

    private fun selectDateOrder() {
        val pvOptions = OptionsPickerBuilder(requireContext(),
            OnOptionsSelectListener { options1, options2, options3, v ->
                val tx = mTimeOrderItems[options1]
                mOrderby = options1 + 1
                sp_time_order.text = tx

                getList(page = mPage, status = mStatus, orderby = mOrderby, type = mType, priority = mPriority)
            })
            .setTitleText("时间排序")
            .setContentTextSize(20)
            .build<Any>()

        pvOptions.setPicker(mTimeOrderItems)
        pvOptions.show()

    }

    private fun selectPriority() {
        val pvOptions = OptionsPickerBuilder(requireContext(),
            OnOptionsSelectListener { options1, options2, options3, v ->
                val tx = mPriorityItems[options1]
                mPriority = options1 + 1
                sp_priority.text = tx

                getList(page = mPage, status = mStatus, orderby = mOrderby, type = mType, priority = mPriority)
            })
            .setTitleText("重要程度")
            .setContentTextSize(20)
            .build<Any>()

        pvOptions.setPicker(mPriorityItems)
        pvOptions.show()
    }

    override fun setTvTitleBackgroundColor() {}

    override fun fragmentShowToUser() {}

    override fun fragmentHideToUser() {}

    private fun getList(page: Int, status: Int, type: Int, priority: Int, orderby: Int) {
        runRxLambda(RetrofitManager.service.getTodoList(page, status, type, priority, orderby), {
            if (it.errorCode == 0) {
                showList(it.data.curPage, it.data.pageCount, it.data.datas)
            } else {
                showError(it.errorMsg)
            }
        }, {
            val errorMsg = ExceptionHandle.handleException(it)
            showError(errorMsg)
        }, {
//            addSubscription(it)
        })
    }

    private fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context, errorMsg)
    }

    private fun showList(curPage: Int, totalPage: Int, list: MutableList<Todo>) {
        when (curPage) {
            in 1..totalPage -> {
                mSearchList.addAll(list)
                mAdapter.loadMoreComplete()
            }
            else -> {
                mSearchList.addAll(list)
                mAdapter.loadMoreEnd()
            }
        }

        if (mSearchList.isEmpty()) {
            val emptyView = LayoutInflater.from(activity).inflate(R.layout.layout_empty, null)
            mAdapter.emptyView = emptyView
        }
        mAdapter.notifyDataSetChanged()
    }
}