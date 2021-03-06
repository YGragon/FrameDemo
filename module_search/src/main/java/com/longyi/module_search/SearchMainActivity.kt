package com.longyi.module_search

import android.annotation.SuppressLint
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.Hotkey
import com.example.lib_common.model.SearchBean
import com.example.lib_common.model.SearchHistory
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.widget.flow.FlowAdapter
import kotlinx.android.synthetic.main.activity_search_main.*
import com.example.lib_common.widget.flow.FlowLayout
import androidx.recyclerview.widget.DividerItemDecoration
import autodispose2.AutoDispose
import autodispose2.AutoDispose.autoDisposable
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.keyboard.SoftKeyboardUtil
import com.example.lib_common.utils.rx.RxUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


@Route(path = RouterPath.Search.SEARCH_HOME,name = "搜索首页")
class SearchMainActivity : BaseActivity(),SearchContract.View {


    private lateinit var mSearchAdapter:SearchMainAdapter
    private lateinit var mSearchHistoryAdapter:SearchHistoryAdapter
    private var mSearchList = mutableListOf<SearchBean>()
    private var mSearchHistorys = mutableListOf<SearchHistory>()
    private var mHotKeys = mutableListOf<Hotkey>()


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

    @SuppressLint("AutoDispose")
    override fun initView() {

        iv_search_back.setOnClickListener { finish() }

        //设置搜索框直接展开显示。左侧有放大镜(在搜索框中) 右侧有叉叉 可以关闭搜索框
        // searchView.isIconified = false
        // 设置搜索框直接展开显示。左侧有放大镜(在搜索框外) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
        // searchView.setIconifiedByDefault(false)
        // 设置搜索框直接展开显示。左侧有无放大镜(在搜索框中) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
        searchView.onActionViewExpanded()
        searchView.queryHint = "输入关键字搜索文章"


        // 搜索框文字变化监听
        RxUtil.searchViewTextChanges(searchView)
            .debounce(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (!TextUtils.isEmpty(it)) {
                    // 保存到数据库中
                    mPresenter.saveSearchHistory(it)
                    // 搜索
                    mPresenter.getSearchResult(mPage, it)
                }
            }

        rv_search.layoutManager = LinearLayoutManager(this)
        mSearchAdapter = SearchMainAdapter(mSearchList)
        rv_search.adapter = mSearchAdapter
        // 加载头布局
        headerHot = LayoutInflater.from(this).inflate(R.layout.header_search_hot, null)
        headerHistory = LayoutInflater.from(this).inflate(R.layout.header_search_history, null)
        mSearchAdapter.addHeaderView(headerHot)
        mSearchAdapter.addHeaderView(headerHistory)
        mSearchAdapter.setOnItemClickListener { adapter, view, position ->
            ARouter.getInstance().build(RouterPath.Web.WEB_DETAIL).withString(ParameterConstant.Web.webUrl,mSearchList[position].link).navigation()
        }

        // 搜索历史列表
        val ivDelAllHistory = headerHistory.findViewById<ImageView>(R.id.iv_search_history_del_all)
        val rvSearchHistory = headerHistory.findViewById<RecyclerView>(R.id.rt_search_history)

        rvSearchHistory.layoutManager = LinearLayoutManager(this)
        rvSearchHistory.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        mSearchHistoryAdapter = SearchHistoryAdapter(mSearchHistorys)
        rvSearchHistory.adapter = mSearchHistoryAdapter
        mSearchHistoryAdapter.setOnItemClickListener { adapter, view, position ->
            val keyword = mSearchHistorys[position].keyWord?:""
            searchView.setQuery(keyword,false)
            mPresenter.getSearchResult(0, keyword)
        }
        mSearchHistoryAdapter.setOnItemChildClickListener { _, view, position ->
            // 删除某个item
            mPresenter.searchDao.delete(mSearchHistorys[position])
            mSearchHistorys.removeAt(position)
            mSearchHistoryAdapter.notifyItemRemoved(position)
            if (mSearchHistoryAdapter.itemCount <= 0){
                hideHistorys()
            }
        }
        // 全部清空搜索历史
        ivDelAllHistory.setOnClickListener {
            mPresenter.searchDao.deleteAll()
            hideHistorys()
        }

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
        mHotKeys.clear()
        mHotKeys.addAll(hotkeys)
        // 热搜
        val flSearchHot = headerHot.findViewById<FlowLayout>(R.id.fl_search_hot)
        flSearchHot.setAdapter(object : FlowAdapter<Hotkey>(mHotKeys) {

            override fun getView(position: Int, searchHotKey: Hotkey, parent: ViewGroup): View {
                val textView = TextView(this@SearchMainActivity)
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16f)
                textView.setBackgroundResource(R.drawable.shape_search_history_bg)
                textView.text = searchHotKey.name
                textView.setTextColor(resources.getColor(R.color.black_333))
                return textView
            }
        })
        // 设置 item 点击事件
        flSearchHot.setOnItemClickListener { position, adapter, parent ->
            val searchHotKey = mHotKeys[position]
            val keyword = searchHotKey.name
            searchView.setQuery(keyword,false)
            // 保存到数据库中
            mPresenter.saveSearchHistory(keyword)
            mPresenter.getSearchResult(0,keyword)
        }
    }

    override fun hideHotkeys() {
        mSearchAdapter.removeHeaderView(headerHot)
        mSearchAdapter.notifyDataSetChanged()
    }

    override fun showHistorys(searchHistory:MutableList<SearchHistory>) {
        mSearchHistorys.clear()
        mSearchHistorys.addAll(searchHistory)
        mSearchHistoryAdapter.notifyDataSetChanged()


    }

    override fun hideHistorys() {
        mSearchAdapter.removeHeaderView(headerHistory)
        mSearchAdapter.notifyDataSetChanged()
    }

    override fun showSearchResult(list: MutableList<SearchBean>) {
        mSearchAdapter.removeAllHeaderView()
        mSearchAdapter.notifyDataSetChanged()

        mSearchList.clear()
        mSearchList.addAll(list)
        mSearchAdapter.notifyDataSetChanged()

        SoftKeyboardUtil.hideKeyboard(searchView)
    }
    override fun showSearchEmptyResult() {
        mPresenter.getHistorys()
        ToastUtils.show(this,"暂未搜索到相关数据")

//        mSearchAdapter.removeAllHeaderView()
//        val emptyLayout = LayoutInflater.from(this).inflate(R.layout.layout_empty,null)
//        mSearchAdapter.emptyView = emptyLayout
//        mSearchAdapter.notifyDataSetChanged()

        SoftKeyboardUtil.hideKeyboard(searchView)
    }


    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }


}
