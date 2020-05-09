package com.aba.core.extension

import android.app.Activity
import android.app.NativeActivity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.aba.core.navigation.NavigatorActivity


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


fun Fragment.toastIt(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()


fun Fragment.getNavigatorActivity() = (activity as NavigatorActivity)