package com.smedialink.tokenplussteamid.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.smedialink.tokenplussteamid.R
import io.github.tonnyl.spark.Spark
import kotlinx.android.synthetic.main.item_profile_header.view.*

/**
 * Created by six_hundreds on 27.04.18.
 */
class KarmaValueView(context: Context, attributeSet: AttributeSet)
    : FrameLayout(context, attributeSet) {

    private lateinit var spark: Spark

    var karma: Int = 0
        set(value) {
            spark = Spark.Builder()
                    .setView(header_karma) // View or view group
                    .setDuration(4000)
                    .setAnimList(Spark.ANIM_GREEN_PURPLE)
                    .build()
            spark.startAnimation()
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_compound_input_comment, this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        spark.stopAnimation()
    }
}