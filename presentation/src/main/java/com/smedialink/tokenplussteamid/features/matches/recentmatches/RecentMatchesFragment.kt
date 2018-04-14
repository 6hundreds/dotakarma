package com.smedialink.tokenplussteamid.features.matches.recentmatches

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.features.matches.recentmatches.adapter.MatchesAdapter
import com.smedialink.tokenplussteamid.features.matches.recentmatches.entity.MatchItemUiModel
import com.smedialink.tokenplussteamid.subnavigation.TabNestedFragment
import kotlinx.android.synthetic.main.fragment_matches.*
import javax.inject.Inject

@Layout(R.layout.fragment_matches)
class RecentMatchesFragment
    : TabNestedFragment(),
        RecentMatchesView,
        MatchesAdapter.OnMatchClickListener,
        SwipeRefreshLayout.OnRefreshListener {
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

        layout_refresh.setOnRefreshListener(this)
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

    override fun hideRefreshing() {
        layout_refresh.isRefreshing = false
    }

    override fun onRefresh() {
        presenter.refreshMatches()
    }

    override fun onMatchClick(matchId: Long) {
        presenter.openMatchDetails(matchId)
    }
}
