package com.gamerbill.kotlinarchitecturedemo

import androidx.fragment.app.testing.launchFragmentInContainer
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import androidx.test.rule.ActivityTestRule
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.ClientDashboardFragment

@RunWith(AndroidJUnit4::class)
class ClientDashboardFragmentUiTest {
    @get:Rule
    val activityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        launchFragmentInContainer<ClientDashboardFragment>()
    }

    @Test
    fun testUi() {
        onView(withId(R.id.listView)).check(ViewAssertions.matches(isDisplayed()))
    }
}