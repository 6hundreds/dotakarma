package com.smedialink.tokenplussteamid.features.profile.entity

import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.entity.User

/**
 * Created by six_hundreds on 30.03.18.
 */
data class UserUiModel(val id: Int,
                       val steamId: Long,
                       val karma: Int,
                       val personaName: String,
                       val avatarFull: String,
                       val realName: String?,
                       val comments: List<HeterogeneousItem>)