package com.example.uitestrndattempttwo

import android.app.Application
import androidx.annotation.VisibleForTesting
import com.example.uitestrndattempttwo.commandscheduler.CommandScheduler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BaseApplication: Application() {

    @VisibleForTesting
    internal val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @VisibleForTesting
    internal var testerName: String = "Sohail"

    lateinit var commandScheduler: CommandScheduler

    override fun onCreate() {
        super.onCreate()
        commandScheduler = CommandScheduler()
        initializeColdFlow()
    }

    @VisibleForTesting
    internal fun initializeColdFlow() {
//        commandScheduler.adminCommandCollector()
        testerName = "YES"
    }
}