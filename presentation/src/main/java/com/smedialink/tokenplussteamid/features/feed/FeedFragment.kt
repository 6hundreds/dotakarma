package com.smedialink.tokenplussteamid.features.feed

import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment

class FeedFragment : BaseFragment(), FeedView {

    companion object {
        fun getNewInstance() = FeedFragment()

        const val TAG = "FeedFragment"
    }

    override val layoutId: Int
        get() = R.layout.fragment_feed
}
