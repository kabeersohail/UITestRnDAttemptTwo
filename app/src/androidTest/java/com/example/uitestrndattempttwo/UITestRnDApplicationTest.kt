package com.example.uitestrndattempttwo

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
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

    private val baseApplication: BaseApplication = ApplicationProvider.getApplicationContext()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun firstTest()= runTest {


        Assert.assertEquals(1,1)
        withContext(CoroutineScope(Dispatchers.IO).coroutineContext) { baseApplication.initializeColdFlow() }

        Assert.assertEquals("YES", baseApplication.testerName)

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
        return super.newApplication(cl, MyCustomTestApplication_Application::class.java.name, context)
    }
}

@CustomTestApplication(BaseApplication::class)
interface MyCustomTestApplication