package com.smedialink.tokenplussteamid.subnavigation

import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 14/02/2018.
 */
@Layout(R.layout.fragment_tab_container)
abstract class TabContainerFragment : BaseFragment() {

    @Inject
    lateinit var navigatorHolder: LocalNavigatorHolder

    private val containerTag: String
        get() = arguments?.getString(CONTAINER_TAG_KEY)
                ?: throw IllegalArgumentException("ContainerNavigator tag must be provided via arguments")

    private val cicerone: Cicerone<Router>
        get() = navigatorHolder.getCicerone(containerTag)

    abstract protected val localNavigator: Navigator

    protected companion object {
        const val CONTAINER_TAG_KEY = "container_tag"
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(localNavigator)
    }

    override fun onPause() {
        cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }
}
