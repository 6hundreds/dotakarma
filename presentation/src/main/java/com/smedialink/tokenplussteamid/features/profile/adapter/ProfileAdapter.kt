package com.smedialink.tokenplussteamid.features.profile.adapter

import android.support.v7.util.DiffUtil
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.smedialink.tokenplussteamid.common.HeterogeneousItem
import com.smedialink.tokenplussteamid.common.LoadMoreDelegate
import com.smedialink.tokenplussteamid.common.LoadMoreFooter
import com.smedialink.tokenplussteamid.common.Paginator
import com.smedialink.tokenplussteamid.features.profile.entity.CommentProfileUiModel

/**
 * Created by six_hundreds on 08.02.18.
 */
class ProfileAdapter(paginator: Paginator<HeterogeneousItem>)
    : ListDelegationAdapter<MutableList<HeterogeneousItem>>() {

    init {
        delegatesManager.addDelegate(CommentProfileDelegate())
//        delegatesManager.addDelegate(LoadMoreDelegate(paginator))
        setItems(mutableListOf())
    }


//    fun addItems(newItems: List<HeterogeneousItem>) {
//        if (items.size == newItems.size) return
//        items.addAll(0, newItems)
//        notifyItemRangeChanged(0, newItems.size)
//    }
//
//    fun appendItems(newItems: List<HeterogeneousItem>) {
//        val oldSize = items.size
//        if (oldSize == 0) {
//            items.addAll(0, newItems)
//            items.add(LoadMoreFooter())
//            notifyDataSetChanged()
//        } else {
//            items.addAll(oldSize - 1, newItems)
//            notifyItemRangeInserted(oldSize - 1, newItems.size)
//        }
//    }

//    fun addItems (newItems : List<HeterogeneousItem>) {
//        val oldSize = items.size
//        if (oldSize == 0) {
//            items.addAll(0, newItems)
//            items.add(LoadMoreFooter())
//    }
//
//
}