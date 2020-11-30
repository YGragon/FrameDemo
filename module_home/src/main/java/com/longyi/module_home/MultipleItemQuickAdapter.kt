package com.longyi.module_home

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ImageView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.longyi.module_home.data.MultipleItem
import com.longyi.module_home.presenter.HomePresenter
import per.wsj.lib.RvParallaxImageView

/**
 * Created by Aller on 2020/11/18.
 */
class MultipleItemQuickAdapter(list:MutableList<MultipleItem>): BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>(list) {
    init {
        addItemType(MultipleItem.TEXT, R.layout.item_article)
        addItemType(MultipleItem.IMG, R.layout.image_view)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun convert(helper: BaseViewHolder?, multipleItem: MultipleItem?) {

        when(helper?.itemViewType){
            MultipleItem.TEXT ->{
                val item = multipleItem?.article!!
                helper.setText(R.id.tv_title,item.title)
                val author = if(item.shareUser.isNotEmpty()){item.shareUser}else{ item.author }
                helper.setText(R.id.tv_author,"作者: $author")
                helper.setText(R.id.tv_nice_date,item.niceDate)
                helper.setText(R.id.tv_super_chapter_name,item.superChapterName)

                if(item.fresh){
                    helper.setText(R.id.tv_fresh,"新")
                    helper.setVisible(R.id.tv_fresh,true)
                }else{
                    helper.setGone(R.id.tv_fresh,false)
                }

                if (item.collect){
                    helper.setImageResource(R.id.iv_like,R.mipmap.like)
                }else{
                    helper.setImageResource(R.id.iv_like,R.mipmap.unlike)
                }

                helper.addOnClickListener(R.id.tv_super_chapter_name)
                // 点击事件和 motionLayout的点击冲突
                helper.getView<ImageView>(R.id.iv_like).setOnTouchListener { v, event ->
                    mPresenter.bindLike(helper.adapterPosition-1, item.id,item.collect)
                    false
                }
//                helper.addOnClickListener(R.id.iv_like)
                helper.addOnClickListener(R.id.layout_card)
            }
            MultipleItem.IMG ->{
                val imageUrl = multipleItem?.imageData?.url!!
                helper.getView<RvParallaxImageView>(R.id.parallaxImageView).apply {
                    bindRecyclerView(recyclerView)
                    setController(GlideImageController(mContext, imageUrl))
                }
                val title = multipleItem?.imageData?.title
                helper.setText(R.id.tvTitle,title)
            }
        }

    }


    private lateinit var mPresenter: HomePresenter
    fun setPresenter(presenter: HomePresenter){
        this.mPresenter = presenter
    }
}