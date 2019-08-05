package com.longyi.module_search

import android.os.Handler
import android.text.TextUtils
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
import com.example.lib_common.utils.keyboard.SoftKeyboardUtil


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

    override fun initView() {
        tv_search_text.postDelayed({
            SoftKeyboardUtil.hideKeyboard(et_keyword)
        },200)

        iv_search_back.setOnClickListener { finish() }
        tv_search_text.setOnClickListener {
            // TODO 封装
            val keyword = et_keyword.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(keyword)) {
                // 保存到数据库中
                mPresenter.saveSearchHistory(keyword)
                // 搜索
                mPresenter.getSearchResult(mPage,keyword)
            }
        }
//        et_keyword.addTextChangedListener(object :TextWatcher{
//            override fun afterTextChanged(s: Editable?) {
//                // TODO 使用 RxJava 实现 联想搜索
//                val keyword = s.toString().trim { it <= ' ' }
//                if (TextUtils.isEmpty(keyword)) {
//                    mPresenter.getSearchResult(mPage,keyword)
//                }
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//        })

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
        // 搜索历史列表
        val ivDelAllHistory = headerHistory.findViewById<ImageView>(R.id.iv_search_history_del_all)
        val rvSearchHistory = headerHistory.findViewById<RecyclerView>(R.id.rt_search_history)

        rvSearchHistory.layoutManager = LinearLayoutManager(this)
        rvSearchHistory.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        mSearchHistoryAdapter = SearchHistoryAdapter(mSearchHistorys)
        rvSearchHistory.adapter = mSearchHistoryAdapter
        mSearchHistoryAdapter.notifyDataSetChanged()
        mSearchHistoryAdapter.setOnItemChildClickListener { _, view, position ->
            when(view.id){
                R.id.tv_search_history_title -> {
                    // 搜索
                    mSearchHistorys[position].keyWord?.let { mPresenter.getSearchResult(0, it) }
                }
                R.id.iv_search_history_del -> {
                    // 删除某个item
                    mPresenter.searchDao.delete(mSearchHistorys[position])
                    mSearchHistoryAdapter.notifyItemRemoved(position)
                    if (mSearchHistoryAdapter.itemCount <= 0){
                        hideHistorys()
                    }
                }
            }
        }
        // 全部清空搜索历史
        ivDelAllHistory.setOnClickListener {
            mPresenter.searchDao.deleteAll()
            hideHistorys()
        }
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
    }



    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }


}
