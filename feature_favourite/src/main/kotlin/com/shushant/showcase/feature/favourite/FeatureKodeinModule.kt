package com.shushant.showcase.feature.favourite

import com.shushant.cleanarchitecture.app.feature.KodeinModuleProvider
import com.shushant.showcase.feature.favourite.data.dataModule
import com.shushant.showcase.feature.favourite.domain.domainModule
import com.shushant.showcase.feature.favourite.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Favourite"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
