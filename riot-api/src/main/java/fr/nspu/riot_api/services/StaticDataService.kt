package fr.nspu.riot_api.services

import fr.nspu.riot_api.models.*
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


    /**
     * Language string
     */
    @GET(RiotUri.URI_STATIC_DATA_LANGUAGE_STRING)
    fun getLanguageString(): LanguageStrings?

    @GET(RiotUri.URI_STATIC_DATA_LANGUAGE_STRING)
    fun getLanguageString(@QueryMap options: Map<String, String>): LanguageStrings?

    @GET(RiotUri.URI_STATIC_DATA_LANGUAGE_STRING)
    fun getLanguageString(callback: Callback<LanguageStrings>)

    @GET(RiotUri.URI_STATIC_DATA_LANGUAGE_STRING)
    fun getLanguageString(@QueryMap options: Map<String, String>, callback: Callback<LanguageStrings>)

    /**
     * Language
     */
    @GET(RiotUri.URI_STATIC_DATA_LANGUAGES)
    fun getLanguages(): List<String>?

    @GET(RiotUri.URI_STATIC_DATA_LANGUAGES)
    fun getLanguages(@QueryMap options: Map<String, String>): List<String>?

    @GET(RiotUri.URI_STATIC_DATA_LANGUAGES)
    fun getLanguages(callback: Callback<List<String>>)

    @GET(RiotUri.URI_STATIC_DATA_LANGUAGES)
    fun getLanguages(@QueryMap options: Map<String, String>, callback: Callback<List<String>>)

    /**
     * Maps details
     */
    @GET(RiotUri.URI_STATIC_DATA_MAPS)
    fun getMaps(): Maps?

    @GET(RiotUri.URI_STATIC_DATA_MAPS)
    fun getMaps(@QueryMap options: Map<String, String>): Maps?

    @GET(RiotUri.URI_STATIC_DATA_MAPS)
    fun getMaps(callback: Callback<Maps>)

    @GET(RiotUri.URI_STATIC_DATA_MAPS)
    fun getMaps(@QueryMap options: Map<String, String>, callback: Callback<Maps>)

    /**
     * Masteries
     */
    @GET(RiotUri.URI_STATIC_DATA_MASTERIES)
    fun getMasteries(): MasteryList?

    @GET(RiotUri.URI_STATIC_DATA_MASTERIES)
    fun getMasteries(@QueryMap options: Map<String, String>): MasteryList?

    @GET(RiotUri.URI_STATIC_DATA_MASTERIES)
    fun getMasteries(callback: Callback<MasteryList>)

    @GET(RiotUri.URI_STATIC_DATA_MASTERIES)
    fun getMasteries(@QueryMap options: Map<String, String>, callback: Callback<MasteryList>)

    /**
     * Mastery
     */
    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path(RiotUri.ID) masteryId: Int): Mastery?

    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path(RiotUri.ID) masteryId: Int,@QueryMap options: Map<String, String>): Mastery?

    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path(RiotUri.ID) itemId: Int,callback: Callback<Mastery>)

    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path(RiotUri.ID) masteryId: Int,@QueryMap options: Map<String, String>, callback: Callback<Mastery>)

    /**
     * Profile Icons
     */
    @GET(RiotUri.URI_STATIC_DATA_PROFILE_ICONS)
    fun getProfileIcons(): ProfileIconData?

    @GET(RiotUri.URI_STATIC_DATA_PROFILE_ICONS)
    fun getProfileIcons(@QueryMap options: Map<String, String>): ProfileIconData?

    @GET(RiotUri.URI_STATIC_DATA_PROFILE_ICONS)
    fun getProfileIcons(callback: Callback<ProfileIconData>)

    @GET(RiotUri.URI_STATIC_DATA_PROFILE_ICONS)
    fun getProfileIcons(@QueryMap options: Map<String, String>, callback: Callback<ProfileIconData>)
}