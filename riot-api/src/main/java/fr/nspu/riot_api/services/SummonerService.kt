package fr.nspu.riot_api.services

import fr.nspu.riot_api.models.Summoner
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 13/03/18.
 */
interface SummonerService {
    /**
     * Summoner by account id
     */
    @GET(RiotUri.URI_SUMMOMER_BY_ACCOUNT_ID)
    fun getSummonerByAccountId(@Path("accountId") accountId: Long): Summoner?

    @GET(RiotUri.URI_SUMMOMER_BY_ACCOUNT_ID)
    fun getSummonerByAccountId(@Path("accountId") accountId: Long, @QueryMap options: Map<String, String>): Summoner?

    @GET(RiotUri.URI_SUMMOMER_BY_ACCOUNT_ID)
    fun getSummonerByAccountId(@Path("accountId") accountId: Long, callback: Callback<Summoner>)

    @GET(RiotUri.URI_SUMMOMER_BY_ACCOUNT_ID)
    fun getSummonerByAccountId(@Path("accountId") accountId: Long, @QueryMap options: Map<String, String>, callback: Callback<Summoner>)

    /**
     * Summoner by name
     */
    @GET(RiotUri.URI_SUMMONER_BY_NAME)
    fun getSummonerByName(@Path("summonerName") summonerName: String): Summoner?

    @GET(RiotUri.URI_SUMMONER_BY_NAME)
    fun getSummonerByName(@Path("summonerName") summonerName: String, @QueryMap options: Map<String, String>): Summoner?

    @GET(RiotUri.URI_SUMMONER_BY_NAME)
    fun getSummonerByName(@Path("summonerName") summonerName: String, callback: Callback<Summoner>)

    @GET(RiotUri.URI_SUMMONER_BY_NAME)
    fun getSummonerByName(@Path("summonerName") summonerName: String, @QueryMap options: Map<String, String>, callback: Callback<Summoner>)

    /**
     * Summoner by Summoner Id
     */
    @GET(RiotUri.URI_SUMMONER_BY_SUMMONER_ID)
    fun getSummonerBySummonerId(@Path("summonerId") summonerId: Long): Summoner?

    @GET(RiotUri.URI_SUMMONER_BY_SUMMONER_ID)
    fun getSummonerBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>): Summoner?

    @GET(RiotUri.URI_SUMMONER_BY_SUMMONER_ID)
    fun getSummonerBySummonerId(@Path("summonerId") summonerId: Long, callback: Callback<Summoner>)

    @GET(RiotUri.URI_SUMMONER_BY_SUMMONER_ID)
    fun getSummonerBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>, callback: Callback<Summoner>)

}