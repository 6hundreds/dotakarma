package com.smedialink.tokenplussteamid.features.steam

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SteamAuthPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<SteamAuthView>()
