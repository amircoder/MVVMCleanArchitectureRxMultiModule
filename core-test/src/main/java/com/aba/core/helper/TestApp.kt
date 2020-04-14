package com.aba.core.helper

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector

open class TestApp: Application(), HasActivityInjector {

    private val fakeActivityInjector: AndroidInjector<Activity> = AndroidInjector { }

    override fun onCreate() {
        super.onCreate()
    }

    override fun activityInjector(): AndroidInjector<Activity> = fakeActivityInjector

}
