package com.example.urbandictionarysampleapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.urbandictionarysampleapp.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)

class MainActivityInstrumentedTest {

    private lateinit var search: String

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        search = "wat"
    }

    /**
     * Types the search keyword in the EditView, then it press search in the keyboard and wait for 5 seconds.
     * Checks if the RecyclerView was populated with the search parameter
     */
    @Test
    fun checkRecyclerViewIsPopulated() {
        onView(withId(R.id.search)).perform(typeText(search))
        onView(withId(R.id.search)).perform(pressImeActionButton())
        Thread.sleep(5000)
        onView(withId(R.id.definition_list)).check(matches(hasDescendant(withText(search))))
    }
}


