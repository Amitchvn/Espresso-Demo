package com.example.unittestingexample.UnitTestMethods

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.espressorobot.MainActivity

import com.example.unittestingexample.R
import com.jraska.falcon.FalconSpoonRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {
    @get:Rule
    val mActivityTestRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val falconSpoonRule = FalconSpoonRule()

    @Test
    fun loginMissingEmailPassword() {
        login {
            clickLogin()
            screenShot(falconSpoonRule, "loginMissingEmailPassword")
            matchErrorText(string(R.string.missing_fields))
        }
    }

    @Test
    fun loginMissingPassword() {
        login {
            setEmail("mail@example.com")
            clickLogin()
            screenShot(falconSpoonRule, "loginMissingPassword")
            matchErrorText(string(R.string.missing_fields))

        }
    }

    @Test
    fun loginWrongPassword() {
        login {
            setEmail("mail@example.com")
            setPassword("wrong")
            clickLogin()
            screenShot(falconSpoonRule, "loginWrongPassword")
            matchErrorText(string(R.string.login_fail))
        }

    }

    @Test
    fun loginSuccess() {
        login {
            setEmail("mail@example.com")
            setPassword("pass")
            clickLogin()

            screenShot(falconSpoonRule, "loginSuccess")
            matchText(R.id.tvName, string(R.string.name_surname))
        }
    }

    private fun string(res: Int): String = mActivityTestRule.activity.getString(res)
}