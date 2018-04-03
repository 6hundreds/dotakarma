package com.smedialink.tokenplussteamid.di

import com.smedialink.tokenplussteamid.app.DotaKarma
import com.smedialink.tokenplussteamid.di.modules.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            ActivityBinderModule::class,
            AndroidSupportInjectionModule::class,
            AndroidInjectionModule::class,
            PersistanceModule::class,
            NavigationModule::class,
            NetworkModule::class]
)
interface AppComponent : AndroidInjector<DotaKarma> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DotaKarma>()
}
