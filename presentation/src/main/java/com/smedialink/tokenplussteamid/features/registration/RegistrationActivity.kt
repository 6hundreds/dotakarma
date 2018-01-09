package com.smedialink.tokenplussteamid.features.registration

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class RegistrationActivity : BaseActivity(), RegistrationView {

    override val layoutId: Int
        get() = R.layout.activity_registration

    @Inject
    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var navigator: Navigator
}
