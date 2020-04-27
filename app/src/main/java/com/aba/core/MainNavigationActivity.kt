package com.aba.core


import com.aba.core.view.FullScreenActivity
import javax.inject.Inject

class MainNavigationActivity @Inject constructor(): FullScreenActivity()  {




    override val contentResourceId: Int
        get() = R.layout.activity_main

    // Features needed to be added
    // Flavors motion-layout


}