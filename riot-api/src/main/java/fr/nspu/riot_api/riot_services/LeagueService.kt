package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.ModeQueue
import fr.nspu.riot_api.models.LeagueList
import fr.nspu.riot_api.models.LeaguePosition
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 12/03/18.
 */
interface LeagueService {
    /**
     * Challengers
     */
    @GET(RiotUri.URI_LEAGUE_CHALLENGER_BY_QUEUE)
    fun getChallengersByQueue(@Path("queue") queue:ModeQueue): LeagueList?

    @GET(RiotUri.URI_LEAGUE_CHALLENGER_BY_QUEUE)
    fun getChallengersByQueue(@Path("queue") queue:ModeQueue, @QueryMap options: Map<String, String>): LeagueList?

    @GET(RiotUri.URI_LEAGUE_CHALLENGER_BY_QUEUE)
    fun getChallengersByQueue(@Path("queue") queue:ModeQueue, callback: Callback<LeagueList>)

    @GET(RiotUri.URI_LEAGUE_CHALLENGER_BY_QUEUE)
    fun getChallengersByQueue(@Path("queue") queue:ModeQueue, @QueryMap options: Map<String, String>, callback: Callback<LeagueList>)


    /**
     * League by id
     */
    @GET(RiotUri.URI_LEAGUE_BY_ID)
    fun getLeagueById(@Path("leagueId") queue:String): LeagueList?

    @GET(RiotUri.URI_LEAGUE_BY_ID)
    fun getLeagueById(@Path("leagueId") queue:String,@QueryMap options: Map<String, String>): LeagueList?

    @GET(RiotUri.URI_LEAGUE_BY_ID)
    fun getLeagueById(@Path("leagueId") queue:String,callback: Callback<LeagueList>)

    @GET(RiotUri.URI_LEAGUE_BY_ID)
    fun getLeagueById(@Path("leagueId") queue:String,@QueryMap options: Map<String, String>, callback: Callback<LeagueList>)


    /**
     * MasterLeague by queue
     */
    @GET(RiotUri.URI_LEAGUE_MASTER_BY_QUEUE)
    fun getLeagueMasterByQueue(@Path("queue") queue:ModeQueue): LeagueList?

    @GET(RiotUri.URI_LEAGUE_MASTER_BY_QUEUE)
    fun getLeagueMasterByQueue(@Path("queue") queue:ModeQueue, @QueryMap options: Map<String, String>): LeagueList?

    @GET(RiotUri.URI_LEAGUE_MASTER_BY_QUEUE)
    fun getLeagueMasterByQueue(@Path("queue") queue:ModeQueue, callback: Callback<LeagueList>)

    @GET(RiotUri.URI_LEAGUE_MASTER_BY_QUEUE)
    fun getLeagueMasterByQueue(@Path("queue") queue:ModeQueue, @QueryMap options: Map<String, String>, callback: Callback<LeagueList>)


    /**
     * MasterLeague by queue
     */
    @GET(RiotUri.URI_LEAGUE_POSITION_BY_SUMMONER)
    fun getPositionBySummoner(@Path("summonerId") summonerId:Long): Set<LeaguePosition>?

    @GET(RiotUri.URI_LEAGUE_POSITION_BY_SUMMONER)
    fun getPositionBySummoner(@Path("summonerId") summonerId:Long,@QueryMap options: Map<String, String>): Set<LeaguePosition>?

    @GET(RiotUri.URI_LEAGUE_POSITION_BY_SUMMONER)
    fun getPositionBySummoner(@Path("summonerId") summonerId:Long,callback: Callback<Set<LeaguePosition>>)

    @GET(RiotUri.URI_LEAGUE_POSITION_BY_SUMMONER)
    fun getPositionBySummoner(@Path("summonerId") summonerId:Long,@QueryMap options: Map<String, String>, callback: Callback<Set<LeaguePosition>>)
}