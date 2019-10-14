package com.example.testapi

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.testapi.post.view.MainActivity
import com.example.testapi.robot.MainActivityRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule =
        ActivityTestRule(MainActivity::class.java)

    fun viewer(func: MainActivityRobot.() -> Unit) = MainActivityRobot()
        .apply { func() }

    @Test
    fun RecyclerScrollTest(){
        viewer {
            showList(activityTestRule)
            scrollList()
        }
    }
}