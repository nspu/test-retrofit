package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.ChampionInfo
import fr.nspu.riot_api.models.ChampionListInfo
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 12/03/18.
 */
interface ChampionService {
    /**
     * Champions
     */
    @GET(RiotUri.URI_CHAMPIONS)
    fun getChampions(): ChampionListInfo?

    @GET(RiotUri.URI_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>): ChampionListInfo?

    @GET(RiotUri.URI_CHAMPIONS)
    fun getChampions(callback: Callback<ChampionListInfo>)

    @GET(RiotUri.URI_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>, callback: Callback<ChampionListInfo>)

    /**
     * Champion
     */
    @GET(RiotUri.URI_CHAMPION)
    fun getChampion(@Path("id") id: Long ): ChampionInfo?

    @GET(RiotUri.URI_CHAMPION)
    fun getChampion(@Path("id") id: Long,@QueryMap options: Map<String, String>): ChampionInfo?

    @GET(RiotUri.URI_CHAMPION)
    fun getChampion(@Path("id") id: Long,callback: Callback<ChampionInfo>)

    @GET(RiotUri.URI_CHAMPION)
    fun getChampion(@Path("id") id: Long,@QueryMap options: Map<String, String>, callback: Callback<ChampionInfo>)
}