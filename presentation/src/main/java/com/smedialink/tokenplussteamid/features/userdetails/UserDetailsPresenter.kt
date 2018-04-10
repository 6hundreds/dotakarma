package com.smedialink.tokenplussteamid.features.userdetails

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.app.AppScreens
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.common.lists.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.lists.Paginator
import com.smedialink.tokenplussteamid.data.ext.mapList
import com.smedialink.tokenplussteamid.mapper.CommentProfileMapper
import com.smedialink.tokenplussteamid.mapper.UserMapper
import com.smedialink.tokenplussteamid.usecase.comments.GetCommentsForUserUseCase
import com.smedialink.tokenplussteamid.usecase.users.GetUserByIdUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
@InjectViewState
class UserDetailsPresenter @Inject constructor(
        private val router: Router) : BasePresenter<UserDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(AppScreens.USER_PROFILE_SCREEN)
    }
}