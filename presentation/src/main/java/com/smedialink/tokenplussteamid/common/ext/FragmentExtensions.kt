package com.smedialink.tokenplussteamid.common.ext

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by Sergey Opivalov on 23/03/2018.
 */
inline fun <T : Fragment> T.withArgs(
        argsBuilder: Bundle.() -> Unit): T =
        this.apply {
            arguments = Bundle().apply(argsBuilder)
        }