package com.shushant.cleanarchitecture.app

import android.content.Context
import com.facebook.stetho.Stetho
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.shushant.cleanarchitecture.BuildConfig
import com.shushant.cleanarchitecture.app.feature.FeatureManager
import com.shushant.cleanarchitecture.app.kodein.FragmentArgsExternalSource
import com.shushant.cleanarchitecture.appModule
import com.shushant.cleanarchitecture.base.baseModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber

/*
False positive "Unused symbol" for a custom Android application class referenced in AndroidManifest.xml file:
https://youtrack.jetbrains.net/issue/KT-27971
*/
class CleanArchitectureApplication : SplitCompatApplication(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@CleanArchitectureApplication))
        import(appModule)
        import(baseModule)
        importAll(FeatureManager.kodeinModules)

        externalSources.add(FragmentArgsExternalSource())
    }

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this

        initTimber()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
