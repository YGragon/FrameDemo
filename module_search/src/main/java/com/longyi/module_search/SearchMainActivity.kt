package com.longyi.module_search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Hotkey
import com.example.lib_common.model.SearchBean
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_search_main.*
import com.tencent.bugly.proguard.s


@Route(path = RouterPath.Search.SEARCH_HOME,name = "搜索首页")
class SearchMainActivity : BaseActivity(),SearchContract.View {


    private lateinit var mSearchAdapter:SearchMainAdapter
    private var mSearchList = mutableListOf<SearchBean>()
    private var mPage = 0
    private lateinit var headerHot: View
    private lateinit var headerHistory:View

    private val mPresenter by lazy { SearchPresenter() }

    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_search_main
    }

    override fun initView() {

        iv_search_back.setOnClickListener { finish() }
        tv_search_text.setOnClickListener {
            // TODO 封装
            val keyword = et_keyword.text.toString().trim { it <= ' ' }
            if (TextUtils.isEmpty(keyword)) {
                mPresenter.getSearchResult(mPage,keyword)
            }
            mPresenter.getSearchResult(mPage,et_keyword.text.toString())
        }
        et_keyword.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                // TODO 使用 RxJava 实现
                val keyword = s.toString().trim { it <= ' ' }
                if (TextUtils.isEmpty(keyword)) {
                    mPresenter.getSearchResult(mPage,keyword)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        rv_search.layoutManager = LinearLayoutManager(this)
        mSearchAdapter = SearchMainAdapter(mSearchList)
        rv_search.adapter = mSearchAdapter
        // 加载头布局
        headerHot = LayoutInflater.from(this).inflate(R.layout.header_search_hot, null)
        headerHistory = LayoutInflater.from(this).inflate(R.layout.header_search_history, null)
        mSearchAdapter.addHeaderView(headerHot)
        mSearchAdapter.addHeaderView(headerHistory)

        mSearchAdapter.notifyDataSetChanged()
    }

    override fun initData() {
        mPresenter.getHotKeys()
        mPresenter.getHistorys()
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showHotkeys(hotkeys: MutableList<Hotkey>) {

    }

    override fun hideHotkeys() {
        mSearchAdapter.removeHeaderView(headerHot)
    }

    override fun showHistorys(hotkeys: MutableList<Hotkey>) {

    }

    override fun hideHistorys() {
        mSearchAdapter.removeHeaderView(headerHistory)
    }

    override fun showSearchResult() {
        mSearchAdapter.removeAllHeaderView()
    }

    override fun hideSearchResult() {
        mSearchAdapter.addHeaderView(headerHot)
        mSearchAdapter.addHeaderView(headerHistory)
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }


}
