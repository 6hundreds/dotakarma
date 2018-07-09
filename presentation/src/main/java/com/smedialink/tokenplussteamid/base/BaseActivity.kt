package com.smedialink.tokenplussteamid.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.smedialink.tokenplussteamid.app.Layout
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

abstract class BaseActivity :
        MvpAppCompatActivity(),
        HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val clazz = javaClass
        if (!clazz.isAnnotationPresent(Layout::class.java)) {
            throw IllegalArgumentException("Please specify LayoutRes for $this in @Layout annotation")
        }
        val layout = clazz.getAnnotation(Layout::class.java).value
        setContentView(layout)
    }





    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector


}
