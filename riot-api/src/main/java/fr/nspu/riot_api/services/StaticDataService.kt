package fr.nspu.riot_api.services

import fr.nspu.riot_api.models.Champion
import fr.nspu.riot_api.models.ChampionList
import fr.nspu.riot_api.models.Item
import fr.nspu.riot_api.models.ItemList
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 11/03/18.
 */
interface StaticDataService {
    /**
     * Champions
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(): ChampionList?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>): ChampionList?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(callback: Callback<ChampionList>)

    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>, callback: Callback<ChampionList>)

    /**
     * Champion
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path(RiotUri.ID) championId: Int): Champion?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path(RiotUri.ID) championId: Int, @QueryMap options: Map<String, String>): Champion?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path(RiotUri.ID) championId: Int, callback: Callback<Champion>)

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path(RiotUri.ID) championId: Int, @QueryMap options: Map<String, String>, callback: Callback<Champion>)

    /**
     * Items
     */
    @GET(RiotUri.URI_STATIC_DATA_ITEMS)
    fun getItems(): ItemList?

    @GET(RiotUri.URI_STATIC_DATA_ITEMS)
    fun getItems(@QueryMap options: Map<String, String>): ItemList?

    @GET(RiotUri.URI_STATIC_DATA_ITEMS)
    fun getItems(callback: Callback<ItemList>)

    @GET(RiotUri.URI_STATIC_DATA_ITEMS)
    fun getItems(@QueryMap options: Map<String, String>, callback: Callback<ItemList>)

    /**
     * Item
     */
    @GET(RiotUri.URI_STATIC_DATA_ITEM)
    fun getItem(@Path(RiotUri.ID) itemId: Int): Item?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getItem(@Path(RiotUri.ID) itemId: Int, @QueryMap options: Map<String, String>): Item?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getItem(@Path(RiotUri.ID) itemId: Int, callback: Callback<Item>)

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getItem(@Path(RiotUri.ID) itemId: Int, @QueryMap options: Map<String, String>, callback: Callback<Item>)
}