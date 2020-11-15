package com.longyi.module_usercenter.ui.func

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.framedemo.data.bean.MineItemBean
import com.example.lib_common.model.Collect
import com.longyi.module_usercenter.R

/**
 * 新功能列表adapter
 */
class FuncMainAdapter(funcList:MutableList<MineItemBean>):BaseQuickAdapter<MineItemBean, BaseViewHolder>(R.layout.item_fun_main,funcList) {
    override fun convert(helper: BaseViewHolder?, item: MineItemBean) {

        helper?.setImageResource(R.id.iv_func_icon,item.mIconStr.toInt())
        helper?.setText(R.id.tv_func_name,item.mName)

    }
}