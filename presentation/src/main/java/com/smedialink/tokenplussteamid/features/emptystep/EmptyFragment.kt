package com.smedialink.tokenplussteamid.features.emptystep

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import javax.inject.Inject

class EmptyFragment : BaseFragment(), EmptyView {

    companion object {
        fun getNewInstance() = EmptyFragment()
    }

    override val layoutId: Int
        get() = R.layout.fragment_empty_step

    @Inject
    @InjectPresenter
    lateinit var presenter: EmptyPresenter

    @ProvidePresenter
    fun providePresenter() = presenter
}
