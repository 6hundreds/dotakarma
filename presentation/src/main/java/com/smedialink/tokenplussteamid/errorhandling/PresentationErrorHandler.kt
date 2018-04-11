package com.smedialink.tokenplussteamid.errorhandling

/**
 * Created by six_hundreds on 11.04.18.
 */
class PresentationErrorHandler() : ErrorHandler {

    override fun proceed(error: Throwable, operation: (String) -> Unit) {
        operation.invoke(error.localizedMessage) //todo stub implementation
    }
}