package com.longyi.module_usercenter.ui.mine

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.framedemo.data.bean.MineItemBean
import com.longyi.module_usercenter.R

/**
 * Mine adapter
 */
class MineAdapter(list:MutableList<MineItemBean>)
    : BaseQuickAdapter<MineItemBean,BaseViewHolder>(R.layout.item_mine,list) {
    override fun convert(helper: BaseViewHolder?, item: MineItemBean?) {
        helper?.setText(R.id.item_mine,item?.mName)
    }
}