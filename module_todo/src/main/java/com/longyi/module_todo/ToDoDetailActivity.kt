package com.longyi.module_todo

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Todo
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_to_do_detail.*

@Route(path = RouterPath.Todo.TODO_DETAIL, name = "ToDo 详情")
class ToDoDetailActivity : BaseActivity(),ToDoContract.View {

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
        if (intent.hasExtra(ParameterConstant.ToDo.todoBean)){
            todoBean = intent.getSerializableExtra(ParameterConstant.ToDo.todoBean) as Todo
        }else{
            ToastUtils.show(BaseApplication.context,"数据异常")
            finish()
        }
    }

    override fun initData() {
        tv_title.text = todoBean.title
        tv_desc.text = todoBean.content
        tv_date.text = todoBean.dateStr

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

    override fun showLoginSuccess(successMsg: String) {
        ToastUtils.show(BaseApplication.context,successMsg)
    }

    override fun showLoading() {}

    override fun hideLoading() {}
}
