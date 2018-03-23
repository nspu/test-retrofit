package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.ChampionInfo
import fr.nspu.riot_api.models.ChampionListInfo
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * champion
 */
interface ChampionService {
    /**
     * Retrieve all champions.
     *
     * @param options Optional parameters. Nullable
     * @return Requested all champion
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Retrieve all champions</a>
     */
    @GET(RiotUri.URI_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>? =null): ChampionListInfo?

    /**
     * Retrieve all champions.
     *
     * @param options Optional parameters. Nullable
     * @param callback Callback method. Success callback will return all champion
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Retrieve all champions</a>
     */
    @GET(RiotUri.URI_CHAMPIONS)
    fun getChampions(callback: Callback<ChampionListInfo>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieve champion by ID.
     *
     * @param options Optional parameters. Nullable
     * @return Requested all champion
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampionsById">Retrieve champion by ID</a>
     */
    @GET(RiotUri.URI_CHAMPION)
    fun getChampion(@Path("id") id: Long,@QueryMap options: Map<String, String>? =null): ChampionInfo?

    /**
     * Retrieve champion by ID.
     *
     * @param options Optional parameters. Nullable
     * @param callback Callback method. Success callback will return champion
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampionsById">Retrieve champion by ID</a>
     */
    @GET(RiotUri.URI_CHAMPION)
    fun getChampion(@Path("id") id: Long, callback: Callback<ChampionInfo> ,@QueryMap options: Map<String, String>? =null)
}