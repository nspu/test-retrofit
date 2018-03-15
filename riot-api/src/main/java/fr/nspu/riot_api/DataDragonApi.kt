package fr.nspu.riot_api

import fr.nspu.riot_api.data_dragon_services.DataDragonService
import retrofit.RestAdapter
import java.util.concurrent.Executor

/**
 * Created by nspu on 15/03/18.
 */
class DataDragonApi(httpExecutor: Executor,callbackExecutor: Executor) {
    val dataDragonService : DataDragonService

    init {
        val restAdapter = RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(DATA_DRAGON_API_ENDPOINT)
                .build()
        dataDragonService = restAdapter.create(DataDragonService::class.java)
    }


    companion object {

        /**
         * Main Riot API endpoint
         * Refer back to https://developer.riotgames.com/regional-endpoints.html to find your endpoint-country
         */
        const val DATA_DRAGON_API_ENDPOINT = "https://ddragon.leagueoflegends.com"
    }
}