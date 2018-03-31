package com.smedialink.tokenplussteamid.data.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.smedialink.tokenplussteamid.data.entity.CommentModel

/**
 * Created by six_hundreds on 30.03.18.
 */
class CommentConverter {
    @TypeConverter
    fun jsonToPojo(data: String?): CommentModel? {
        if (data == null) {
            return null
        }

        return Gson().fromJson(data, CommentModel::class.java)
    }

    @TypeConverter
    fun pojoToJson(comment: CommentModel): String {
        return Gson().toJson(comment)
    }
}