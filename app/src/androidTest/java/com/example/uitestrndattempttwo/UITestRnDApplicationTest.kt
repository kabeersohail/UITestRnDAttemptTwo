package com.example.uitestrndattempttwo

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import io.mockk.verify
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class UITestRnDApplicationTest {

    private val uiTestApplication: UITestRnDApplication = ApplicationProvider.getApplicationContext()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun firstTest() = runTest {

        withContext(CoroutineScope(Dispatchers.IO).coroutineContext) { uiTestApplication.initializeColdFlow() }

        Assert.assertEquals("YES", uiTestApplication.testerName)

        verify(exactly = 1) { uiTestApplication.initializeColdFlow() }

    }

}

// Our own test runner - uses MockMyApplication as a mocked app class
class MyAndroidTestRunner : AndroidJUnitRunner() {
    @Throws(IllegalAccessException::class,
        ClassNotFoundException::class,
        InstantiationException::class)
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?,
    ): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}