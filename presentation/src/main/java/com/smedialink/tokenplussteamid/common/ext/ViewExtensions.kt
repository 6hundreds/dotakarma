package com.smedialink.tokenplussteamid.common.ext

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.layout_highlighter.view.*

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

fun RecyclerView.ViewHolder.highlight() {
    ViewAnimator
            .animate(itemView.highlighter)
            .alpha(0f, 1f, 0f)
            .duration(1000)
            .start()
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard(target: TextView) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(target, 0)
}
