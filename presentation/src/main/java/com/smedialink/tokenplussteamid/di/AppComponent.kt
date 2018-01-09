package com.smedialink.tokenplussteamid.di

import android.content.Context
import com.smedialink.tokenplussteamid.MyApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApp)
}
