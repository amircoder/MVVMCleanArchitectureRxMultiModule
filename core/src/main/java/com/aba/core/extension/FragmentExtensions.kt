package com.aba.core.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


inline fun <T>Fragment.observeLiveData(
    liveData: LiveData<T>,
    crossinline onChanged: (liveData: T) -> Unit
){
    liveData.observe(this, Observer {
        it?.let {
            onChanged(it)
        }
    })
}