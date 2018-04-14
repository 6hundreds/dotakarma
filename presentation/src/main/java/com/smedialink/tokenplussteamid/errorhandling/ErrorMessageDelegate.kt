package com.smedialink.tokenplussteamid.errorhandling

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import com.androidadvance.topsnackbar.TSnackbar
import com.smedialink.tokenplussteamid.R
import java.lang.ref.WeakReference

/**
 * Created by six_hundreds on 24.02.18.
 */
class ErrorMessageDelegate(private val activity: WeakReference<AppCompatActivity>) {

    fun showError(error: String) {
        val snackbar = TSnackbar.make(activity.get()?.findViewById(android.R.id.content)
                ?: throw IllegalArgumentException("Weak ref on activity is empty"),
                error, TSnackbar.LENGTH_SHORT)

        with(snackbar) {
            setIconLeft(R.drawable.ic_warning, 36f)
            setIconPadding(16)
            view.setBackgroundColor(Color.parseColor("#FF505B64"))
            show()
        }

    }
}