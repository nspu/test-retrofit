package fr.nspu.sample_riot_api

import fr.nspu.riot_api.RiotApi

/**
 * Created by nspu on 13/03/18.
 */

internal class RiotService private constructor(private val apiKey: String) {
    val riotApi: RiotApi = RiotApi(apiKey, "")

    companion object {
        var instance: RiotService? = null
            private set

        fun init(apiKey: String) {
            instance = RiotService(apiKey)
        }
    }
}
