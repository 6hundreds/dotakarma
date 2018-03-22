package com.smedialink.tokenplussteamid.features.matches.recentmatches

import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import com.smedialink.tokenplussteamid.app.Layout
import com.bumptech.glide.Glide
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.features.matches.recentmatches.adapter.MatchesAdapter
import com.smedialink.tokenplussteamid.features.matches.recentmatches.entity.MatchItemUiModel
import kotlinx.android.synthetic.main.fragment_matches.*

@Layout(R.layout.fragment_matches)
class RecentMatchesFragment
    : BaseFragment(), RecentMatchesView, MatchesAdapter.OnMatchClickListener {

    companion object {
        fun newInstance() = RecentMatchesFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: RecentMatchesPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private lateinit var matchesAdapter: MatchesAdapter

    override fun initUi() {
        val glide = Glide.with(this)
        matchesAdapter = MatchesAdapter(presenter, glide, this)
        with(list_matches) {
            adapter = matchesAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }

    override fun updateMatches(items: List<MatchItemUiModel>) {
        matchesAdapter.items = items
    }

    override fun onMatchClick(matchId: Long) {
        presenter.openMatchDetails(matchId)
    }
}
