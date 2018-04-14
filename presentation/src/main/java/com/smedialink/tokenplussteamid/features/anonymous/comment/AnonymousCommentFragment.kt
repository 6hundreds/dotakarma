package com.smedialink.tokenplussteamid.features.anonymous.comment

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import javax.inject.Inject

/**
 * Created by six_hundreds on 12.04.18.
 */
@Layout(R.layout.fragment_anonymous_comment)
class AnonymousCommentFragment : BaseFragment(), AnonymousCommentView {

    @Inject
    @InjectPresenter
    lateinit var presenter: AnonymousCommentPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun initUi() {
    }

    override fun showLoading(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }
}