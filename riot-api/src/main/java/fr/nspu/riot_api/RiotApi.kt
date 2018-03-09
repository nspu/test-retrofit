package fr.nspu.riot_api

/**
 * Created by nspu on 09/03/18.
 */

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
 */
class RiotApi {
    companion object {

        /**
         * Main Riot API endpoint
         * Refer back to https://developer.riotgames.com/regional-endpoints.html to find your endpoint-country
         */
        val RIOT_API_ENDPOINT = "na1.api.riotgames.com"
    }

    /**
     * @return The RiotApi instance
     */
    val service: RiotService


    private var accessToken: String? = null

    /**
     * The request interceptor that will add the header with OAuth
     * token to every request made with the wrapper.
     */
    private inner class ApiAuthenticator : RequestInterceptor {
        override fun intercept(request: RequestInterceptor.RequestFacade)
                = request.addQueryParam("key", accessToken!!)

    }

    /**
     * Create instance of RiotApi with given executors.
     *
     * @param httpExecutor executor for http request. Cannot be null.
     * @param callbackExecutor executor for callbacks. If null is passed than the same
     * thread that created the instance is used.
     */
    constructor(httpExecutor: Executor, callbackExecutor: Executor) {
        service = init(httpExecutor, callbackExecutor)
    }

    /**
     * New instance of RiotApi,
     * with single thread executor both for http and callbacks.
     */
    constructor() {
        val httpExecutor = Executors.newSingleThreadExecutor()
        val callbackExecutor = MainThreadExecutor()
        service = init(httpExecutor, callbackExecutor)
    }

    private fun init(httpExecutor: Executor, callbackExecutor: Executor): RiotService {

        val restAdapter = RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(RIOT_API_ENDPOINT)
                .setRequestInterceptor(ApiAuthenticator())
                .build()

        return restAdapter.create(RiotService::class.java)
    }
}
