package com.aba.core

import com.aba.core.view.FullScreenActivity

class MainActivity: FullScreenActivity() {

    override val contentResourceId: Int
        get() = R.layout.activity_main

    // features needed to be added
    // MVVM clean-architecture RX Flavors multi-binding motion-layout

}