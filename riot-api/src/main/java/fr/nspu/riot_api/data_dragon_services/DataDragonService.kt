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
    fun getProfileIcon(): ProfileIconData?

    @GET(DataDragonUri.URI_PROFILE_ICON)
    fun getProfileIcon(callback: Callback<ProfileIconData>)

    /**
     * Champions
     */
    @GET(DataDragonUri.URI_CHAMPIONS)
    fun getChampions(): ChampionListData?

    @GET(DataDragonUri.URI_CHAMPIONS)
    fun getChampions(callback: Callback<ChampionListData>)


    /**
     * Champion
     */
    @GET(DataDragonUri.URI_CHAMPION)
    fun getChampion(@Path("championName") championName: String): ChampionListData?

    @GET(DataDragonUri.URI_CHAMPION)
    fun getChampion(@Path("championName") championName: String, callback: Callback<ChampionListData>)

    /**
     * Items
     */
    @GET(DataDragonUri.URI_ITEMS)
    fun getItems(): ItemList?

    @GET(DataDragonUri.URI_ITEMS)
    fun getItems(callback: Callback<ItemList>)

    /**
     * Masteries
     */
    @GET(DataDragonUri.URI_MASTERIES)
    fun getMasteries(): MasteryList?

    @GET("/masteries_{version}_{language}.json")
    fun getMasteries(callback: Callback<MasteryList>)


    /**
     * Runes
     */
    @GET(DataDragonUri.URI_RUNES)
    fun getRunes(): RuneList?

    @GET(DataDragonUri.URI_RUNES)
    fun getRunes(callback: Callback<RuneList>)


    /**
     * Summoner Spells
     */
    @GET(DataDragonUri.URI_SUMMONER_SPELLS)
    fun getSummonerSpells(): SummonerSpellList?

    @GET(DataDragonUri.URI_SUMMONER_SPELLS)
    fun getSummonerSpells(callback: Callback<SummonerSpellList>)


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
    fun getLanguageString(): LanguageStrings

    @GET(DataDragonUri.URI_LANGUAGE_STRINGS)
    fun getLanguageString(callback: Callback<LanguageStrings>)

}