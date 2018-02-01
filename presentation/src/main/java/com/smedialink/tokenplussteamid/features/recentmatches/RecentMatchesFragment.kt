package com.smedialink.tokenplussteamid.features.recentmatches

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.basic.BaseFragment
import com.smedialink.tokenplussteamid.common.setVisible
import com.smedialink.tokenplussteamid.features.recentmatches.adapter.MatchesAdapter
import com.smedialink.tokenplussteamid.features.recentmatches.adapter.MatchesItem
import kotlinx.android.synthetic.main.fragment_matches.*
import javax.inject.Inject

@Layout(R.layout.fragment_matches)
class RecentMatchesFragment : BaseFragment(), RecentMatchesView {

    companion object {

        fun getNewInstance() = RecentMatchesFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: RecentMatchesPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private lateinit var matchesAdapter: MatchesAdapter

    override fun initUi() {
        val glide = Glide.with(this)
        matchesAdapter = MatchesAdapter(presenter, glide)
        with(list_matches) {
            adapter = matchesAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean) {
        loader.setVisible(show)
    }

    override fun updateMatches(items: List<MatchesItem>) {
        matchesAdapter.items = items
    }
}
