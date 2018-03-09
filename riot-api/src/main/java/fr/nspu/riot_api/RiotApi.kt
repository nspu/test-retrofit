package fr.nspu.riot_api

/**
 * Created by nspu on 09/03/18.
 */

import fr.nspu.riot_api.models.ErrorResponse
import java.util.concurrent.Executor
import java.util.concurrent.Executors

import retrofit.RequestInterceptor
import retrofit.RestAdapter
import retrofit.android.MainThreadExecutor

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

    val service: RiotService

    init {
        val restAdapter = RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(RIOT_API_ENDPOINT)
                .setRequestInterceptor(ApiAuthenticator())
                .build()
        service = restAdapter.create(RiotService::class.java)
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
        override fun intercept(request: RequestInterceptor.RequestFacade)
                = request.addQueryParam("key", accessToken!!)

    }

    companion object {

        /**
         * Main Riot API endpoint
         * Refer back to https://developer.riotgames.com/regional-endpoints.html to find your endpoint-country
         */
        val RIOT_API_ENDPOINT = "na1.api.riotgames.com"
    }
}
