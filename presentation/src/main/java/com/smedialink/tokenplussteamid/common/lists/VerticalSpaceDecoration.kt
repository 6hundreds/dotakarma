package com.smedialink.tokenplussteamid.common.lists

import android.graphics.Rect
import android.support.annotation.DimenRes
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by six_hundreds on 24.04.18.
 */
class VerticalSpaceDecoration(@DimenRes private val space: Int,
                              private val includeTop: Boolean = false,
                              private val includeBottom: Boolean = false) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        if (parent.getChildAdapterPosition(view) == 0 && includeTop) {
            outRect.top = parent.resources.getDimensionPixelSize(space)
        }
        if (parent.getChildAdapterPosition(view) == parent.adapter.itemCount - 1 && !includeBottom) {
            outRect.bottom = 0
        } else {
            outRect.bottom = parent.resources.getDimensionPixelSize(space)
        }
    }
}