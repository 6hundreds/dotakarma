package com.smedialink.tokenplussteamid.di

import android.content.Context
import com.smedialink.tokenplussteamid.MyApp
import com.smedialink.tokenplussteamid.di.modules.AppModule
import com.smedialink.tokenplussteamid.di.modules.NavigationModule
import com.smedialink.tokenplussteamid.di.modules.contribution.ActivityContributionModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (ActivityContributionModule::class),
    (AppModule::class),
    (NavigationModule::class)]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApp)
}