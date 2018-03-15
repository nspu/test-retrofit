package fr.nspu.riot_api.riot_services

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
    fun getChampions(): ChampionListData?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>): ChampionListData?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(callback: Callback<ChampionListData>)

    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>, callback: Callback<ChampionListData>)

    /**
     * ChampionData
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path("id") championId: Int): ChampionData?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path("id") championId: Int, @QueryMap options: Map<String, String>): ChampionData?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path("id") championId: Int, callback: Callback<ChampionData>)

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path("id") championId: Int, @QueryMap options: Map<String, String>, callback: Callback<ChampionData>)

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
    fun getItem(@Path("id") itemId: Int): Item?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getItem(@Path("id") itemId: Int, @QueryMap options: Map<String, String>): Item?

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getItem(@Path("id") itemId: Int, callback: Callback<Item>)

    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getItem(@Path("id") itemId: Int, @QueryMap options: Map<String, String>, callback: Callback<Item>)


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
    fun getMastery(@Path("id") masteryId: Int): Mastery?

    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path("id") masteryId: Int,@QueryMap options: Map<String, String>): Mastery?

    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path("id") itemId: Int,callback: Callback<Mastery>)

    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path("id") masteryId: Int,@QueryMap options: Map<String, String>, callback: Callback<Mastery>)

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

    /**
     * Realm
     */
    @GET(RiotUri.URI_STATIC_DATA_REALMS)
    fun getRealms(): Realm?

    @GET(RiotUri.URI_STATIC_DATA_REALMS)
    fun getRealms(@QueryMap options: Map<String, String>): Realm?

    @GET(RiotUri.URI_STATIC_DATA_REALMS)
    fun getRealms(callback: Callback<Realm>)

    @GET(RiotUri.URI_STATIC_DATA_REALMS)
    fun getRealms(@QueryMap options: Map<String, String>, callback: Callback<Realm>)

    /**
     * Reforged Rune Paths
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATHS)
    fun getReforgedRunePaths(): List<ReforgedRunePath>?

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATHS)
    fun getReforgedRunePaths(@QueryMap options: Map<String, String>): List<ReforgedRunePath>?

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATHS)
    fun getReforgedRunePaths(callback: Callback<List<ReforgedRunePath>>)

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATHS)
    fun getReforgedRunePaths(@QueryMap options: Map<String, String>, callback: Callback<List<ReforgedRunePath>>)

    /**
     * Reforged Rune Path
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATH)
    fun getReforgedRunePath(@Path("id") reforgedRunePathId: Int): ReforgedRunePath?

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATH)
    fun getReforgedRunePath(@Path("id") reforgedRunePathId: Int,@QueryMap options: Map<String, String>): ReforgedRunePath?

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATH)
    fun getReforgedRunePath(@Path("id") reforgedRunePathId: Int,callback: Callback<ReforgedRunePath>)

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATH)
    fun getReforgedRunePath(@Path("id") reforgedRunePathId: Int,@QueryMap options: Map<String, String>, callback: Callback<ReforgedRunePath>)

    /**
     * Reforged Runes
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNES)
    fun getReforgedRunes(): List<ReforgedRune>?

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNES)
    fun getReforgedRunes(@QueryMap options: Map<String, String>): List<ReforgedRune>?

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNES)
    fun getReforgedRunes(callback: Callback<List<ReforgedRune>>)

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNES)
    fun getReforgedRunes(@QueryMap options: Map<String, String>, callback: Callback<List<ReforgedRune>>)

    /**
     * Reforged Rune Path
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE)
    fun getReforgedRune(@Path("id") reforgedRuneId: Int): ReforgedRune?

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE)
    fun getReforgedRune(@Path("id") reforgedRuneId: Int,@QueryMap options: Map<String, String>): ReforgedRune?

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE)
    fun getReforgedRune(@Path("id") reforgedRuneId: Int,callback: Callback<ReforgedRune>)

    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE)
    fun getReforgedRune(@Path("id") reforgedRuneId: Int,@QueryMap options: Map<String, String>, callback: Callback<ReforgedRune>)

    /**
     * Runes
     */
    @GET(RiotUri.URI_STATIC_DATA_RUNES)
    fun getRunes(): RuneList?

    @GET(RiotUri.URI_STATIC_DATA_RUNES)
    fun getRunes(@QueryMap options: Map<String, String>): RuneList?

    @GET(RiotUri.URI_STATIC_DATA_RUNES)
    fun getRunes(callback: Callback<RuneList>)

    @GET(RiotUri.URI_STATIC_DATA_RUNES)
    fun getRunes(@QueryMap options: Map<String, String>, callback: Callback<RuneList>)

    /**
     * Rune
     */
    @GET(RiotUri.URI_STATIC_DATA_RUNE)
    fun getRune(@Path("id") RuneId: Int): Rune?

    @GET(RiotUri.URI_STATIC_DATA_RUNE)
    fun getRune(@Path("id") RuneId: Int,@QueryMap options: Map<String, String>): Rune?

    @GET(RiotUri.URI_STATIC_DATA_RUNE)
    fun getRune(@Path("id") RuneId: Int,callback: Callback<Rune>)

    @GET(RiotUri.URI_STATIC_DATA_RUNE)
    fun getRune(@Path("id") RuneId: Int,@QueryMap options: Map<String, String>, callback: Callback<Rune>)

    /**
     * SummonerSpells
     */
    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELLS)
    fun getSummonerSpells(): SummonerSpellList?

    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELLS)
    fun getSummonerSpells(@QueryMap options: Map<String, String>): SummonerSpellList?

    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELLS)
    fun getSummonerSpells(callback: Callback<SummonerSpellList>)

    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELLS)
    fun getSummonerSpells(@QueryMap options: Map<String, String>, callback: Callback<SummonerSpellList>)

    /**
     * Rune
     */
    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELL)
    fun getSummonerSpell(@Path("id") summonerSpellId: Int): SummonerSpell?

    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELL)
    fun getSummonerSpell(@Path("id") summonerSpellId: Int,@QueryMap options: Map<String, String>): SummonerSpell?

    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELL)
    fun getSummonerSpell(@Path("id") summonerSpellId: Int,callback: Callback<SummonerSpell>)

    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELL)
    fun getSummonerSpell(@Path("id") summonerSpellId: Int,@QueryMap options: Map<String, String>, callback: Callback<SummonerSpell>)

    /**
     * Tarball links
     */
    @GET(RiotUri.URI_STATIC_DATA_TARBALL_LINKS)
    fun getTarballLinks(): String?

    @GET(RiotUri.URI_STATIC_DATA_TARBALL_LINKS)
    fun getTarballLinks(@QueryMap options: Map<String, String>): String?

    @GET(RiotUri.URI_STATIC_DATA_TARBALL_LINKS)
    fun getTarballLinks(callback: Callback<String>)

    @GET(RiotUri.URI_STATIC_DATA_TARBALL_LINKS)
    fun getTarballLinks(@QueryMap options: Map<String, String>, callback: Callback<String>)

    /**
     * Versions
     */
    @GET(RiotUri.URI_STATIC_DATA_VERSIONS)
    fun getVersions(): List<String>?

    @GET(RiotUri.URI_STATIC_DATA_VERSIONS)
    fun getVersions(@QueryMap options: Map<String, String>): List<String>?

    @GET(RiotUri.URI_STATIC_DATA_VERSIONS)
    fun getVersions(callback: Callback<List<String>>)

    @GET(RiotUri.URI_STATIC_DATA_VERSIONS)
    fun getVersions(@QueryMap options: Map<String, String>, callback: Callback<List<String>>)




}