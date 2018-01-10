package com.smedialink.tokenplussteamid.features.mainactivity

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onPause() {
        super.onPause()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.removeNavigator()
    }
}
