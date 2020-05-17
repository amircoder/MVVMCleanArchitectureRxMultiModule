package com.aba.core.extension

import android.animation.ValueAnimator
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aba.core.BuildConfig

fun View.hide() {
    visibility = View.GONE
}

fun View.smoothHide(){
    animateAlpha(1f, 0f)
}

fun View.smoothUncover(){
    animateAlpha(0f, 1f)
}


fun View.show() {
    visibility = View.VISIBLE
}


fun <VH: RecyclerView.ViewHolder>RecyclerView.setupLinearLayout(adapter: RecyclerView.Adapter<VH>){
    this.layoutManager = LinearLayoutManager(context)
    this.adapter = adapter
    setHasFixedSize(true)
}


fun RecyclerView.setupOnScrollOperations(onScrollUp: () -> Unit, onScrollDown: () -> Unit){

    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            when {
                dy > 15 -> onScrollUp()
                dy < -25 -> onScrollDown()
                else -> {
                    // Do nothing
                }
            }
            super.onScrolled(recyclerView, dx, dy)

        }
    })
}


private fun View.animateAlpha(start: Float, end: Float){
    val animator = ValueAnimator.ofFloat(start, end)
    animator.addUpdateListener{
        alpha = (it.animatedValue as Float)
        if (alpha == 0f)
            hide()
        else if (alpha == 1f)
            show()
    }.run {
        animator
    }.setDuration(BuildConfig.QUICK_ANIMATION_DURATION ).start()
}