package com.smedialink.tokenplussteamid.common.ext

import java.lang.ref.WeakReference

/**
 * Created by six_hundreds on 24.02.18.
 */

fun <T> T.weak() = WeakReference(this)