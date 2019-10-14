package com.example.testapi.robot

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import com.example.testapi.R
import com.example.testapi.post.view.MainActivity
import org.hamcrest.Matchers.not

class MainActivityRobot{

    fun showList(rule : ActivityTestRule<MainActivity>){
        onView(withId(R.id.list_return))
            .inRoot(withDecorView(not(rule.activity.window.decorView)))
    }

    fun scrollList(){
        onView(withId(R.id.list_return))
            .perform(scrollTo())
    }

}