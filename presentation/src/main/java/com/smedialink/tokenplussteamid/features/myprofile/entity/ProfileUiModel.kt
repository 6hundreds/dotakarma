package com.smedialink.tokenplussteamid.features.myprofile.entity

import com.smedialink.tokenplussteamid.entity.User

/**
 * Created by six_hundreds on 30.03.18.
 */
data class ProfileUiModel(val user: User,
                          val comments: List<CommentProfileUiModel>)