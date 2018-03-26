package fr.nspu.riot_api.data_dragon_services

import fr.nspu.riot_api.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface DataDragonService {

    /**
     * Profile Icons:
     */
    @GET(DataDragonUri.URI_PROFILE_ICON)
    fun getProfileIcon(): Call<ProfileIconData>?

    /**
     * Champions
     */
    @GET(DataDragonUri.URI_CHAMPIONS)
    fun getChampions(): Call<ChampionListData>?

    /**
     * Champion
     */
    @GET(DataDragonUri.URI_CHAMPION)
    fun getChampion(@Path("championName") championName: String): Call<ChampionListData>?


    /**
     * Items
     */
    @GET(DataDragonUri.URI_ITEMS)
    fun getItems(): Call<ItemList>?

    /**
     * Masteries
     */
    @GET(DataDragonUri.URI_MASTERIES)
    fun getMasteries(): Call<MasteryList>?


    /**
     * Runes
     */
    @GET(DataDragonUri.URI_RUNES)
    fun getRunes(): Call<RuneList>?


    /**
     * Summoner Spells
     */
    @GET(DataDragonUri.URI_SUMMONER_SPELLS)
    fun getSummonerSpells(): Call<SummonerSpellList>?

    /**
     * Version
     */
    @GET(DataDragonUri.URI_VERSIONS)
    fun getVersions(): Call<List<String>>?

    /**
     * Language
     */
    @GET(DataDragonUri.URI_LANGUAGES)
    fun getLanguages(): Call<List<String>>?

    /**
     * Language Strings
     */
    @GET(DataDragonUri.URI_LANGUAGE_STRINGS)
    fun getLanguageString(): Call<LanguageStrings>

}