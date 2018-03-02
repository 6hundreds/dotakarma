package com.smedialink.tokenplussteamid.features.main.containers.profile

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.subnavigation.TabContainerFragment
import javax.inject.Inject

/**
 * Created by Sergey Opivalov on 20/02/2018.
 */
@Layout(R.layout.fragment_tab_container)
class ProfileContainerFragment : TabContainerFragment(), ProfileContainerView {

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileContainerPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    companion object {

        const val REPLY_TRANSITION = "reply_transition"

        fun newInstance(containerTag: String) = ProfileContainerFragment().apply {
            arguments = Bundle().apply {
                putString(CONTAINER_TAG_KEY, containerTag)
            }
        }
    }

    override fun initUi() {
    }
}