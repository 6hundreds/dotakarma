package com.smedialink.tokenplussteamid.features.profile

import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.common.setVisible
import com.smedialink.tokenplussteamid.entity.User
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

@Layout(R.layout.fragment_profile)
class ProfileFragment : BaseFragment(), ProfileView {

    private lateinit var glide: RequestManager

    companion object {
        fun newInstance() = ProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun initUi() {
        glide = Glide.with(this)
    }

    override fun showProfile(user: User) {
        glide.load(user.avatarFull)
                .apply(bitmapTransform(RoundedCorners(20)))
                .into(image_avatar)
        text_karma.text = "Karma ${user.karma}" //todo temporary
        text_personaname.text = user.personaName

    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }
}
