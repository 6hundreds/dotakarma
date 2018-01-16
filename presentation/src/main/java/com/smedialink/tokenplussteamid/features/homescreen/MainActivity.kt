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

    private var feedFragment: FeedFragment? = null
    private var profileFragment: PlayerProfileFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFragments()
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

    private val navigator = Navigator { commands ->
        commands.forEach { command -> applyCommand(command) }
    }

    private fun applyCommand(command: Command) {
        when (command) {
            is Back -> {
                finish()
            }
            is SystemMessage -> {
                Toast.makeText(MainActivity@ this, command.message, Toast.LENGTH_SHORT).show()
            }
            is Replace -> {
                val fm = supportFragmentManager

                when (command.screenKey) {
                    AppScreens.BOTTOM_FEED_SCREEN -> {
                        fm.beginTransaction()
                                .detach(profileFragment)
                                .attach(feedFragment)
                                .commitNow()
                    }
                    AppScreens.BOTTOM_PROFILE_SCREEN -> {
                        fm.beginTransaction()
                                .detach(feedFragment)
                                .attach(profileFragment)
                                .commitNow()
                    }
                }
            }
            is Forward -> {
                when (command.screenKey) {
//                    AppScreens.AUTH_SCREEN -> startActivity(AuthActivity.getIntent(MainActivity@ this))
                }
            }
        }
    }

    private fun initFragments() {
        val fm = supportFragmentManager

        feedFragment = fm.findFragmentByTag(FeedFragment.TAG) as FeedFragment?

        if (feedFragment == null) {
            feedFragment = FeedFragment.getNewInstance()
            fm.beginTransaction()
                    .add(R.id.home_tabs_container, feedFragment, FeedFragment.TAG)
                    .detach(feedFragment)
                    .commitNow()
        }

        profileFragment = fm.findFragmentByTag(PlayerProfileFragment.TAG) as PlayerProfileFragment?

        if (profileFragment == null) {
            profileFragment = PlayerProfileFragment.getNewInstance()
            fm.beginTransaction()
                    .add(R.id.home_tabs_container, profileFragment, PlayerProfileFragment.TAG)
                    .detach(profileFragment)
                    .commitNow()
        }
    }

    private fun initViews() {
        home_bottom_navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.action_feed -> {
                    presenter.navigateToFeedScreen()
                    true
                }
                R.id.action_profile -> {
                    presenter.navigateToProfileScreen()
                    true
                }
                else -> true
            }
        }
    }
}
