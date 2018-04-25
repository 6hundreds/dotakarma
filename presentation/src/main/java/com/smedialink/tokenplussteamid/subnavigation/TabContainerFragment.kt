package com.smedialink.tokenplussteamid.subnavigation

import android.app.Activity
import android.content.Context
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 14/02/2018.
 */
@Layout(R.layout.fragment_tab_container)
abstract class TabContainerFragment : BaseFragment(), HasActivityInjector {

    protected companion object {
        const val CONTAINER_TAG_KEY = "container_tag"
    }

    @Inject
    lateinit var navigatorHolder: LocalNavigatorHolder

    @Inject
    lateinit var localNavigator: Navigator

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    val router: Router
        get() = cicerone.router

    val containerTag: String
        get() = arguments?.getString(CONTAINER_TAG_KEY)
                ?: throw IllegalArgumentException("Container tag must be provided via arguments")

    private val cicerone: Cicerone<Router>
        get() = navigatorHolder.getCicerone(containerTag)

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(localNavigator)
    }

    override fun onPause() {
        cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
