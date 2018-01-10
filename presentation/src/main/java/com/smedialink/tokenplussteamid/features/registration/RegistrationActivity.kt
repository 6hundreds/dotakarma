package com.smedialink.tokenplussteamid.features.registration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_registration.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registration_button.setOnClickListener {
            val login = registration_login.text.toString()
            val password = registration_password.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty()) {
                presenter.performRegistration(login, password)
            }
        }
    }
}
