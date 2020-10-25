package com.longyi.module_home


import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.Article

/**
 * 首页 adapter
 */
class HomeAdapter(list:MutableList<Article>)
    : BaseQuickAdapter<Article,BaseViewHolder>(R.layout.item_article,list) {
    override fun convert(helper: BaseViewHolder?, item: Article) {
        helper?.setText(R.id.tv_title,item.title)
        val author = if(item.shareUser.isNotEmpty()){item.shareUser}else{ item.author }
        helper?.setText(R.id.tv_author,"作者: $author")
        helper?.setText(R.id.tv_nice_date,item.niceDate)
        helper?.setText(R.id.tv_super_chapter_name,item.superChapterName)

        if(item.fresh){
            helper?.setText(R.id.tv_fresh,"新")
            helper?.setVisible(R.id.tv_fresh,true)
        }else{
            helper?.setGone(R.id.tv_fresh,false)
        }


        helper?.addOnClickListener(R.id.tv_super_chapter_name)
        helper?.addOnClickListener(R.id.iv_like)
        helper?.addOnClickListener(R.id.layout_card)

    }
}