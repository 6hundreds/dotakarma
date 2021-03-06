package com.smedialink.tokenplussteamid.data.manager

import android.content.SharedPreferences
import com.smedialink.tokenplussteamid.manager.IPrefsManager
import io.reactivex.functions.Action
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
class SharedPrefsManager @Inject constructor(private val preferences: SharedPreferences)
    : IPrefsManager {

    override fun putString(key: String, value: String) {
        preferences
                .edit()
                .putString(key, value)
                .apply()
    }

    override fun getString(key: String): String =
            preferences.getString(key, "")

    override fun putBoolean(key: String, value: Boolean) {
        preferences
                .edit()
                .putBoolean(key, value)
                .apply()
    }

    override fun getBoolean(key: String): Boolean =
            preferences.getBoolean(key, false)

    override fun putInt(key: String, value: Int) {
        preferences
                .edit()
                .putInt(key, value)
                .apply()
    }

    override fun getInt(key: String): Int =
            preferences.getInt(key, -1)


    override fun clear() {
        preferences
                .edit()
                .clear()
                .apply()
    }
}