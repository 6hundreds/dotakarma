package com.smedialink.tokenplussteamid.features.homescreen

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseActivity
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.playerprofile.PlayerProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    override val layoutId: Int
        get() = R.layout.activity_main

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    private fun initViews() {
        home_bottom_navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.action_feed -> {
                    presenter.onFeedItemClicked()
                    true
                }
                R.id.action_profile -> {
                    presenter.onProfileItemClicked()
                    true
                }
                else -> true
            }
        }
    }
}
