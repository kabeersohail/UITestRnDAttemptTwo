package com.example.uitestrndattempttwo

import android.app.Application
import androidx.annotation.VisibleForTesting
import com.example.uitestrndattempttwo.commandscheduler.CommandScheduler
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class UITestRnDApplication: BaseApplication() {

    @VisibleForTesting
    internal val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @VisibleForTesting
    internal var testerName: String = "Sohail"

    lateinit var commandScheduler: CommandScheduler

    override fun onCreate() {
        super.onCreate()
        commandScheduler = CommandScheduler()
    }

    @VisibleForTesting
    internal fun initializeColdFlow() {
//        commandScheduler.adminCommandCollector()
        testerName = "YES"
    }

}