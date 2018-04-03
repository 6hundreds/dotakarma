package com.smedialink.tokenplussteamid.data.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by six_hundreds on 31.01.18.
 */
open class HeroModel(
        @PrimaryKey
        var id: Int = 0,
        var name: String = "",
        var imageUrl: String = ""
): RealmObject()