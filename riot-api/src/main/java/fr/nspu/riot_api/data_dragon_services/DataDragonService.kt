package fr.nspu.riot_api.data_dragon_services

import fr.nspu.riot_api.models.*
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path

/**
 * Created by nspu on 15/03/18.
 */
interface DataDragonService {

    /**
     * Profile Icons:
     */
    @GET(DataDragonUri.URI_PROFILE_ICON)
    fun getProfileIcon(@Path("version") version:String, @Path("language") language: String): ProfileIconData?

    @GET(DataDragonUri.URI_PROFILE_ICON)
    fun getProfileIcon(@Path("version") version:String, @Path("language") language: String, callback: Callback<ProfileIconData>)

    /**
     * Champions
     */
    @GET(DataDragonUri.URI_CHAMPIONS)
    fun getChampions(@Path("version") version:String, @Path("language") language: String): ChampionListData?

    @GET(DataDragonUri.URI_CHAMPIONS)
    fun getChampions(@Path("version") version:String, @Path("language") language: String,callback: Callback<ChampionListData>)


    /**
     * Champion
     */
    @GET(DataDragonUri.URI_CHAMPION)
    fun getChampion(@Path("championName") championName:String,@Path("version") version:String, @Path("language") language: String): ChampionData?

    @GET(DataDragonUri.URI_CHAMPION)
    fun getChampion(@Path("championName") championName:String,@Path("version") version:String, @Path("language") language: String,callback: Callback<ChampionData>)

    /**
     * Items
     */
    @GET(DataDragonUri.URI_ITEMS)
    fun getItems(@Path("version") version:String, @Path("language") language: String): ItemList?

    @GET(DataDragonUri.URI_ITEMS)
    fun getItems(@Path("version") version:String, @Path("language") language: String,callback: Callback<ItemList>)

    /**
     * Masteries
     */
    @GET(DataDragonUri.URI_MASTERIES)
    fun getMasteries(@Path("version") version:String, @Path("language") language: String): MasteryList?

    @GET("/masteries_{version}_{language}.json")
    fun getMasteries(@Path("version") version:String, @Path("language") language: String,callback: Callback<MasteryList>)


    /**
     * Runes
     */
    @GET(DataDragonUri.URI_RUNES)
    fun getRunes(@Path("version") version:String, @Path("language") language: String): RuneList?

    @GET(DataDragonUri.URI_RUNES)
    fun getRunes(@Path("version") version:String, @Path("language") language: String,callback: Callback<RuneList>)



    /**
     * Summoner Spells
     */
    @GET(DataDragonUri.URI_SUMMONER_SPELLS)
    fun getSummonerSpells(@Path("version") version:String, @Path("language") language: String): SummonerSpellList?

    @GET(DataDragonUri.URI_SUMMONER_SPELLS)
    fun getSummonerSpells(@Path("version") version:String, @Path("language") language: String,callback: Callback<SummonerSpellList>)


    /**
     * Version
     */
    @GET(DataDragonUri.URI_VERSIONS)
    fun getVersions(): List<String>?

    @GET(DataDragonUri.URI_VERSIONS)
    fun getVersions(callback: Callback<List<String>>)

    /**
     * Language
     */
    @GET(DataDragonUri.URI_LANGUAGES)
    fun getLanguages(): List<String>?

    @GET(DataDragonUri.URI_LANGUAGES)
    fun getLanguages(callback: Callback<List<String>>)

    /**
     * Language Strings
     */
    @GET(DataDragonUri.URI_LANGUAGE_STRINGS)
    fun getLanguageString(@Path("version") version:String, @Path("language") language: String): LanguageStrings

    @GET(DataDragonUri.URI_LANGUAGE_STRINGS)
    fun getLanguageString(@Path("version") version:String, @Path("language") language: String, callback: Callback<LanguageStrings>)

}