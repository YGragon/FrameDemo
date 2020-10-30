package com.longyi.module_todo

import android.graphics.Color
import android.util.Log
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
import androidx.appcompat.widget.Toolbar
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.example.lib_common.utils.DateUtils
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.example.lib_common.utils.rx.RxUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.BiFunction
import java.util.concurrent.TimeUnit


@Route(path = RouterPath.Todo.TODO_PUBLISH, name = "TODO 发布页面")
class ToDoPublishActivity : BaseActivity(), ToDoContract.View {

    private lateinit var todoBean: Todo
    private var type = 0
    private var isEdit = false
    private var priority = 1
    private val mOptionsItems = listOf("工作","生活","娱乐")
    private val mPriorityItems = listOf("重要","一般","很普通")

    private val disposables = CompositeDisposable()
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
        initToolbar()

        initListener()

    }

    private fun initListener() {
        // 时间选择器
        tv_date.setOnClickListener { selectDate() }

        tv_type.setOnClickListener { selectType() }

        tv_priority.setOnClickListener { selectPriority() }

        // 按钮设置默认不可用
        btn_publish.isEnabled = false
        // 监听 editText 变化，这里 textChanges 不能返回 Any
        val etTitle = RxUtil.textChanges(et_title)
        val etDesc = RxUtil.textChanges(et_desc)

        val subscribe7 = Observable.combineLatest(etTitle, etDesc, BiFunction<CharSequence?, CharSequence?, Boolean?> { t1, t2 ->
            val titleValid = t1!!.isNotEmpty()
            val descValid = t2!!.isNotEmpty()
            // 传递检验结果
            if (titleValid){
                ToastUtils.show(this,"标题为空")
            }else if (descValid){
                ToastUtils.show(this,"内容为空")
            }
            titleValid && descValid
        }).subscribe {
            // 设置按钮的可用状态
            btn_publish.isEnabled = it!!

        }
        disposables.add(subscribe7)

        val subscribe6 = RxUtil.clickView(btn_publish)
            .throttleFirst(1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.e("", "连续点击,控制间隔一秒处理一次结果")
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
        disposables.add(subscribe6)
    }

    private fun selectPriority() {
        val pvOptions = OptionsPickerBuilder(this,
            OnOptionsSelectListener { options1, options2, options3, v ->
                val tx = mPriorityItems[options1]
                priority = options1+1
                tv_priority.text = tx
            })
            .setTitleText("重要程度")
            .setContentTextSize(20)
            .build<Any>()

        pvOptions.setPicker(mPriorityItems)
        pvOptions.show()

    }

    private fun selectType() {
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

    private fun selectDate() {
        TimePickerBuilder(this@ToDoPublishActivity,
            OnTimeSelectListener { date, _ ->
                tv_date.text = DateUtils.getFormatTime(date)
            }).build().show()


    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "发布TODO任务"
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
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
        disposables.clear()
        mPresenter.detachView()
        super.onDestroy()
    }
}
