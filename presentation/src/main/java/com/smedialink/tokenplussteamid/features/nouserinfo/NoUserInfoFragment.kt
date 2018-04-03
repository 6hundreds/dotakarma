package com.smedialink.tokenplussteamid.features.nouserinfo

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.subnavigation.TabNestedFragment
import kotlinx.android.synthetic.main.fragment_no_user_info.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 02.04.18.
 */
@Layout(R.layout.fragment_no_user_info)
class NoUserInfoFragment
    : TabNestedFragment(), NoUserInfoView {

    @Inject
    @InjectPresenter
    lateinit var presenter: NoUserInfoPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    companion object {
        fun newInstance() = NoUserInfoFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_retry.setOnClickListener { presenter.fetchUser() }
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
        button_retry.setVisible(!show)
        loader.setVisible(show)
    }
}