package com.aba.core.delegate

import androidx.fragment.app.Fragment
import com.aba.core.domain.model.SearchModel
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentBundleDelegate(private val key: String): ReadOnlyProperty<Fragment, SearchModel?> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): SearchModel? =
        thisRef.arguments?.getParcelable(key)
}