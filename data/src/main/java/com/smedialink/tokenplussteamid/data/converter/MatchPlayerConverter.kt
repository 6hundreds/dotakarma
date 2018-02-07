package com.smedialink.tokenplussteamid.data.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.smedialink.tokenplussteamid.data.entity.MatchModel
import java.util.Collections.emptyList


/**
 * Created by six_hundreds on 06.02.18.
 */
class MatchPlayerConverter {

    @TypeConverter
    fun jsonToPojo(data: String?): List<MatchModel.MatchPlayerModel> {
        if (data == null) {
            return emptyList()
        }

        val listType = object : TypeToken<List<MatchModel.MatchPlayerModel>>(){}.type

        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun pojoToJson(players: List<MatchModel.MatchPlayerModel>): String {
        return Gson().toJson(players)
    }
}