package comharis.belajarandroiddasar

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering.Context


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//
//    @Before
//    fun setUp() {
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
//    @After
//    fun tearDown() {
//        mainActivityScenario.close()
//    }


    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSayHello() {

        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        val name = "Haris"

        onView(withId(R.id.nameEt))
            .perform(ViewActions.typeText(name))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.loginBtn))
            .perform(ViewActions.click())

        onView(withId(R.id.registerTv))
            .check(matches(withText(context.getString(R.string.registerTv, name))))

        Thread.sleep(2000)
    }
}