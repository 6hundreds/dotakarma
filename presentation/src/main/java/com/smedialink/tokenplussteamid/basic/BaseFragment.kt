package com.smedialink.tokenplussteamid.basic

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.smedialink.tokenplussteamid.app.Layout
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

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val clazz = javaClass
        if (!clazz.isAnnotationPresent(Layout::class.java)) {
            throw IllegalArgumentException("Please specify LayoutRes for fragment in @Layout annotation")
        }
        val layout = clazz.getAnnotation(Layout::class.java).value
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    abstract fun initUi()

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}
