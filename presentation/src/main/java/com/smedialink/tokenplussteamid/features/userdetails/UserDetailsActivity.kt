package com.smedialink.tokenplussteamid.features.userdetails

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseActivity
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

/**
 * Created by six_hundreds on 13.02.18.
 */
@Layout(R.layout.activity_user_details)
class UserDetailsActivity : BaseActivity(), UserDetailsView {

    companion object {
        const val USER_ID_KEY = "user_id_key"
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: UserDetailsPresenter

    @Inject
    lateinit var navigator: Navigator

    @ProvidePresenter
    fun providePresenter() = presenter

    val currentUserId: Int
        get() {
            val id = intent?.getIntExtra(USER_ID_KEY, -1)
                    ?: throw  IllegalStateException("$this. Intent is null")
            return if (id == -1) throw  IllegalArgumentException("UserId must be provided via extras for $this")
            else id
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