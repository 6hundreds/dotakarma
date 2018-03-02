package com.smedialink.tokenplussteamid.data.manager

import com.smedialink.tokenplussteamid.data.dao.CommentDao
import com.smedialink.tokenplussteamid.data.dao.UserDao
import com.smedialink.tokenplussteamid.data.entity.CommentModel
import com.smedialink.tokenplussteamid.data.entity.UserModel
import com.smedialink.tokenplussteamid.data.mapper.CommentMapper
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
        private val commentMapper: CommentMapper,
        private val userMapper: UserMapper,
        private val prefsManager: SharedPrefsManager) : IProfileManager {

    val mock = arrayListOf<CommentModel>(
            CommentModel(1, "Comment1", 1, "12.03.2018", "", 0,0),
            CommentModel(2, "Comment2", 1, "12.03.2018", "", 0,0),
            CommentModel(3, "Comment3", 1, "12.03.2018", "", 0,0),
            CommentModel(4, "Comment4", 1, "12.03.2018", "", 0,0),
            CommentModel(5, "Comment5", 1, "12.03.2018", "", 0,0),
            CommentModel(6, "Comment6", 1, "12.03.2018", "", 0,0),
            CommentModel(7, "Comment7", 1, "12.03.2018", "", 0,0),
            CommentModel(8, "Comment8", 1, "12.03.2018", "", 0,0),
            CommentModel(9, "Comment9", 1, "12.03.2018", "", 0,0),
            CommentModel(10, "Comment10", 1, "12.03.2018", "", 0,0),
            CommentModel(11, "Comment11", 1, "12.03.2018", "", 0,0)
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
//            Single.fromCallable { prefsManager.getInt(CURRENT_USER_ID_KEY) }
//                    .flatMap { api.fetchMyComments(limit, after) }
//                    .map { commentMapper.mapToDomain(it) }
            Single.just(commentMapper.mapToDomain(mock))

    override fun getMyProfile(): Single<User> =
            Single.just(UserModel())
//            api.fetchMyProfile()
                    .map { userMapper.mapToDomain(it) }
}