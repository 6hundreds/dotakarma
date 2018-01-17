package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class RegisteredPlayerEntity(
        @Id(assignable = true) @SerializedName("steamid") var steamid: Long,
        @SerializedName("avatar") val avatar: String
)
