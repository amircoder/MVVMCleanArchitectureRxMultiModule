package com.aba.core.rx

import com.aba.core.rx.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers


class TrampolineSchedulerProvider: SchedulerProvider {

    override val ioScheduler: Scheduler = Schedulers.trampoline()
    override val mainScheduler: Scheduler = Schedulers.trampoline()

}