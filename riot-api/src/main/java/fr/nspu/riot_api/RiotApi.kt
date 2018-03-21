package fr.nspu.riot_api

/**
 * Created by nspu on 09/03/18.
 */

import fr.nspu.riot_api.riot_services.*
import retrofit.RequestInterceptor
import retrofit.RestAdapter
import retrofit.android.MainThreadExecutor
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Creates and configures a REST adapter for Riot API.
 *
 * Basic usage:
 * RiotApi riotApi = new RiotApi(endPoint, accessToken);
 *
 *  * Create instance of RiotApi with given executors.
 *   @property httpExecutor executor for http request. Cannot be null.
 *   @property callbackExecutor executor for callbacks. If null is passed than the same
 *   @property endPoint url for the riot endpoint
 *   @property accessToken settings access token
 *
 *   @property staticDataService instance for access to static data
 *   @property championMasteryService: instance for access to champion mastery
 *   @property championService : instance for access to champions
 *   @property leagueService: instance for access to league
 *   @property lolStatusService : instance for access to lol status
 *   @property matchService: instance for access to match
 *   @property spectatorService: instance for access to spectator
 *   @property summonerService: instance for access to summoner
 *   @property thirdPartyCodeService: instance for access to third party code
 *   @constructor thread that created the instances.
 */
class RiotApi(
        httpExecutor: Executor,
        callbackExecutor: Executor,
        var endPoint:String,
        private var accessToken: String
) {

    val staticDataService: StaticDataService
    val championMasteryService: ChampionMasteryService
    val championService : ChampionService
    val leagueService: LeagueService
    val lolStatusService : LoLStatusService
    val matchService: MatchService
    val spectatorService: SpectatorService
    val summonerService: SummonerService
    val thirdPartyCodeService: ThirdPartyCodeService

    init {
        val restAdapter = RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(endPoint)
                .setRequestInterceptor(ApiAuthenticator())
                .build()
        staticDataService = restAdapter.create(StaticDataService::class.java)
        championMasteryService = restAdapter.create(ChampionMasteryService::class.java)
        championService = restAdapter.create(ChampionService::class.java)
        leagueService = restAdapter.create(LeagueService::class.java)
        lolStatusService = restAdapter.create(LoLStatusService::class.java)
        matchService = restAdapter.create(MatchService::class.java)
        spectatorService = restAdapter.create(SpectatorService::class.java)
        summonerService = restAdapter.create(SummonerService::class.java)
        thirdPartyCodeService = restAdapter.create(ThirdPartyCodeService::class.java)
    }

    /**
     *  New instance of RiotApi,
     *  with single thread executor both for http and callbacks.
     *   @param endPoint url for the riot endpoint
     *   @param accessToken settings access token
     */
    constructor(endPoint:String, accessToken: String) : this(
            Executors.newSingleThreadExecutor(),
            MainThreadExecutor(),
            endPoint,
            accessToken
    )

    /**
     * The request interceptor that will add the header with OAuth
     * token to every request made with the wrapper.
     */
    private inner class ApiAuthenticator : RequestInterceptor {
        override fun intercept(request: RequestInterceptor.RequestFacade){
            request.addHeader("X-Riot-Token", accessToken)
        }

    }
}
