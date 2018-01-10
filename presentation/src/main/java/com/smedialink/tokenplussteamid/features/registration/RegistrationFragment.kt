package com.smedialink.tokenplussteamid.features.registration

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_registration.*
import javax.inject.Inject

class RegistrationFragment : BaseFragment(), RegistrationView {

    companion object {
        fun getNewInstance() = RegistrationFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_registration

    @Inject
    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registration_button.setOnClickListener {
            val login = registration_login.text.toString()
            val password = registration_password.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty()) {
                presenter.performRegistration(login, password)
            }
        }
    }
}
