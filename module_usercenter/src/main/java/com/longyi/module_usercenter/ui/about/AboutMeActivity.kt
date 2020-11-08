package com.longyi.module_usercenter.ui.about

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.google.android.material.appbar.AppBarLayout
import com.jaeger.library.StatusBarUtil
import com.longyi.module_usercenter.R
import kotlinx.android.synthetic.main.activity_about_me.*

@Route(path = RouterPath.UserCenter.ABOUT_ME,name = "关于me")
class AboutMeActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_about_me
    }

    override fun initView() {
//        window.goEdgeToEdge()

        initToolbar()


        // When the AppBarLayout progress changes, snap MotionLayout to the current progress
        val listener = AppBarLayout.OnOffsetChangedListener { appBar, verticalOffset ->
            // convert offset into % scrolled
            val seekPosition = -verticalOffset / appBar.totalScrollRange.toFloat()
            // inform both both MotionLayout and CutoutImage of the animation progress.
            motion_layout.progress = seekPosition
            background.translationProgress = (100 * seekPosition).toInt()
        }
        appbar_layout.addOnOffsetChangedListener(listener)

        // get the collapsed height from the motion layout specified in XML
        val desiredToolbarHeight = motion_layout.minHeight

        // Set two guidelines in the collapsed state for displaying a scrim based on the inset. Also
        // resize the MotionLayout when collapsed to add the inset height.
        ViewCompat.setOnApplyWindowInsetsListener(motion_layout) { _, insets: WindowInsetsCompat ->
            // resize the motionLayout in collapsed state to add the needed inset height
            val insetTopHeight = insets.systemWindowInsetTop
            motion_layout.minimumHeight = desiredToolbarHeight + insetTopHeight

            // modify the end ConstraintSet to set a guideline at the top and bottom of inset
            val endConstraintSet = motion_layout.getConstraintSet(R.id.collapsed)
            // this guideline is the bottom of the inset area
            endConstraintSet.setGuidelineEnd(R.id.inset, desiredToolbarHeight)
            // this guideline is the top of the inset area (top of screen)
            endConstraintSet.setGuidelineEnd(R.id.collapsed_top, desiredToolbarHeight + insetTopHeight)

            // set the guideline for the start constraint set as well
            val startConstraintSet = motion_layout.getConstraintSet(R.id.expanded)
            startConstraintSet.setGuidelineBegin(R.id.collapsed_top, insetTopHeight)

            insets
        }
    }

    override fun initData() {
    }

    /**
     * Set various flags to go edge to edge
     */
    private fun Window.goEdgeToEdge() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
        }
        // TODO: replace this with non-deprecated edge to edge option
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    override fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageView(this, null)
    }


    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "关于我的信息"
        toolbar.setBackgroundColor(resources.getColor(R.color.transparent))

        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }
}
