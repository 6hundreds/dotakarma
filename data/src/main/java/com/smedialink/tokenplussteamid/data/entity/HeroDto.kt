package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by six_hundreds on 31.01.18.
 */
data class HeroDto(
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("localized_name")
        var localizedName: String)