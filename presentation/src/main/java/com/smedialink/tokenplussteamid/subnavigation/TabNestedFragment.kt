package com.smedialink.tokenplussteamid.subnavigation

import android.support.annotation.AnimRes
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 22/03/2018.
 */
abstract class TabNestedFragment : BaseFragment() {

    @Inject
    lateinit var transactionHolder: LastTransactionHolder

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation =
            when {
                transactionHolder.isLast(this::class) && enter -> AnimationUtils.loadAnimation(context, R.anim.none)
                transactionHolder.isLast(this::class) && !enter -> applyAnimation(nextAnim)
                else -> {
                    transactionHolder.markAsLastShown(this::class)
                    applyAnimation(nextAnim)
                }
            }

    override fun initUi() {
    }

    private fun applyAnimation(@AnimRes anim: Int): Animation =
            if (anim != 0) AnimationUtils.loadAnimation(context, anim)
            else AnimationUtils.loadAnimation(context, R.anim.none)
}