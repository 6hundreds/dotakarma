package com.smedialink.tokenplussteamid.features.registrationcomplete

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RegistrationCompletedPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<RegistrationCompletedView>()
