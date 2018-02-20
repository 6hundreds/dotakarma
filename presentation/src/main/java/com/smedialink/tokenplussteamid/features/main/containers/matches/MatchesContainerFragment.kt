package com.smedialink.tokenplussteamid.features.main.containers.matches

import android.os.Bundle
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.subnavigation.TabContainerFragment

/**
 * Created by Sergey Opivalov on 14/02/2018.
 */
@Layout(R.layout.fragment_tab_container)
class MatchesContainerFragment : TabContainerFragment() {

    companion object {
        fun newInstance(containerTag: String) = MatchesContainerFragment().apply {
            arguments = Bundle().apply {
                putString(CONTAINER_TAG_KEY, containerTag)
            }
        }
    }

    override fun initUi() {}
}