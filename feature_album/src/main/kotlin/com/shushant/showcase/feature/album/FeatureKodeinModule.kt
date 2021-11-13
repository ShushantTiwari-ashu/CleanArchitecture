package com.shushant.showcase.feature.album

import com.shushant.cleanarchitecture.app.feature.KodeinModuleProvider
import com.shushant.showcase.feature.album.data.dataModule
import com.shushant.showcase.feature.album.domain.domainModule
import com.shushant.showcase.feature.album.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Album"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
