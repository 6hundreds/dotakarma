package com.smedialink.tokenplussteamid.views

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.smedialink.tokenplussteamid.R
import kotlinx.android.synthetic.main.view_compound_karma_value.view.*

/**
 * Created by six_hundreds on 27.04.18.
 */
class KarmaValueView(context: Context, attributeSet: AttributeSet)
    : FrameLayout(context, attributeSet) {

    var karma: Int? = null

    private val duration = 4000

    private lateinit var animatedBackground: AnimationDrawable

    init {
        LayoutInflater.from(context).inflate(R.layout.view_compound_karma_value, this)
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        karma?.let { value ->
            text_karma.text = karma.toString()
            resolveGradient(value).let { resource -> setBackgroundResource(resource) }
            animatedBackground = background as AnimationDrawable
            animatedBackground.setEnterFadeDuration(duration)
            animatedBackground.setExitFadeDuration(duration)
            background = animatedBackground
            post {
                animatedBackground.start()
            }
        } ?: throw IllegalStateException("Karma value should be provided for $this")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (animatedBackground.isRunning) {
            animatedBackground.stop()
        }
    }

    @DrawableRes
    private fun resolveGradient(karma: Int): Int =
            when (karma) {
                in Int.MIN_VALUE..-500 -> R.drawable.bg_karma_low
                in 7501..Int.MAX_VALUE -> R.drawable.bg_karma_high
                else -> R.drawable.bg_karma_medium
            }
}