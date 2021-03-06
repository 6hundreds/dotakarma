package com.smedialink.tokenplussteamid.app

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.smedialink.tokenplussteamid.BuildConfig
import com.smedialink.tokenplussteamid.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber
import javax.inject.Inject

class DotaKarma : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
            Realm.init(this)

            val configuration = RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build()
            Realm.setDefaultConfiguration(configuration)
        }

        DaggerAppComponent.builder().create(this).inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}
