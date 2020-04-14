package com.aba.core.rx

import com.aba.core.rx.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider : SchedulerProvider {

    val testScheduler: TestScheduler = TestScheduler()

    override val ioScheduler: Scheduler = testScheduler
    override val mainScheduler: Scheduler = testScheduler

}