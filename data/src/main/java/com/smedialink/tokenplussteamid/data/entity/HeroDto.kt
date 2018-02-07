package com.smedialink.tokenplussteamid.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by six_hundreds on 31.01.18.
 */
data class HeroDto(var id: Int,
                   var name: String,
                   @SerializedName("localized_name")
                        var localizedName: String)