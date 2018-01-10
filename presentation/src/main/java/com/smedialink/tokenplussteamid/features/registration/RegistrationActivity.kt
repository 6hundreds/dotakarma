package com.smedialink.tokenplussteamid.features.registration

import android.content.Context
import android.content.Intent
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import javax.inject.Inject

class RegistrationActivity : BaseActivity(), RegistrationView {

    companion object {
        fun getIntent(ctx: Context) = Intent(ctx, RegistrationActivity::class.java)
    }

    override val layoutId: Int
        get() = R.layout.activity_registration

    @Inject
    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    @ProvidePresenter
    fun providePresenter() = presenter
}
