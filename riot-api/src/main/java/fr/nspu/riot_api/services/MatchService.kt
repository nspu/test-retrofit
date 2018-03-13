package fr.nspu.riot_api.services

import fr.nspu.riot_api.models.ChampionInfo
import fr.nspu.riot_api.models.Match
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

}