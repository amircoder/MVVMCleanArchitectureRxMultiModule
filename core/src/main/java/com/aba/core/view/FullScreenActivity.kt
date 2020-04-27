package com.aba.core.view

import android.os.Bundle
import com.aba.core.base.BaseActivity
import com.aba.core.extension.makeFullScreen

abstract class FullScreenActivity: BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        this.makeFullScreen()
        super.onCreate(savedInstanceState)

    }
}