package com.smedialink.tokenplussteamid.app

import android.support.annotation.LayoutRes

/**
 * Created by six_hundreds on 26.01.18.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Layout(@LayoutRes val value: Int)