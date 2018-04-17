package com.smedialink.tokenplussteamid.features.anonymous.comment

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.widget.RxTextView
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.entity.AnonymousUser
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_anonymous_comment.*
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

    private val compositeDisposable = CompositeDisposable()

    companion object {
        fun newInstance() = AnonymousCommentFragment()
    }

    override fun initUi() {
        button_validate.setOnClickListener {
            presenter.validateAccountId(field_account_id.text.toString().toLong())
        } //todo improve
    }

    override fun onStart() {
        super.onStart()
        RxTextView.textChanges(field_account_id)
                .map { it.length > 7 }
                .subscribe { valid ->
                    button_validate.isEnabled = valid
                    button_validate.alpha = if (valid) 1.0f else 0.5f
                }
                .addTo(compositeDisposable)
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }

    override fun showLoading(show: Boolean) {
    }

    override fun showValidationProgress(show: Boolean) {
        button_validate.setVisible(!show)
        loader_validation.setVisible(show)
    }

    override fun onValidationSuccess(user: AnonymousUser) {
        Glide.with(this)
                .load(user.avatar)
                .into(image_avatar)
        text_personaname.text = user.personaName
        field_comment_input.setVisible(true)
    }

    override fun onCommentSuccess() {

    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }
}