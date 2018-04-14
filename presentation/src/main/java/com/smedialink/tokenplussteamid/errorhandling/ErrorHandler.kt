package com.smedialink.tokenplussteamid.errorhandling

import com.smedialink.tokenplussteamid.base.CanShowError

/**
 * Created by six_hundreds on 11.04.18.
 */
interface ErrorHandler {

    fun proceed(error: Throwable)

    fun attachView(view: CanShowError)

    fun detachView()
}