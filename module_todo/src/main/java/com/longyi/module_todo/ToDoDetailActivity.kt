package com.longyi.module_todo

import android.graphics.Color
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isGone
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Todo
import com.example.lib_common.utils.ToastUtils
import com.longyi.module_todo.contract.ToDoContract
import com.longyi.module_todo.presenter.ToDoPresenter
import kotlinx.android.synthetic.main.activity_to_do_detail.*

@Route(path = RouterPath.Todo.TODO_DETAIL, name = "ToDo 详情")
class ToDoDetailActivity : BaseActivity(),
    ToDoContract.View {

    private lateinit var todoBean: Todo

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { ToDoPresenter() }
    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_to_do_detail
    }

    override fun initView() {
        initToolbar()
        if (intent.hasExtra(ParameterConstant.ToDo.todoBean)){
            todoBean = intent.getSerializableExtra(ParameterConstant.ToDo.todoBean) as Todo
        }else{
            ToastUtils.show(BaseApplication.context,"数据异常")
            finish()
        }
    }
    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "TODO详情"
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }
    override fun initData() {
        tv_title.text = "标题：\r\n"+todoBean.title
        tv_desc.text = "内容：\r\n"+todoBean.content
        tv_date.text = "开始时间："+todoBean.dateStr

        if (todoBean.completeDate != null){
            tv_end_date?.isGone = false
            tv_end_date.text = "完成时间："+todoBean.completeDateStr

        }else{
            tv_end_date?.isGone = true
        }
        when {
            todoBean.type == BaseConstant.TODO_TYPE_WORK -> tv_type.text = "类型：工作"
            todoBean.type == BaseConstant.TODO_TYPE_LIFE -> tv_type.text = "类型：生活"
            todoBean.type == BaseConstant.TODO_TYPE_FUN -> tv_type.text = "类型：娱乐"
            else -> tv_type.text = "类型：未知（${todoBean.type}）"
        }

        when {
            todoBean.priority == 1 -> {
                tv_priority.text = "重要程度：重要"
                tv_priority.setTextColor(Color.RED)
            }
            todoBean.priority == 2 -> {
                tv_priority.text = "重要程度：一般"
                tv_priority.setTextColor(Color.BLUE)
            }
            else -> {
                tv_priority.text = "重要程度：很普通"
                tv_priority.setTextColor(Color.GREEN)
            }
        }
        btn_edit.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Todo.TODO_PUBLISH)
                .withSerializable(ParameterConstant.ToDo.todoBean,todoBean)
                .navigation()
        }
        btn_delete.setOnClickListener {
            mPresenter.postDeleteToDoInfo(todoBean.id)
        }

        btn_un_complete.setOnClickListener {
            mPresenter.postUpdateStatusToDoInfo(todoBean.id,0)
        }

        btn_complete.setOnClickListener {
            mPresenter.postUpdateStatusToDoInfo(todoBean.id,1)
        }
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showSuccess(successMsg: String) {
        ToastUtils.show(BaseApplication.context,successMsg)
        finish()
    }

    override fun showList(curPage: Int, totalPage: Int, list: MutableList<Todo>) {}

    override fun showLoading() {}

    override fun hideLoading() {}
}
