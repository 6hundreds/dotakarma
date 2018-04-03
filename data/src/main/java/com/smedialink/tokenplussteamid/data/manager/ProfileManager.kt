package com.smedialink.tokenplussteamid.data.manager

import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.data.mapper.CommentMapper
import com.smedialink.tokenplussteamid.data.mapper.UserMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.data.persistance.RealmManager
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.manager.IProfileManager
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
class ProfileManager @Inject constructor(
        private val api: DotaKarmaApi,
        private val realm: RealmManager,
        private val commentMapper: CommentMapper,
        private val userMapper: UserMapper,
        private val prefsManager: SharedPrefsManager)
    : IProfileManager {

    companion object {
        private const val CURRENT_USER_ID_KEY = "current_user_id"
    }

    override fun initialFetch(): Completable =
            if (prefsManager.getInt(CURRENT_USER_ID_KEY) != -1) {
                Completable.complete()
            } else {
                api.fetchMyProfile()
                        .doOnSuccess { prefsManager.putInt(CURRENT_USER_ID_KEY, it.id) }
                        .toCompletable()
            }

    override fun getMyComments(limit: Int?, after: Int?): Single<List<Comment>> =
            api.fetchMyComments(limit, after)
                    .doOnSuccess { realm.saveOrUpdate(it) }
                    .mapList(commentMapper::mapToDomain)

    override fun getMyProfile(): Single<User> =
            api.fetchMyProfile()
                    .doOnSuccess { prefsManager.putInt(CURRENT_USER_ID_KEY, it.id) }
                    .map(userMapper::mapToDomain)

    override fun getLiveComments(): Observable<List<Comment>> {
        val id = prefsManager.getInt(CURRENT_USER_ID_KEY)
        return realm.observableQuery("userId", id, CommentModel::class.java)
                .filter { comments -> comments.isNotEmpty() }
                .mapList(commentMapper::mapToDomain)
    }
}