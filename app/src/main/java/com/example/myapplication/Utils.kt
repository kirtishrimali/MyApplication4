package com.example.myapplication

import android.app.Activity
import android.app.Application
import android.content.Intent


object Utils {
    private var sTheme: Int = 0

    val THEME_DEFAULT = 0
    val THEME_LIGHT = 1
    val THEME_DARK = 2

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    fun changeToTheme(activity: Activity,theme: Int) {
        sTheme = theme
//        activity.finish()
//        activity.startActivity(Intent(activity, activity.javaClass))

    }

    /** Set the theme of the activity, according to the configuration.  */
    fun onActivityCreateSetTheme(activity: Activity) {
        when (sTheme) {
            THEME_DEFAULT -> activity.setTheme(R.style.AppTheme)
            THEME_LIGHT -> activity.setTheme(R.style.AppThemeLight)
            THEME_DARK -> activity.setTheme(R.style.AppThemeDark)
            else -> activity.setTheme(R.style.AppThemeLight)
        }
    }
}