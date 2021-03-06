package com.smedialink.tokenplussteamid.entity

data class User(
        val id: Int,
        val steamId: Long,
        val karma: Int,
        val personaName: String,
        val avatar: String,
        val avatarMedium: String,
        val avatarFull: String,
        val personalState: Int,
        val realName: String?,
        val comments: List<Comment>
)
