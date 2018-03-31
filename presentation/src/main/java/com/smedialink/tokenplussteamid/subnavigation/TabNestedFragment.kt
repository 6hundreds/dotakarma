package com.smedialink.tokenplussteamid.subnavigation

import android.support.annotation.AnimRes
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment

/**
 * Created by Sergey Opivalov on 22/03/2018.
 */
abstract class TabNestedFragment : BaseFragment() {

    var skipAnimation = false

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation =
            if (skipAnimation) applyAnimation(0)
            else applyAnimation(nextAnim)

    override fun initUi() {
    }

    private fun applyAnimation(@AnimRes anim: Int): Animation =
            if (anim != 0) AnimationUtils.loadAnimation(context, anim)
            else AnimationUtils.loadAnimation(context, R.anim.none)
}