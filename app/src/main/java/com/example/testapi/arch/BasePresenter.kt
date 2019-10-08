package com.example.testapi.arch

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<T : BaseView>(val baseView: T) : CoroutineScope {

    private  val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    open fun finalize(){
        job.cancel()
    }

}