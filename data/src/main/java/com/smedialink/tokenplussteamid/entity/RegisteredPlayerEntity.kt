package com.smedialink.tokenplussteamid.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class RegisteredPlayerEntity(
        @Id var id: Long = 0,
        val steamid: String = "12345",
        val communityvisibilitystate: Int = 0,
        val profilestate: Int = 0,
        val personaname: String = "TEST",
        val lastlogoff: Long = 0L,
        val profileurl: String = "url",
        val avatar: String = "avatar",
        val avatarmedium: String = "avatarmedium",
        val avatarfull: String = "avatarfull",
        val personastate: Int = 0,
        val realname: String = "realname",
        val primaryclanid: Long = 0L,
        val timecreated: Long = 0L,
        val personastateflags: Int = 0,
        val loccountrycode: String = "loccountrycode",
        val locstatecode: String = "locstatecode",
        val loccityid: Int = 0
)
