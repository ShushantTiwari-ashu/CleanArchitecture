package com.shushant.showcase.feature.profile

import com.shushant.cleanarchitecture.app.feature.KodeinModuleProvider
import com.shushant.showcase.feature.profile.data.dataModule
import com.shushant.showcase.feature.profile.domain.domainModule
import com.shushant.showcase.feature.profile.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Profile"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
