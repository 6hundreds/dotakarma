package com.smedialink.tokenplussteamid.entity

class RegisteredPlayer(
        val steamId: Long,
        val visibilityState: Int,
        val profileState: Int,
        val personName: String,
        val lastLogOff: Long,
        val profileUrl: String,
        val avatar: String,
        val avatarMedium: String,
        val avatarFull: String,
        val personState: Int,
        val realName: String,
        val clanId: Long,
        val timeCreated: Long,
        val stateFlags: Int,
        val countryCode: String,
        val stateCode: String,
        val cityId: Int
)
