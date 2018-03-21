package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.ShardStatus
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.QueryMap

/**
 * lol-status
 */
interface LoLStatusService{
    /**
     * Get League of Legends status for the given shard.
     *
     * @param options Optional parameters. Nullable
     * @return Requested status
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-status-v3/GET_getShardData">Get status</a>
     */
    @GET(RiotUri.URI_LOL_STATUS)
    fun getLoLStatus(@QueryMap options: Map<String, String>? =null): ShardStatus?

    /**
     * Get League of Legends status for the given shard.
     *
     * @param options Optional parameters. Nullable
     * @param callback Callback method. Success callback will return status
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-status-v3/GET_getShardData">Get status</a>
     */
    @GET(RiotUri.URI_LOL_STATUS)
    fun getLoLStatus(callback: Callback<ShardStatus>, @QueryMap options: Map<String, String>? =null)
}