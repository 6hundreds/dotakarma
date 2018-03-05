package com.smedialink.tokenplussteamid.features.main

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseActivity
import com.smedialink.tokenplussteamid.features.AppScreens
import com.smedialink.tokenplussteamid.features.feed.FeedFragment
import com.smedialink.tokenplussteamid.features.main.containers.matches.MatchesContainerFragment
import com.smedialink.tokenplussteamid.features.main.containers.profile.ProfileContainerFragment
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import ru.terrakok.cicerone.commands.SystemMessage
import javax.inject.Inject

@Layout(R.layout.activity_main)
class MainActivity : BaseActivity(), MainView {

    companion object {
        private const val TAB_FEED = 0
        private const val TAB_PROFILE = 1
        private const val TAB_MATCHES = 2
    }

    var matchContainer: MatchesContainerFragment? = null
    var feedContainer: FeedFragment? = null
    var profileContainer: ProfileContainerFragment? = null

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private val navigator: Navigator = object : Navigator {

        override fun applyCommands(commands: Array<out Command>?) {
            commands?.forEach { applyCommand(it) }
        }

        private fun applyCommand(command: Command) {
            when (command) {
                is Back -> finish()
                is SystemMessage -> Toast.makeText(this@MainActivity, command.message, Toast.LENGTH_SHORT).show()
                is Replace -> {
                    val fm = supportFragmentManager

                    when (command.screenKey) {
                        AppScreens.FEED_TAB_SCREEN -> fm.beginTransaction()
                                .detach(matchContainer)
                                .detach(profileContainer)
                                .attach(feedContainer)
                                .commitNow()
                        AppScreens.MATCHES_TAB_SCREEN -> fm.beginTransaction()
                                .detach(profileContainer)
                                .detach(feedContainer)
                                .attach(matchContainer)
                                .commitNow()
                        AppScreens.PROFILE_TAB_SCREEN -> fm.beginTransaction()
                                .detach(matchContainer)
                                .detach(feedContainer)
                                .attach(profileContainer)
                                .commitNow()
                    }
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        initContainers()

        if (savedInstanceState == null) {
            home_bottom_navigation.currentItem = 0
        }
    }

    private fun initContainers() {
        with(supportFragmentManager) {
            matchContainer = findFragmentByTag("matches_container") as MatchesContainerFragment?
            if (matchContainer == null) {
                matchContainer = MatchesContainerFragment.newInstance("matches_container")
                beginTransaction()
                        .add(R.id.home_tabs_container, matchContainer, "matches_container")
                        .detach(matchContainer)
                        .commitNow()
            }

            feedContainer = findFragmentByTag("feed_container") as FeedFragment?
            if (feedContainer == null) {
                feedContainer = FeedFragment.newInstance()
                beginTransaction()
                        .add(R.id.home_tabs_container, feedContainer, "feed_container")
                        .detach(feedContainer)
                        .commitNow()
            }

            profileContainer = findFragmentByTag("profile_container") as ProfileContainerFragment?
            if (profileContainer == null) {
                profileContainer = ProfileContainerFragment.newInstance("profile_container")
                beginTransaction()
                        .add(R.id.home_tabs_container, profileContainer, "profile_container")
                        .detach(profileContainer)
                        .commitNow()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    private fun initUi() {

        home_bottom_navigation.setDefaultBackgroundResource(R.drawable.bg_purple_gradient)

        val tabItemFeed = AHBottomNavigationItem(getString(R.string.action_feed), R.drawable.ic_comment)
        val tabItemProfile = AHBottomNavigationItem(getString(R.string.action_profile), R.drawable.ic_person)
        val tabItemPMatches = AHBottomNavigationItem(getString(R.string.action_matches), R.drawable.ic_star)

        home_bottom_navigation.addItems(listOf(tabItemFeed, tabItemProfile, tabItemPMatches))
        home_bottom_navigation.titleState = AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE

        home_bottom_navigation.setOnTabSelectedListener { position, _ ->
            when (position) {
                TAB_FEED -> {
                    presenter.onFeedTabClicked()
                    true
                }
                TAB_PROFILE -> {
                    presenter.onProfileTabClicked()
                    true
                }
                TAB_MATCHES -> {
                    presenter.onMatchesTabClicked()
                    true
                }
                else -> false
            }
        }
    }
}
