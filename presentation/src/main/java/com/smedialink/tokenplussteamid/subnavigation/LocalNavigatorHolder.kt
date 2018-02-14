package com.smedialink.tokenplussteamid.subnavigation

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

/**
 * Created by Sergey Opivalov on 14/02/2018.
 */
class LocalNavigatorHolder(private val containers: HashMap<String, Cicerone<Router>> = hashMapOf()) {

    fun getCicerone(containerTag: String): Cicerone<Router> {
        return containers.getOrPut(containerTag, { Cicerone.create() })
    }
}