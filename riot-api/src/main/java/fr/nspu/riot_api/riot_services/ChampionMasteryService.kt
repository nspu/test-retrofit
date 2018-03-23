package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.ChampionMastery
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * champion-mastery
 */
interface ChampionMasteryService{
    /**
     * Get all champion mastery entries sorted by number of champion points descending
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return Requested all champion mastery entries
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getAllChampionMasteries">Get all champion mastery entries</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER)
    fun getChampionMasteriesBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? =null): Call<List<ChampionMastery>>?

    /**
     * Get all champion mastery entries sorted by number of champion points descending
     *
     * @param summonerId id of the summoner
     * @param callback Callback method. Success callback will return all champion mastery entries
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getAllChampionMasteries">Get champion mastery entries</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER)
    fun getChampionMasteriesBySummoner(@Path("summonerId") summonerId: Long, callback: Callback<List<ChampionMastery>>, @QueryMap options: Map<String, String>? =null)

    /**
     * Get a champion mastery by player ID and champion ID
     *
     * @param summonerId id of the summoner
     * @param championId id of champion
     * @param options Optional parameters. Nullable
     * @return Requested champion mastery entries
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMastery">Get champion mastery entries</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION)
    fun getChampionMasteriesBySummonerByChampion(@Path("summonerId") summonerId: Long, @Path("championId") championId: Long, @QueryMap options: Map<String, String>? =null): ChampionMastery?

    /**
     * Get a champion mastery by player ID and champion ID
     *
     * @param summonerId id of the summoner
     * @param championId id of champion
     * @param callback Callback method. Success callback will return champion mastery entries
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMastery">Get champion mastery entries</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION)
    fun getChampionMasteriesBySummonerByChampion(@Path("summonerId") summonerId: Long, @Path("championId") championId: Long, callback: Callback<ChampionMastery>, @QueryMap options: Map<String, String>? =null)

    /**
     * Get a player's total champion mastery score, which is the sum of individual champion mastery levels
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return Requested total champion mastery score
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMasteryScore">Get total champion mastery score</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER)
    fun getScoresBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? =null): Int?

    /**
     * Get a player's total champion mastery score, which is the sum of individual champion mastery levels
     *
     * @param summonerId id of the summoner
     * @param callback Callback method. Success callback will return total champion mastery score
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMasteryScore">Get total champion mastery score</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER)
    fun getScoresBySummoner(@Path("summonerId") summonerId: Long, callback: Callback<Int>, @QueryMap options: Map<String, String>? =null)

}