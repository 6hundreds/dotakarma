package com.smedialink.tokenplussteamid.features.registration

import com.arellomobile.mvp.InjectViewState
import com.smedialink.tokenplussteamid.base.BasePresenter
import com.smedialink.tokenplussteamid.interactor.RegistrationInteractor
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter @Inject constructor(
        private val interactor: RegistrationInteractor
) : BasePresenter<RegistrationView>()
