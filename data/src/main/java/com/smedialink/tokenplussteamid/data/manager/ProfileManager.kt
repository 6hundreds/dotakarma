package com.smedialink.tokenplussteamid.data.manager

import com.smedialink.tokenplussteamid.data.dao.CommentDao
import com.smedialink.tokenplussteamid.data.dao.UserDao
import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.data.mapper.CommentListMapper
import com.smedialink.tokenplussteamid.data.mapper.UserMapper
import com.smedialink.tokenplussteamid.data.network.DotaKarmaApi
import com.smedialink.tokenplussteamid.entity.Comment
import com.smedialink.tokenplussteamid.entity.User
import com.smedialink.tokenplussteamid.manager.IProfileManager
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
class ProfileManager @Inject constructor(
        private val api: DotaKarmaApi,
        private val userDao: UserDao,
        private val commentsDao: CommentDao,
        private val commentListMapper: CommentListMapper,
        private val userMapper: UserMapper,
        private val prefsManager: SharedPrefsManager) : IProfileManager {

    val mock = arrayListOf(
            CommentModel(1, "Comment1", 1, "12.03.2018", "", 0, 0),
            CommentModel(2, "Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2Comment2", 1, "12.03.2018", "", 0, 0),
            CommentModel(3, "Comment3", 1, "12.03.2018", "", 0, 0),
            CommentModel(4, "Comment4", 1, "12.03.2018", "", 0, 0)
    )


    companion object {
        private const val CURRENT_USER_ID_KEY = "current_user_id"
    }

    override fun initialFetch(): Completable =
            if (prefsManager.getInt(CURRENT_USER_ID_KEY) == -1) {
                api.fetchMyProfile()
                        .doOnSuccess { prefsManager.putInt(CURRENT_USER_ID_KEY, it.id) }
                        .toCompletable()
            } else Completable.complete()


    override fun getMyComments(limit: Int?, after: Int?): Single<List<Comment>> =
            Single.fromCallable { prefsManager.getInt(CURRENT_USER_ID_KEY) }
                    .flatMap { api.fetchMyComments(limit, after) }
                    .doOnSuccess { commentsDao.insert(it) }
                    .map { commentListMapper.mapToDomain(it) }

    override fun getMyProfile(): Single<User> =
            api.fetchMyProfile()
                    .map { userMapper.mapToDomain(it) }

    override fun addComment(content: String, commentId: Int): Completable =
            Completable.fromAction {
                mock.add(0, CommentModel(1, content, 1, "12.03.2018", "", 0, 0))
            }

}