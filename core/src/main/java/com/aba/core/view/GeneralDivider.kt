package com.aba.core.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import com.aba.core.R

class GeneralDivider: View {
    constructor(context: Context?) : super(context){
        initialize()

    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initialize()

    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        initialize()

    }
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes){
        initialize()
    }

    private fun initialize() {
        context?.let {
            setBackgroundColor(resources.getColor(R.color.colorAccent))
        }

        val customLayoutParams = LinearLayout.LayoutParams(
            MATCH_PARENT,
            resources.getDimension(R.dimen.divider_default).toInt()
        )
        customLayoutParams.marginEnd = resources.getDimension(R.dimen.margin_small).toInt()
        customLayoutParams.marginStart = resources.getDimension(R.dimen.margin_small).toInt()
        customLayoutParams.bottomMargin = resources.getDimension(R.dimen.margin_small).toInt()
        layoutParams = customLayoutParams
    }
}