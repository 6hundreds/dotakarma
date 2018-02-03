package com.smedialink.tokenplussteamid.manager

/**
 * Created by six_hundreds on 31.01.18.
 */
interface IPrefsManager {

    fun putString(key: String, value: String)

    fun getString(key: String): String

    fun putBoolean(key: String, value: Boolean)

    fun getBoolean(key: String): Boolean

    fun clear()
}