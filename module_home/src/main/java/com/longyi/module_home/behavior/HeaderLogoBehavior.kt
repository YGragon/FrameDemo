package com.longyi.module_home.behavior

import android.R
import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlin.math.abs


/**
 *
 */
//class HeaderLogoBehavior: CoordinatorLayout.Behavior<View> {

//    constructor(context: Context): super(){
//
//    }
//
//    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
//
//    }
//
//    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(context, attributeSet, defStyleAttr){
//
//    }
//
//    init {
//
//    }
//
//    override fun layoutDependsOn(
//        parent: CoordinatorLayout,
//        child: View,
//        dependency: View
//    ): Boolean {
//        return dependency != null && dependency.id == R.id.image
//
//    }
//
//    override fun onDependentViewChanged(
//        parent: CoordinatorLayout,
//        child: View,
//        dependency: View
//    ): Boolean {
//        if (dependency != null && dependency.id == R.id.image) {
//            val resources: Resources = dependency.resources
//            val progress: Float = 1f -
//                    abs(
//                        dependency.translationY / (dependency.height - resources.getDimension(
//                            R.dimen.collapsed_header_height
//                        ))
//                    )
//            val tv = child.findViewById<TextView>(R.id.toolbar_tv)
//            tv.alpha = progress
//            return true
//        }
//        return false
//
//    }
//}