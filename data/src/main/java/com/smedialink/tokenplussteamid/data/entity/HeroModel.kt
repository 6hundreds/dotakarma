package com.smedialink.tokenplussteamid.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by six_hundreds on 31.01.18.
 */
@Entity(tableName = "heroes_images")
data class HeroModel(
        @PrimaryKey
        var id: Int = 0,
        @ColumnInfo(name = "name")
        var name: String = "",
        @ColumnInfo(name = "image_url")
        var imageUrl: String = ""
)