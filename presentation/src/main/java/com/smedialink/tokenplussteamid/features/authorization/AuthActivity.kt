package com.smedialink.tokenplussteamid.features.authorization

import android.content.Context
import android.content.Intent
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class AuthActivity : BaseActivity(), AuthView {

    companion object {
        fun getIntent(ctx: Context) = Intent(ctx, AuthActivity::class.java)
    }

    override val layoutId: Int
        get() = R.layout.activity_auth

    @Inject
    lateinit var navigator: Navigator

    @Inject
    @InjectPresenter
    lateinit var presenter: AuthPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }
}
