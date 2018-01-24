package com.smedialink.tokenplussteamid.di

import com.smedialink.tokenplussteamid.DotaKarma
import com.smedialink.tokenplussteamid.di.modules.*
import com.smedialink.tokenplussteamid.di.modules.contribution.ActivityContributionModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (ActivityContributionModule::class),
        (AppModule::class),
        (DbModule::class),
        (NavigationModule::class),
        (NetworkModule::class),
        (SessionManagerModule::class)]
)
interface AppComponent : AndroidInjector<DotaKarma> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DotaKarma>()
}
