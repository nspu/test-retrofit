package fr.nspu.riot_api.services

import fr.nspu.riot_api.models.Match
import fr.nspu.riot_api.models.MatchList
import fr.nspu.riot_api.models.MatchTimeline
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 13/03/18.
 */
interface MatchService {
    /**
     * Match by id
     */
    @GET(RiotUri.URI_MATCH_BY_ID)
    fun getMatchById(@Path("matchId") matchId: Long ): Match?

    @GET(RiotUri.URI_MATCH_BY_ID)
    fun getMatchById(@Path("matchId") matchId: Long , @QueryMap options: Map<String, String>): Match?

    @GET(RiotUri.URI_MATCH_BY_ID)
    fun getMatchById(@Path("matchId") matchId: Long , callback: Callback<Match>)

    @GET(RiotUri.URI_MATCH_BY_ID)
    fun getMatchById(@Path("matchId") matchId: Long , @QueryMap options: Map<String, String>, callback: Callback<Match>)

    /**
     * Matches by accountId
     */
    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT)
    fun getMatchListByAccountId(@Path("accountId") accountId: Long ): MatchList?

    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT)
    fun getMatchListByAccountId(@Path("accountId") accountId: Long , @QueryMap options: Map<String, String>): MatchList?

    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT)
    fun getMatchListByAccountId(@Path("accountId") accountId: Long , callback: Callback<MatchList>)

    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT)
    fun getMatchListByAccountId(@Path("accountId") accountId: Long , @QueryMap options: Map<String, String>, callback: Callback<MatchList>)

    /**
     * Recent Matches by accountId
     */
    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT_RECENT)
    fun getRecentMatchListByAccountId(@Path("accountId") accountId: Long ): MatchList?

    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT_RECENT)
    fun getRecentMatchListByAccountId(@Path("accountId") accountId: Long , @QueryMap options: Map<String, String>): MatchList?

    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT_RECENT)
    fun getRecentMatchListByAccountId(@Path("accountId") accountId: Long , callback: Callback<MatchList>)

    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT_RECENT)
    fun getRecentMatchListByAccountId(@Path("accountId") accountId: Long , @QueryMap options: Map<String, String>, callback: Callback<MatchList>)

    /**
     * Timeline by match
     */
    @GET(RiotUri.URI_MATCH_TIMELINE_BY_ID)
    fun getTimelineByMatchId(@Path("matchId") matchId: Long ): MatchTimeline?

    @GET(RiotUri.URI_MATCH_TIMELINE_BY_ID)
    fun getTimelineByMatchId(@Path("matchId") matchId: Long, @QueryMap options: Map<String, String>): MatchTimeline?

    @GET(RiotUri.URI_MATCH_TIMELINE_BY_ID)
    fun getTimelineByMatchId(@Path("matchId") matchId: Long, callback: Callback<MatchTimeline>)

    @GET(RiotUri.URI_MATCH_TIMELINE_BY_ID)
    fun getTimelineByMatchId(@Path("matchId") matchId: Long, @QueryMap options: Map<String, String>, callback: Callback<MatchTimeline>)


    /**
     * Tournament code
     * TODO not testing (need tournament code)
     */
    @GET(RiotUri.URI_IDS_MATCH_LIST_BY_TOURNAMENT)
    fun getIdsMatchListByTounrament(@Path("tournamentCode") tournamentCode: String ): List<Long>?

    @GET(RiotUri.URI_IDS_MATCH_LIST_BY_TOURNAMENT)
    fun getIdsMatchListByTounrament(@Path("tournamentCode") tournamentCode: Long, @QueryMap options: Map<String, String>): List<Long>?

    @GET(RiotUri.URI_IDS_MATCH_LIST_BY_TOURNAMENT)
    fun getIdsMatchListByTounrament(@Path("tournamentCode") tournamentCode: Long, callback: Callback<List<Long>>)

    @GET(RiotUri.URI_IDS_MATCH_LIST_BY_TOURNAMENT)
    fun getIdsMatchListByTounrament(@Path("tournamentCode") tournamentCode: Long, @QueryMap options: Map<String, String>, callback: Callback<List<Long>>)

    /**
     * Match by matchid and Tournament code
     * TODO not testing (need tournament code)
     */
    @GET(RiotUri.URI_MATCH_BY_ID_BY_TOUNRAMENT)
    fun getMatchByMatchIdAndByTounrament(@Path("matchId") matchId: Long,@Path("tournamentCode") tournamentCode: String ): Match?

    @GET(RiotUri.URI_MATCH_BY_ID_BY_TOUNRAMENT)
    fun getMatchByMatchIdAndByTounrament(@Path("matchId") matchId: Long,@Path("tournamentCode") tournamentCode: Long, @QueryMap options: Map<String, String>): Match?

    @GET(RiotUri.URI_MATCH_BY_ID_BY_TOUNRAMENT)
    fun getMatchByMatchIdAndByTounrament(@Path("matchId") matchId: Long,@Path("tournamentCode") tournamentCode: Long, callback: Callback<Match>)

    @GET(RiotUri.URI_MATCH_BY_ID_BY_TOUNRAMENT)
    fun getMatchByMatchIdAndByTounrament(@Path("matchId") matchId: Long,@Path("tournamentCode") tournamentCode: Long, @QueryMap options: Map<String, String>, callback: Callback<Match>)

}