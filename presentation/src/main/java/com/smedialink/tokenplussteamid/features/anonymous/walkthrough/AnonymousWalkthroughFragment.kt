package com.smedialink.tokenplussteamid.features.anonymous.walkthrough

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_anonymous_walkthrough.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 12.04.18.
 */
@Layout(R.layout.fragment_anonymous_walkthrough)
class AnonymousWalkthroughFragment : BaseFragment(), AnonymousWalkthroughView {

    @Inject
    @InjectPresenter
    lateinit var presenter: AnonymousWalkthroughPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    companion object {
        fun newInstance() = AnonymousWalkthroughFragment()
    }

    override fun initUi() {
        button_ok.setOnClickListener { presenter.finish() }
    }
}