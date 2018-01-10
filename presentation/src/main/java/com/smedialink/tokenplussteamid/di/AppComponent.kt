package com.smedialink.tokenplussteamid.di

import android.content.Context
import com.smedialink.tokenplussteamid.MyApp
import com.smedialink.tokenplussteamid.di.modules.AppModule
import com.smedialink.tokenplussteamid.di.modules.NavigationModule
import com.smedialink.tokenplussteamid.di.modules.NetworkModule
import com.smedialink.tokenplussteamid.di.modules.contribution.ActivityContributionModule
import com.smedialink.tokenplussteamid.di.modules.contribution.FragmentContributionModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (ActivityContributionModule::class),
    (FragmentContributionModule::class),
    (AppModule::class),
    (NavigationModule::class),
    (NetworkModule::class)]
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
