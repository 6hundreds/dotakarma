package com.smedialink.tokenplussteamid.errorhandling

/**
 * Created by six_hundreds on 20.04.18.
 */
data class ServerError(var name: String,
                       var message: String,
                       var status: String)