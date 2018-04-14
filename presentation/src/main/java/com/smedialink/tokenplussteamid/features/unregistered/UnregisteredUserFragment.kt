package com.smedialink.tokenplussteamid.features.unregistered

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import com.smedialink.tokenplussteamid.common.ext.setVisible
import kotlinx.android.synthetic.main.fragment_user_unregistered.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 11.04.18.
 */
@Layout(R.layout.fragment_user_unregistered)
class UnregisteredUserFragment
    : BaseFragment(), UnregisteredUserView {

    companion object {
        fun newInstance() = UnregisteredUserFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: UnregisteredUserPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun initUi() {
        field_comment.clickAction = { comment -> presenter.sendComment(comment) }
    }
}