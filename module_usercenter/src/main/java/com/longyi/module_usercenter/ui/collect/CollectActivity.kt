package com.longyi.module_usercenter.ui.collect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Collect
import com.example.lib_common.utils.ToastUtils
import com.longyi.module_usercenter.R
import kotlinx.android.synthetic.main.activity_collect.*

@Route(path = RouterPath.UserCenter.COLLECT,name = "收藏中心")
class CollectActivity : BaseActivity(),CollectContract.View {

    private var mCollects = mutableListOf<Collect>()
    private lateinit var mCollectAdapter:CollectAdapter
    private var mPage = 0

    private val mPresenter by lazy { CollectPresenter() }

    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_collect
    }

    override fun initView() {
        initToolbar()
        rv_collect.layoutManager = LinearLayoutManager(this)
        mCollectAdapter = CollectAdapter(mCollects)
        rv_collect.adapter = mCollectAdapter

        mCollectAdapter.setOnLoadMoreListener({
            mPage++
            mPresenter.getCollects(mPage)
        },rv_collect)

        mCollectAdapter.setOnItemChildClickListener { adapter, view, position ->
            when(view.id){
                R.id.layout_card -> {
                    val link = mCollects[position].link
                    mPresenter.toWebDetail(link)
                }
            }
        }
    }
    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "我的收藏"
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }
    override fun initData() {
        mPresenter.getCollects(mPage)
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(this,errorMsg)
    }

    override fun showLoadComplete(collects:MutableList<Collect>) {
        mCollects.addAll(collects)
        mCollectAdapter.loadMoreComplete()
        mCollectAdapter.notifyDataSetChanged()
    }

    override fun showLoadEnd(collects:MutableList<Collect>) {
        mCollects.addAll(collects)
        mCollectAdapter.loadMoreEnd()
        mCollectAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
