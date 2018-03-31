package com.smedialink.tokenplussteamid.features.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseActivity
import com.smedialink.tokenplussteamid.common.ext.setVisible
import kotlinx.android.synthetic.main.activity_splash.*
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

/**
 * Created by six_hundreds on 31.01.18.
 */
@Layout(R.layout.activity_splash)
class SplashActivity : BaseActivity(), SplashView {

    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var navigator: Navigator

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
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