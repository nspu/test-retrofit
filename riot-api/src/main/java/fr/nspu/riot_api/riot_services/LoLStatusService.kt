package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.ShardStatus
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.QueryMap

/**
 * Created by nspu on 13/03/18.
 */
interface LoLStatusService{
    /**
     * Status
     */
    @GET(RiotUri.URI_LOL_STATUS)
    fun getLoLStatus(): ShardStatus?

    @GET(RiotUri.URI_LOL_STATUS)
    fun getLoLStatus(@QueryMap options: Map<String, String>): ShardStatus?

    @GET(RiotUri.URI_LOL_STATUS)
    fun getLoLStatus(callback: Callback<ShardStatus>)

    @GET(RiotUri.URI_LOL_STATUS)
    fun getLoLStatus(@QueryMap options: Map<String, String>, callback: Callback<ShardStatus>)
}