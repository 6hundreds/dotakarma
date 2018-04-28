package com.smedialink.tokenplussteamid.features.profile.entity

import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem

/**
 * Created by six_hundreds on 27.04.18.
 */
class ProfileMetaUiModel(val name: String,
                         val avatar: String,
                         val karma: Int) : HeterogeneousItem {
    override fun getItemId(): Long = R.layout.item_profile_header.toLong()
}