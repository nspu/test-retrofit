package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.Summoner
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * summoner
 */
interface SummonerService {
    /**
     * Get a summoner by account ID
     *
     * @param accountId id of the account
     * @param options Optional parameters. Nullable
     * @return Requested summoner
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getByAccountId">Get a summoner by account ID</a>
     */
    @GET(RiotUri.URI_SUMMOMER_BY_ACCOUNT_ID)
    fun getSummonerByAccountId(@Path("accountId") accountId: Long, @QueryMap options: Map<String, String>? =null): Summoner?

    /**
     * Get a summoner by account ID
     *
     * @param accountId id of the account
     * @param callback Callback method. Success callback will return summoner
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getByAccountId">Get a summoner by account ID</a>
     */
    @GET(RiotUri.URI_SUMMOMER_BY_ACCOUNT_ID)
    fun getSummonerByAccountId(@Path("accountId") accountId: Long, callback: Callback<Summoner>, @QueryMap options: Map<String, String>? =null)

    /**
     * Get a summoner by summoner name
     *
     * @param summonerName name of the summoner
     * @param options Optional parameters. Nullable
     * @return Requested summoner
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerName">Get a summoner by summoner name</a>
     */
    @GET(RiotUri.URI_SUMMONER_BY_NAME)
    fun getSummonerByName(@Path("summonerName") summonerName: String, @QueryMap options: Map<String, String>? =null): Summoner?

    /**
     * Get a summoner by summoner name
     *
     * @param summonerName name of the summoner
     * @param callback Callback method. Success callback will return summoner
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerName">Get a summoner by summoner name</a>
     */
    @GET(RiotUri.URI_SUMMONER_BY_NAME)
    fun getSummonerByName(@Path("summonerName") summonerName: String, callback: Callback<Summoner>, @QueryMap options: Map<String, String>? =null)

    /**
     * Get a summoner by summoner ID.
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return Requested summoner
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerId">Get a summoner by summoner ID</a>
     */
    @GET(RiotUri.URI_SUMMONER_BY_SUMMONER_ID)
    fun getSummonerBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? =null): Summoner?

    /**
     * Get a summoner by summoner ID.
     *
     * @param summonerId id of the summoner
     * @param callback Callback method. Success callback will return summoner
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerId">Get a summoner by summoner ID</a>
     */
    @GET(RiotUri.URI_SUMMONER_BY_SUMMONER_ID)
    fun getSummonerBySummonerId(@Path("summonerId") summonerId: Long, callback: Callback<Summoner>, @QueryMap options: Map<String, String>? =null)

}