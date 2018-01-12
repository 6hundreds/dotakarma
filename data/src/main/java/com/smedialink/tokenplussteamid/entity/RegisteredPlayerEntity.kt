package com.smedialink.tokenplussteamid.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class RegisteredPlayerEntity(
        @Id(assignable = true) var steamid: Long,
        val communityvisibilitystate: Int,
        val profilestate: Int,
        val personaname: String,
        val lastlogoff: Long,
        val profileurl: String,
        val avatar: String,
        val avatarmedium: String,
        val avatarfull: String,
        val personastate: Int,
        val realname: String,
        val primaryclanid: Long,
        val timecreated: Long,
        val personastateflags: Int,
        val loccountrycode: String,
        val locstatecode: String,
        val loccityid: Int
)
