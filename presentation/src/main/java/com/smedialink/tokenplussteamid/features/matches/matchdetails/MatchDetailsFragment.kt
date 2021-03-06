package com.smedialink.tokenplussteamid.features.matches.matchdetails

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.Team
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.common.ext.setVisible
import com.smedialink.tokenplussteamid.common.ext.withArgs
import com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter.MatchDetailsItem
import com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter.MatchPlayersAdapter
import com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter.TeamHeader
import com.smedialink.tokenplussteamid.features.matches.matchdetails.entity.MatchUiModel
import com.smedialink.tokenplussteamid.subnavigation.TabNestedFragment
import kotlinx.android.synthetic.main.fragment_match_details.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.02.18.
 */
@Layout(R.layout.fragment_match_details)
class MatchDetailsFragment
    : TabNestedFragment(), MatchDetailsView, MatchPlayersAdapter.OnPlayerClickListener {

    private lateinit var detailsAdapter: MatchPlayersAdapter

    companion object {
        private const val MATCH_ID_KEY = "match_id"

        fun newInstance(matchId: Long) = MatchDetailsFragment().withArgs {
            putLong(MATCH_ID_KEY, matchId)
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MatchDetailsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showMatchDetails(match: MatchUiModel) {
        toolbar.title = if (match.radiantWin) getString(R.string.title_radiant_win)
        else getString(R.string.title_dire_win)

        val items = mutableListOf<MatchDetailsItem>()
        items.add(TeamHeader(Team.RADIANT))
        match.players
                .forEach { if (it.isRadiant) items.add(it) }
        items.add(TeamHeader(Team.DIRE))
        match.players
                .forEach { if (!it.isRadiant) items.add(it) }
        detailsAdapter.items = items
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val matchId = arguments?.getLong(MATCH_ID_KEY, -1L)
                ?: throw  IllegalArgumentException("matchId must be provided via arguments")
        if (matchId != -1L) {
            presenter.getMatchDetails(matchId) //todo move to module
        }
    }

    override fun initUi() {
        val glide = Glide.with(this)
        detailsAdapter = MatchPlayersAdapter(this, presenter, glide)
        with(list_match_details) {
            adapter = detailsAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        toolbar.setNavigationOnClickListener { presenter.onBackPressed() }
    }

    override fun showError(error: String) {
        errorDelegate.showError(error)
    }

    override fun onPlayerClick(accountId: Long) {
        presenter.showPlayerProfile(accountId)
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }
}