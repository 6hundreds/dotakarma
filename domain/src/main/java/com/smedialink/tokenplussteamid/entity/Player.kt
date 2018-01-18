package com.smedialink.tokenplussteamid.entity

data class Player(
    val id: Long,
    val steamId: Long,
    val karma: Int,
    val personalName: String,
    val avatar: String,
    val avatarMedium: String,
    val avatarFull: String,
    val personalState: Int,
    val realName: String?
)
