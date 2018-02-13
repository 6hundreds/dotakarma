package com.smedialink.tokenplussteamid.manager

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.entity.User
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by six_hundreds on 13.02.18.
 */
interface IProfileManager {

    fun initialFetch(): Completable

    fun getMyProfile(): Single<User>

    fun getMyComments(limit: Int? = 5, after: Int? = null): Single<List<Comment>>
}