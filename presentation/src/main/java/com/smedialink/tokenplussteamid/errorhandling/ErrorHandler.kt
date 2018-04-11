package com.smedialink.tokenplussteamid.errorhandling

/**
 * Created by six_hundreds on 11.04.18.
 */
interface ErrorHandler {
    fun proceed(error: Throwable, operation: (message: String) -> Unit)
}