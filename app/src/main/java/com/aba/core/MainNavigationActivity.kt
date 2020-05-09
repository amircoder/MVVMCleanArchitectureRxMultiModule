package com.aba.core


import androidx.navigation.findNavController
import com.aba.core.navigation.NavigatorActivity
import com.aba.core.view.FullScreenActivity
import javax.inject.Inject

class MainNavigationActivity @Inject constructor(): FullScreenActivity(), NavigatorActivity {




    override val contentResourceId: Int
        get() = R.layout.activity_main

    override fun navigateToDetail() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_searchFragment_to_detailFragment)
    }

    // Features needed to be added
    // Flavors motion-layout


}