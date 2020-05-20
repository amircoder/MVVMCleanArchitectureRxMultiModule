package com.aba.core


import android.os.Bundle
import androidx.navigation.ActivityNavigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import com.aba.core.navigation.NavigatorActivity
import com.aba.core.view.FullScreenActivity
import javax.inject.Inject

class MainNavigationActivity @Inject constructor() : FullScreenActivity(), NavigatorActivity {


    override val contentResourceId: Int
        get() = R.layout.activity_main


    override fun navigateToDetail(bundle: Bundle, extras: FragmentNavigator.Extras) {
        findNavController(R.id.nav_host_fragment)
            .navigate(R.id.action_searchFragment_to_detailFragment, bundle, null, extras)
    }


    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }

    // Features needed to be added
    // Flavors motion-layout


}