package com.smedialink.tokenplussteamid.features.matches.matchdetails

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.Team
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.features.matches.matchdetails.entity.MatchUiModel
import com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter.MatchDetailsItem
import com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter.MatchPlayersAdapter
import com.smedialink.tokenplussteamid.features.matches.matchdetails.adapter.TeamHeader
import kotlinx.android.synthetic.main.fragment_match_details.*
import javax.inject.Inject

/**
 * Created by six_hundreds on 05.02.18.
 */
@Layout(R.layout.fragment_match_details)
class MatchDetailsFragment : BaseFragment(), MatchDetailsView {

    private lateinit var detailsAdapter: MatchPlayersAdapter

    companion object {
        private const val MATCH_ID_KEY = "match_id"

        fun newInstance(matchId: Long) = MatchDetailsFragment().apply {
            arguments = Bundle().apply {
                putLong(MATCH_ID_KEY, matchId)
            }
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MatchDetailsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showMatchDetails(match: MatchUiModel) {
        toolbar.title = if (match.radiantWin) "Radiant win" else "Dire win" //todo stub!

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
                ?: throw  IllegalArgumentException("matchId must be provided")
        if (matchId != -1L) {
            presenter.getMatchDetails(matchId)
        }
    }

    override fun initUi() {
        val glide = Glide.with(this)
        detailsAdapter = MatchPlayersAdapter(presenter, glide)
        with(list_match_details) {
            adapter = detailsAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        toolbar.setNavigationOnClickListener { activity?.onBackPressed() }
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean) {
    }
}