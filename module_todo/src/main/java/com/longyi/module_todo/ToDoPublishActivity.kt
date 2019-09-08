package com.longyi.module_todo

import android.graphics.Color
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_todo_publish.*
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.model.Todo
import android.widget.Toast
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.example.lib_common.utils.DateUtils
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.bigkoo.pickerview.builder.OptionsPickerBuilder




@Route(path = RouterPath.Todo.TODO_PUBLISH, name = "TODO 发布页面")
class ToDoPublishActivity : BaseActivity(), ToDoContract.View {

    private lateinit var todoBean: Todo
    private var type = 0
    private var isEdit = false
    private var priority = 1
    private val mOptionsItems = listOf("工作","生活","娱乐")

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { ToDoPresenter() }

    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_todo_publish
    }

    override fun initView() {

        tv_date.setOnClickListener {
            //时间选择器
            TimePickerBuilder(this@ToDoPublishActivity,
                OnTimeSelectListener { date, _ ->
                    tv_date.text = DateUtils.getFormatTime(date)
                }).build().show()

        }

        tv_type.setOnClickListener {
            val pvOptions = OptionsPickerBuilder(this,
                OnOptionsSelectListener { options1, options2, options3, v ->
                    //返回的分别是三个级别的选中位置
                    val tx = mOptionsItems[options1]
                    type = options1+1
                    tv_type.text = tx
                })
                .setTitleText("类别选择")
                .setContentTextSize(20)//设置滚轮文字大小
                .build<Any>()

            pvOptions.setPicker(mOptionsItems)
            pvOptions.show()
        }
        btn_publish.setOnClickListener {
            if (isEdit) {
                mPresenter.postEditToDoInfo(
                    todoBean.id,
                    todoBean.title,
                    todoBean.content,
                    todoBean.dateStr,
                    type,
                    priority
                )
            } else {
                mPresenter.postToDoInfo(
                    et_title.text.toString(),
                    et_desc.text.toString(),
                    tv_date.text.toString(),
                    type,
                    priority
                )
            }
        }
    }

    override fun initData() {
        if (intent.hasExtra(ParameterConstant.ToDo.todoBean)) {
            isEdit = true
            todoBean = intent.getSerializableExtra(ParameterConstant.ToDo.todoBean) as Todo
            et_title.setText(todoBean.title)
            et_desc.setText(todoBean.content)
            tv_date.text = todoBean.dateStr
            priority = todoBean.priority

            var publishType = ""
            when (todoBean.type) {
                BaseConstant.TODO_TYPE_WORK -> {
                    publishType = mOptionsItems[0]
                    type = BaseConstant.TODO_TYPE_WORK
                }
                BaseConstant.TODO_TYPE_LIFE -> {
                    publishType = mOptionsItems[1]
                    type = BaseConstant.TODO_TYPE_LIFE
                }
                BaseConstant.TODO_TYPE_FUN -> {
                    publishType = mOptionsItems[2]
                    type = BaseConstant.TODO_TYPE_FUN
                }
            }

            tv_type.text = publishType
            btn_publish.text = "确认编辑"

        }
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context, errorMsg)
    }

    override fun showLoginSuccess(successMsg: String) {
        ToastUtils.show(BaseApplication.context, successMsg)
        finish()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
