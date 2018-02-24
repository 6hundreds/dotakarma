package com.smedialink.tokenplussteamid.views

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.smedialink.tokenplussteamid.R
import kotlinx.android.synthetic.main.view_compound_field_comment.view.*
import java.lang.IllegalArgumentException

/**
 * Created by six_hundreds on 24.02.18.
 */
class FieldCommentView(context: Context, attributeSet: AttributeSet)
    : FrameLayout(context, attributeSet) {

    var clickAction: ((text: String) -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_compound_field_comment, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        field_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable) {
                button_send.apply {
                    alpha = if (p0.isNotEmpty()) 1.0f else 0.5f
                    isEnabled = p0.isNotEmpty()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        button_send.setOnClickListener {
            clickAction?.invoke(field_input.text.toString())
                    ?: throw IllegalArgumentException("Provide action for sending message")
        }
    }
}