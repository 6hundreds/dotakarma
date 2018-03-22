package com.smedialink.tokenplussteamid.features.authsuccess

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_auth_success.*
import javax.inject.Inject

@Layout(R.layout.activity_auth_success)
class AuthSuccessActivity : BaseActivity(), AuthSuccessView {

    @Inject
    @InjectPresenter
    lateinit var presenter: AuthSuccessPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.dataString?.let { text ->
            presenter.saveToken(text.substringAfter("="))
        }

        button_ok.setOnClickListener { finish() }
    }
}
