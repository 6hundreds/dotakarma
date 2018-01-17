package com.smedialink.tokenplussteamid.data.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class PlayerDataModel(
    @Id(assignable = true) var id: Long,
    val steamid: Long,
    val karma: Int,
    val personaname: String,
    val avatar: String,
    val avatarmedium: String,
    val avatarfull: String,
    val personastate: Int,
    val realname: String?
)
