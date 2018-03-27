package com.smedialink.tokenplussteamid.common.ext

import android.support.v4.app.FragmentManager
import com.smedialink.tokenplussteamid.subnavigation.TabNestedFragment

/**
 * Created by Sergey Opivalov on 27/03/2018.
 */
fun FragmentManager.disableAnimations() = setAnimationFlags(shouldSkip = true)

fun FragmentManager.enableAnimations() = setAnimationFlags(shouldSkip = false)

private fun FragmentManager.setAnimationFlags(shouldSkip: Boolean) =
        this.apply {
            fragments
                    .flatMap { it.childFragmentManager.fragments }
                    .forEach { (it as? TabNestedFragment)?.skipAnimation = shouldSkip }
        }