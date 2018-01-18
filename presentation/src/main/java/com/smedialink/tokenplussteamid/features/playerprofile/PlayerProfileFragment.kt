package com.smedialink.tokenplussteamid.features.playerprofile

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import com.smedialink.tokenplussteamid.entity.Player
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class PlayerProfileFragment : BaseFragment(), PlayerProfileView {

    companion object {
        fun getNewInstance() = PlayerProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: PlayerProfilePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override val layoutId: Int
        get() = R.layout.fragment_profile

    override fun displayProfile(player: Player) {
        player_steam_id.text = player.steamId.toString()
    }
}
