package com.smedialink.tokenplussteamid.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.widget.RxTextView
import com.smedialink.tokenplussteamid.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.view_compound_input_comment.view.*
import java.lang.IllegalArgumentException


/**
 * Created by six_hundreds on 24.02.18.
 */
class InputCommentView(context: Context, attributeSet: AttributeSet)
    : FrameLayout(context, attributeSet) {

    var clickAction: ((text: String) -> Unit)? = null

    private val disposables = CompositeDisposable()

    init {
        LayoutInflater.from(context).inflate(R.layout.view_compound_input_comment, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        button_send.isEnabled = false
        button_send.setOnClickListener {
            clickAction?.invoke(field_input.text.toString())
                    ?: throw IllegalArgumentException("Need to provide action for sending message")

        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        RxTextView.textChanges(field_input)
                .subscribe({ c ->
                    button_send.apply {
                        alpha = if (c.isNotEmpty()) 1.0f else 0.5f
                        isEnabled = c.isNotEmpty()
                    }
                })
                .addTo(disposables)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        disposables.clear()
    }
}