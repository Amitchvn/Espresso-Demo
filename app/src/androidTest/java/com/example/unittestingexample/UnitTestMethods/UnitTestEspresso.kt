package com.example.unittestingexample.UnitTestMethods

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.unittestingexample.R
import org.junit.Test
import java.util.regex.Pattern.matches

class UnitTestEspresso {
    @Test
    fun greeterSaysHello() {
       /* onView(withId(R.id.name_field)).perform(typeText("Steve"));
        onView(withId(R.id.greet_button)).perform(click());
        onView(withText("Hello Steve!")).check(matches(isDisplayed()));*/
    }
}