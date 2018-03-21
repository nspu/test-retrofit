package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.RankedType
import fr.nspu.riot_api.models.LeagueList
import fr.nspu.riot_api.models.LeaguePosition
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * league
 */
interface LeagueService {
    /**
     * Get the challenger league for given queue.
     *
     * @param queue type of the queue [RankedType]
     * @param options Optional parameters. Nullable
     * @return Requested challenger league
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Get the challenger league</a>
     */
    @GET(RiotUri.URI_LEAGUE_CHALLENGER_BY_QUEUE)
    fun getChallengersByQueue(@Path("queue") queue: RankedType, @QueryMap options: Map<String, String>? = null): LeagueList?

    /**
     * Get the challenger league for given queue.
     *
     * @param queue type of the queue [RankedType]
     * @param callback Callback method. Success callback will return challenger league
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Get the challenger league</a>
     */
    @GET(RiotUri.URI_LEAGUE_CHALLENGER_BY_QUEUE)
    fun getChallengersByQueue(@Path("queue") queue: RankedType, callback: Callback<LeagueList>, @QueryMap options: Map<String, String>? = null)


    /**
     * Get league with given ID, including inactive entries.
     *
     * @param leagueId id of the league
     * @param options Optional parameters. Nullable
     * @return Requested the league
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getLeagueById">Get the league</a>
     */
    @GET(RiotUri.URI_LEAGUE_BY_ID)
    fun getLeagueById(@Path("leagueId") leagueId: String, @QueryMap options: Map<String, String>? = null): LeagueList?

    /**
     * Get league with given ID, including inactive entries.
     *
     * @param leagueId id of the league
     * @param callback Callback method. Success callback will return the league
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getLeagueById">Get the league</a>
     */
    @GET(RiotUri.URI_LEAGUE_BY_ID)
    fun getLeagueById(@Path("leagueId") leagueId: String, callback: Callback<LeagueList>, @QueryMap options: Map<String, String>? = null)


    /**
     * Get the master league for given queue.
     *
     * @param queue type of the queue [RankedType]
     * @param options Optional parameters. Nullable
     * @return Requested the master league
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getMasterLeague">Get the master league</a>
     */
    @GET(RiotUri.URI_LEAGUE_MASTER_BY_QUEUE)
    fun getLeagueMasterByQueue(@Path("queue") queue: RankedType, @QueryMap options: Map<String, String>? = null): LeagueList?

    /**
     * Get the master league for given queue.
     *
     * @param queue type of the queue [RankedType]
     * @param callback Callback method. Success callback will return the master league
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getMasterLeague">Get the master league</a>
     */
    @GET(RiotUri.URI_LEAGUE_MASTER_BY_QUEUE)
    fun getLeagueMasterByQueue(@Path("queue") queue: RankedType, callback: Callback<LeagueList>, @QueryMap options: Map<String, String>? = null)


    /**
     * Get league positions in all queues for a given summoner ID.
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return Requested league positions
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguePositionsForSummoner">Get league positions</a>
     */
    @GET(RiotUri.URI_LEAGUE_POSITION_BY_SUMMONER)
    fun getPositionBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? = null): Set<LeaguePosition>?

    /**
     * Get league positions in all queues for a given summoner ID.
     *
     * @param summonerId id of the summoner
     * @param callback Callback method. Success callback will return league positions
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguePositionsForSummoner">Get league positions</a>
     */
    @GET(RiotUri.URI_LEAGUE_POSITION_BY_SUMMONER)
    fun getPositionBySummoner(@Path("summonerId") summonerId: Long, callback: Callback<Set<LeaguePosition>>, @QueryMap options: Map<String, String>? = null)
}