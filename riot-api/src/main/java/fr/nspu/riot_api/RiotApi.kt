package fr.nspu.riot_api

/**
 * Created by nspu on 09/03/18.
 */

import fr.nspu.riot_api.services.ChampionMasteryService
import fr.nspu.riot_api.services.ChampionService
import fr.nspu.riot_api.services.StaticDataService
import retrofit.RequestInterceptor
import retrofit.RestAdapter
import retrofit.android.MainThreadExecutor
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Creates and configures a REST adapter for Riot API.
 *
 * Basic usage:
 * RiotApi riotApi = new RiotApi();
 *
 *  * Create instance of RiotApi with given executors.
 *   @param httpExecutor executor for http request. Cannot be null.
 *   @param callbackExecutor executor for callbacks. If null is passed than the same
 * thread that created the instance is used.
 */
class RiotApi(httpExecutor: Executor, callbackExecutor: Executor, private var accessToken: String) {

    val staticDataService: StaticDataService
    val championMasteryService: ChampionMasteryService
    val championService : ChampionService

    init {
        val restAdapter = RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(RIOT_API_ENDPOINT)
                .setRequestInterceptor(ApiAuthenticator())
                .build()
        staticDataService = restAdapter.create(StaticDataService::class.java)
        championMasteryService = restAdapter.create(ChampionMasteryService::class.java)
        championService = restAdapter.create(ChampionService::class.java)
    }

    /**
     *  New instance of RiotApi,
     *  with single thread executor both for http and callbacks.
     */
    constructor(accessToken: String) : this(Executors.newSingleThreadExecutor(), MainThreadExecutor(), accessToken)

    /**
     * The request interceptor that will add the header with OAuth
     * token to every request made with the wrapper.
     */
    private inner class ApiAuthenticator : RequestInterceptor {
        override fun intercept(request: RequestInterceptor.RequestFacade){
            request.addHeader("X-Riot-Token", accessToken!!)
//            request.addHeader("Accept-Language", "en-US,en;q=0.5\"")
        }

    }

    companion object {

        /**
         * Main Riot API endpoint
         * Refer back to https://developer.riotgames.com/regional-endpoints.html to find your endpoint-country
         */
        const val RIOT_API_ENDPOINT = "https://na1.api.riotgames.com"
    }
}
