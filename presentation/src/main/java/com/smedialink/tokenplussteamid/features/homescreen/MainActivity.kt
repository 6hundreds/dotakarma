package com.smedialink.tokenplussteamid.features.homescreen

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.basic.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    companion object {
        private const val TAB_FEED = 0
        private const val TAB_PROFILE = 1
        private const val TAB_MATCHES = 2
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var navigator: Navigator

    private lateinit var tabItemFeed: AHBottomNavigationItem
    private lateinit var tabItemProfile: AHBottomNavigationItem
    private lateinit var tabItemPMatches: AHBottomNavigationItem

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

        tabItemFeed = AHBottomNavigationItem(
            R.string.action_feed,
            R.drawable.ic_comment,
            R.color.colorFeed
        )
        tabItemProfile = AHBottomNavigationItem(
            R.string.action_profile,
            R.drawable.ic_person,
            R.color.colorProfile
        )
        tabItemPMatches = AHBottomNavigationItem(
            R.string.action_matches,
            R.drawable.ic_star,
            R.color.colorMatches
        )

        home_bottom_navigation.addItems(listOf(tabItemFeed, tabItemProfile, tabItemPMatches))
        home_bottom_navigation.titleState = AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE
        home_bottom_navigation.isColored = true

        home_bottom_navigation.setOnTabSelectedListener { position, _ ->
            when (position) {
                TAB_FEED -> {
                    presenter.onFeedItemClicked()
                    true
                }
                TAB_PROFILE -> {
                    presenter.onProfileItemClicked()
                    true
                }
                TAB_MATCHES -> {
                    presenter.onMatchesItemSelected()
                    true
                }
                else -> false
            }
        }

        // Force first tab loading on onCreate
        home_bottom_navigation.currentItem = 0
    }
}
