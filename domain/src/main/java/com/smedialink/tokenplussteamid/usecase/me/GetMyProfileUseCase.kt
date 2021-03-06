package com.smedialink.tokenplussteamid.usecase.me

import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.manager.IProfileManager
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by six_hundreds on 13.02.18.
 */
class GetMyProfileUseCase @Inject constructor(private val profileManager: IProfileManager) {

    fun getMyComments(limit: Int? = 5, after: Int? = null): Single<List<Comment>> =
            profileManager.getMyComments(limit, after)

    fun getMyProfile(): Single<User> = profileManager.getMyProfile()

}