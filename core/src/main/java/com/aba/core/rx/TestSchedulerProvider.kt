package com.aba.core.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider : SchedulerProvider {

    val testScheduler: TestScheduler = TestScheduler()

    override val ioScheduler: Scheduler = testScheduler
    override val mainScheduler: Scheduler = testScheduler
    override val computation: Scheduler = testScheduler

}