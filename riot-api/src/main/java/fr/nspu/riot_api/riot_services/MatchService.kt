package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.Match
import fr.nspu.riot_api.models.MatchList
import fr.nspu.riot_api.models.MatchTimeline
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * match
 */
interface MatchService {
    /**
     * Get match by match ID.
     *
     * @param matchId id of the match
     * @param options Optional parameters. Nullable
     * @return Requested the match
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Get the match</a>
     */
    @GET(RiotUri.URI_MATCH_BY_ID)
    fun getMatchById(@Path("matchId") matchId: Long, @QueryMap options: Map<String, String>? =null): Match?

    /**
     * Get match by match ID.
     *
     * @param matchId id of the match
     * @param callback Callback method. Success callback will return match
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Get the match</a>
     */
    @GET(RiotUri.URI_MATCH_BY_ID)
    fun getMatchById(@Path("matchId") matchId: Long, callback: Callback<Match>, @QueryMap options: Map<String, String>? =null)

    /**
     * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
     *
     * @param accountId id of the account
     * @param options Optional parameters. Nullable
     * @return Requested list of match
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Get list of match</a>
     */
    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT)
    fun getMatchListByAccountId(@Path("accountId") accountId: Long, @QueryMap options: Map<String, String>? =null): MatchList?

    /**
     * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
     *
     * @param accountId id of the account
     * @param callback Callback method. Success callback will return list of match
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Get list of match</a>
     */
    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT)
    fun getMatchListByAccountId(@Path("accountId") accountId: Long, callback: Callback<MatchList>, @QueryMap options: Map<String, String>? =null)

    /**
     * Get matchlist for last 20 matches played on given account ID and platform ID.
     *
     * @param accountId id of the account
     * @param options Optional parameters. Nullable
     * @return Requested list of last match
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getRecentMatchlist">Get list last match</a>
     */
    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT_RECENT)
    fun getRecentMatchListByAccountId(@Path("accountId") accountId: Long, @QueryMap options: Map<String, String>? =null): MatchList?

    /**
     * Get matchlist for last 20 matches played on given account ID and platform ID.
     *
     * @param accountId id of the account
     * @param callback Callback method. Success callback will return list of last match
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getRecentMatchlist">Get list last match</a>
     */
    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT_RECENT)
    fun getRecentMatchListByAccountId(@Path("accountId") accountId: Long, callback: Callback<MatchList>, @QueryMap options: Map<String, String>? =null)

    /**
     * Get match timeline by match ID.
     *
     * @param matchId id of the match
     * @param options Optional parameters. Nullable
     * @return Requested match timeline
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Get match timeline</a>
     */
    @GET(RiotUri.URI_MATCH_TIMELINE_BY_ID)
    fun getTimelineByMatchId(@Path("matchId") matchId: Long, @QueryMap options: Map<String, String>? =null): MatchTimeline?

    /**
     * Get match timeline by match ID.
     *
     * @param matchId id of the match
     * @param callback Callback method. Success callback will return match timeline
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Get match timeline</a>
     */
    @GET(RiotUri.URI_MATCH_TIMELINE_BY_ID)
    fun getTimelineByMatchId(@Path("matchId") matchId: Long, callback: Callback<MatchTimeline>, @QueryMap options: Map<String, String>? =null)

    //TODO not testing (need tournament code)
    /**
     * Get match IDs by tournament code
     *
     * @param tournamentCode tournament code
     * @param options Optional parameters. Nullable
     * @return Requested match ids
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Get match ids</a>
     */
    @GET(RiotUri.URI_IDS_MATCH_LIST_BY_TOURNAMENT)
    fun getIdsMatchListByTounrament(@Path("tournamentCode") tournamentCode: Long, @QueryMap options: Map<String, String>? =null): List<Long>?

    /**
     * Get match IDs by tournament code
     *
     * @param tournamentCode tournament code
     * @param callback Callback method. Success callback will return match ids
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Get match ids</a>
     */
    @GET(RiotUri.URI_IDS_MATCH_LIST_BY_TOURNAMENT)
    fun getIdsMatchListByTounrament(@Path("tournamentCode") tournamentCode: Long, callback: Callback<List<Long>>, @QueryMap options: Map<String, String>? =null)

    //TODO not testing (need tournament code)
    /**
     * Get match by match ID and tournament code.
     *
     * @param matchId id of the match
     * @param options Optional parameters. Nullable
     * @return Requested match
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchByTournamentCode">Get match</a>
     */
    @GET(RiotUri.URI_MATCH_BY_ID_BY_TOUNRAMENT)
    fun getMatchByMatchIdAndByTounrament(@Path("matchId") matchId: Long, @Path("tournamentCode") tournamentCode: Long, @QueryMap options: Map<String, String>? =null): Match?

    /**
     * Get match by match ID and tournament code.
     *
     * @param matchId id of the match
     * @param callback Callback method. Success callback will return match
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchByTournamentCode">Get match</a>
     */
    @GET(RiotUri.URI_MATCH_BY_ID_BY_TOUNRAMENT)
    fun getMatchByMatchIdAndByTounrament(@Path("matchId") matchId: Long, @Path("tournamentCode") tournamentCode: Long, callback: Callback<Match>, @QueryMap options: Map<String, String>? =null)

}