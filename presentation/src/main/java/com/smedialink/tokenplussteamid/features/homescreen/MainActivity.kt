package com.smedialink.tokenplussteamid.features.homescreen

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    override val layoutId: Int
        get() = R.layout.activity_main

    @Inject
    lateinit var navigator: Navigator

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        button_auth.setOnClickListener { presenter.performAuthorization() }
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }
}
