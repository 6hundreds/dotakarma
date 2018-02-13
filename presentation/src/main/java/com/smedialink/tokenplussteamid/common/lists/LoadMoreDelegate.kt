package com.smedialink.tokenplussteamid.common.lists

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.common.ext.inflate
import com.smedialink.tokenplussteamid.common.ext.setVisible
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_feed_load_more.view.*

/**
 * Created by six_hundreds on 30.01.18.
 */
class LoadMoreDelegate(private val paginator: Paginator<HeterogeneousItem>) :
        AbsListItemAdapterDelegate<LoadMoreFooter, HeterogeneousItem, LoadMoreDelegate.LoadMoreViewHolder>() {

    override fun onBindViewHolder(item: LoadMoreFooter,
                                  viewHolder: LoadMoreViewHolder,
                                  payloads: MutableList<Any>) {
    }

    override fun onCreateViewHolder(parent: ViewGroup): LoadMoreViewHolder {
        val view = parent.inflate(R.layout.item_feed_load_more)
        return LoadMoreViewHolder(view)
    }

    override fun isForViewType(item: HeterogeneousItem,
                               items: MutableList<HeterogeneousItem>,
                               position: Int): Boolean =
            item is LoadMoreFooter

    inner class LoadMoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                paginator.onLoadMore(5)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe { showLoading(true) }
                        .doFinally { showLoading(false) }
                        .subscribe({ items -> paginator.onSuccess(items) },
                                { e -> paginator.onError(e) })
            }
        }

        private fun showLoading(show: Boolean) {
            itemView.loader.setVisible(show)
            itemView.text_load_more.setVisible(!show)
        }
    }
}