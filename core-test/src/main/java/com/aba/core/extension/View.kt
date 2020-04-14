package com.aba.core.extension

import android.view.View

infix fun View.isVisible(isVisible: Int) = visibility == isVisible