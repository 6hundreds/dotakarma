package com.smedialink.tokenplussteamid.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.common.delegates.ErrorMessageDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment
    : MvpAppCompatFragment(),
        HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var errorDelegate: ErrorMessageDelegate

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val clazz = javaClass
        if (!clazz.isAnnotationPresent(Layout::class.java)) {
            throw IllegalArgumentException("Please specify LayoutRes for $this in @Layout annotation")
        }
        val layout = clazz.getAnnotation(Layout::class.java).value
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    abstract fun initUi()
}
