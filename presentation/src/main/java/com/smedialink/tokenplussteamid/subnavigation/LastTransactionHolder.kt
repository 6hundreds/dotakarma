package com.smedialink.tokenplussteamid.subnavigation

import kotlin.reflect.KClass

/**
 * Created by Sergey Opivalov on 07/03/2018.
 */
class LastTransactionHolder(private var lastShownFragment: KClass<out TabNestedFragment> = TabNestedFragment::class) {

    fun markAsLastShown(clazz: KClass<out TabNestedFragment>) {
        lastShownFragment = clazz
    }

    fun isLast(clazz: KClass<out TabNestedFragment>): Boolean = lastShownFragment == clazz
}