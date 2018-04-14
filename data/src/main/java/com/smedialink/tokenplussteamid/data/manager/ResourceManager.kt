package com.smedialink.tokenplussteamid.data.manager

import android.content.Context
import android.support.annotation.StringRes
import javax.inject.Inject

/**
 * Created by six_hundreds on 12.04.18.
 */
class ResourceManager @Inject constructor(private val context: Context) {

    fun getString(@StringRes id: Int): String =
            context.getString(id)

}