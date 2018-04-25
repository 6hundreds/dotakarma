package com.smedialink.tokenplussteamid.common.lists

import android.graphics.Rect
import android.support.annotation.DimenRes
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by six_hundreds on 24.04.18.
 */
class VerticalSpaceDecoration(@DimenRes val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = parent.resources.getDimensionPixelSize(space)
        }
        outRect.bottom = parent.resources.getDimensionPixelSize(space)
    }
}