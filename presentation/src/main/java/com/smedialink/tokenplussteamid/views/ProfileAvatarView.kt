package com.smedialink.tokenplussteamid.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.GlideApp
import kotlinx.android.synthetic.main.view_compound_profile_avatar.view.*

/**
 * Created by six_hundreds on 09.05.18.
 */
class ProfileAvatarView(context: Context, attributeSet: AttributeSet)
    : FrameLayout(context, attributeSet) {

    //todo temporary solution. Needs to be implemented via ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_compound_profile_avatar, this)
    }

    fun setAvatar(avatar: String) {
        GlideApp.with(this)
                .load(avatar)
                .transform(CircleCrop())
                .into(image_avatar)
    }

    fun setKarma(karma: Int) {
        setBackgroundResource(when (karma) {
            in Int.MIN_VALUE..-501 -> R.drawable.bg_gradient_purple
            in 7501..Int.MAX_VALUE -> R.drawable.bg_gradient_green
            else -> R.drawable.bg_gradient_blue
        })
    }
}