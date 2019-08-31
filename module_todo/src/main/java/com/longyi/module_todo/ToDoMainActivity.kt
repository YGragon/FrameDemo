package com.longyi.module_todo

import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.annotation.RequiresApi
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.utils.TextWatcherManager
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_todo_main.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.lib_common.constant.BaseConstant


@Route(path = RouterPath.Todo.TODO_PUBLISH, name = "TODO 发布页面")
class ToDoMainActivity : BaseActivity(),ToDoPublishContract.View {

    private var type = 0
    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { ToDoPublishPresenter() }
    init {
        mPresenter.attachView(this)
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_todo_main
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initView() {

        et_title.addTextChangedListener(object : TextWatcherManager() {
            override fun doOnAfterTextChanged(s: Editable?) {

            }
        })

        et_desc.addTextChangedListener(object : TextWatcherManager() {
            override fun doOnAfterTextChanged(s: Editable?) {

            }
        })

        val spinnerItems = arrayOf("工作", "生活", "娱乐")
        val spinnerAdapter = ArrayAdapter(BaseApplication.context, android.R.layout.simple_spinner_item, spinnerItems)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_todo_type.adapter = spinnerAdapter
        spinner_todo_type.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                type = when(position){
                    0 -> { BaseConstant.TODO_TYPE_WORK }
                    1 -> { BaseConstant.TODO_TYPE_LIFE }
                    2 -> { BaseConstant.TODO_TYPE_FUN }
                    else ->{ BaseConstant.TODO_TYPE_WORK }
                }
            }
        }
        tv_date.setOnClickListener {
            dp_date.visibility = View.VISIBLE
        }

        dp_date.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            val month = if (monthOfYear < 10){
                "0"+"${monthOfYear+1}"
            }else{
               "${monthOfYear+1}"
            }
            val day = if (dayOfMonth < 10){
                "0$monthOfYear"
            }else{
                dayOfMonth
            }
            tv_date.text = "$year-$month-$day"
            view.visibility = View.GONE
        }


        btn_publish.setOnClickListener {
            mPresenter.postToDoInfo(et_title.text.toString(),et_desc.text.toString(),tv_date.text.toString(),type,1)
        }
    }

    override fun initData() {
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showLoginSuccess(successMsg: String) {
        ToastUtils.show(BaseApplication.context,successMsg)
        finish()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
