package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.*
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * lol-static-data
 */
interface StaticDataService {
    /**
     * Retrieves champion list
     *
     * @param options Optional parameters. Nullable
     * @return Requested champion list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Retrieve champion list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>? =null): ChampionListData?

    /**
     * Retrieves champion list
     *
     * @param callback Callback method. Success callback will return champion list
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Retrieve champion list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(callback: Callback<ChampionListData>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves champion by ID
     *
     * @param championId id of the champion
     * @param options Optional parameters. Nullable
     * @return Requested champion
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Retrieve champion</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path("id") championId: Int, @QueryMap options: Map<String, String>? =null): ChampionData?

    /**
     * Retrieves champion by ID
     *
     * @param championId id of the champion
     * @param callback Callback method. Success callback will return champion
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Retrieve champion</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path("id") championId: Int, callback: Callback<ChampionData>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves item list
     *
     * @param options Optional parameters. Nullable
     * @return Requested item list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Retrieve item list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_ITEMS)
    fun getItems(@QueryMap options: Map<String, String>? =null): ItemList?

    /**
     * Retrieves item list
     *
     * @param callback Callback method. Success callback will return item list
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Retrieve item list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_ITEMS)
    fun getItems(callback: Callback<ItemList>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves item by ID
     *
     * @param itemId id of the item
     * @param options Optional parameters. Nullable
     * @return Requested item
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Retrieve item</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_ITEM)
    fun getItem(@Path("id") itemId: Int, @QueryMap options: Map<String, String>? = null): Item?

    /**
     * Retrieves item by ID
     *
     * @param itemId id of the item
     * @param callback Callback method. Success callback will return item
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Retrieve item</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getItem(@Path("id") itemId: Int, callback: Callback<Item>, @QueryMap options: Map<String, String>? = null)


    /**
     * Retrieve language strings data
     *
     * @param callback Callback method. Success callback will return language strings
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Retrieve language strings</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_LANGUAGE_STRING)
    fun getLanguageString(@QueryMap options: Map<String, String>? =null): LanguageStrings?

    /**
     * Retrieve language strings data
     *
     * @param options Optional parameters. Nullable
     * @return Requested language strings
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Retrieve language strings</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_LANGUAGE_STRING)
    fun getLanguageString(callback: Callback<LanguageStrings>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieve supported languages data
     *
     * @param options Optional parameters. Nullable
     * @return Requested supported languages data
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Retrieve supported languages data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_LANGUAGES)
    fun getLanguages(@QueryMap options: Map<String, String>? =null): List<String>?

    /**
     * Retrieve supported languages data
     *
     * @param callback Callback method. Success callback will return supported languages data
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Retrieve supported languages data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_LANGUAGES)
    fun getLanguages(callback: Callback<List<String>>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieve map data
     *
     * @param options Optional parameters. Nullable
     * @return Requested supported map data
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Retrieve map data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MAPS)
    fun getMaps(@QueryMap options: Map<String, String>? =null): Maps?

    /**
     * Retrieve map data
     *
     * @param callback Callback method. Success callback will return map data
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Retrieve map data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MAPS)
    fun getMaps(callback: Callback<Maps>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves mastery list
     *
     * @param options Optional parameters. Nullable
     * @return Requested mastery list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Retrieve mastery list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MASTERIES)
    fun getMasteries(@QueryMap options: Map<String, String>? =null): MasteryList?

    /**
     * Retrieves mastery list
     *
     * @param callback Callback method. Success callback will return mastery list
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Retrieve mastery list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MASTERIES)
    fun getMasteries(callback: Callback<MasteryList>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves mastery item by ID
     *
     * @param masteryId id of the mastery
     * @param options Optional parameters. Nullable
     * @return Requested mastery item
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Retrieves mastery item</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path("id") masteryId: Int, @QueryMap options: Map<String, String>? =null): Mastery?

    /**
     * Retrieves mastery item by ID
     *
     * @param masteryId id of the mastery
     * @param callback Callback method. Success callback will return mastery item
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Retrieves mastery item</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path("id") masteryId: Int, callback: Callback<Mastery>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieve profile icons
     *
     * @param options Optional parameters. Nullable
     * @return Requested profile icons
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Retrieve profile icons</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_PROFILE_ICONS)
    fun getProfileIcons(@QueryMap options: Map<String, String>? =null): ProfileIconData?

    /**
     * Retrieve profile icons
     *
     * @param callback Callback method. Success callback will return profile icons
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Retrieve profile icons</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_PROFILE_ICONS)
    fun getProfileIcons(callback: Callback<ProfileIconData>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieve realm data
     *
     * @param options Optional parameters. Nullable
     * @return Requested realm data
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRealm">Retrieve realm data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REALMS)
    fun getRealms(@QueryMap options: Map<String, String>? =null): Realm?

    /**
     * Retrieve realm data
     *
     * @param callback Callback method. Success callback will return realm data
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRealm">Retrieve realm data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REALMS)
    fun getRealms(callback: Callback<Realm>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves reforged rune path list
     *
     * @param options Optional parameters. Nullable
     * @return Requested reforged rune path list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunePaths">Retrieves reforged rune path list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATHS)
    fun getReforgedRunePaths(@QueryMap options: Map<String, String>? =null): List<ReforgedRunePath>?

    /**
     * Retrieves reforged rune path list
     *
     * @param callback Callback method. Success callback will return reforged rune path list
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunePaths">Retrieves reforged rune path list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATHS)
    fun getReforgedRunePaths(callback: Callback<List<ReforgedRunePath>>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves reforged rune path by ID
     *
     * @param reforgedRunePathId id of the reforged rune path
     * @param options Optional parameters. Nullable
     * @return Requested reforged rune path
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunePathById">Retrieves reforged rune path</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATH)
    fun getReforgedRunePath(@Path("id") reforgedRunePathId: Int, @QueryMap options: Map<String, String>? =null): ReforgedRunePath?

    /**
     * Retrieves reforged rune path by ID
     *
     * @param reforgedRunePathId id of the reforged rune path
     * @param callback Callback method. Success callback will return reforged rune path
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunePathById">Retrieves reforged rune path</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATH)
    fun getReforgedRunePath(@Path("id") reforgedRunePathId: Int, callback: Callback<ReforgedRunePath>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves reforged rune list
     *
     * @param options Optional parameters. Nullable
     * @return Requested reforged rune list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunes">Retrieves reforged rune list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNES)
    fun getReforgedRunes(@QueryMap options: Map<String, String>? =null): List<ReforgedRune>?

    /**
     * Retrieves reforged rune list
     *
     * @param callback Callback method. Success callback will return reforged rune list
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunes">Retrieves reforged rune list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNES)
    fun getReforgedRunes(callback: Callback<List<ReforgedRune>>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves reforged rune by ID
     *
     * @param reforgedRuneId id of the reforged rune
     * @param options Optional parameters. Nullable
     * @return Requested reforged rune
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRuneById">Retrieves reforged rune by ID</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE)
    fun getReforgedRune(@Path("id") reforgedRuneId: Int, @QueryMap options: Map<String, String>? =null): ReforgedRune?

    /**
     * Retrieves reforged rune by ID
     *
     * @param reforgedRuneId id of the reforged rune
     * @param callback Callback method. Success callback will return reforged rune
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRuneById">Retrieves reforged rune by ID</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE)
    fun getReforgedRune(@Path("id") reforgedRuneId: Int, callback: Callback<ReforgedRune>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves rune list
     *
     * @param options Optional parameters. Nullable
     * @return Requested rune list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Retrieves rune list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_RUNES)
    fun getRunes(@QueryMap options: Map<String, String>? =null): RuneList?

    /**
     * Retrieves rune list
     *
     * @param callback Callback method. Success callback will return rune list
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Retrieves rune list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_RUNES)
    fun getRunes(callback: Callback<RuneList>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves rune by ID
     *
     * @param runeId id of the rune
     * @param callback Callback method. Success callback will return rune
     * @param options Optional parameters. Nullable
     * @return Requested rune
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Retrieves rune by ID</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_RUNE)
    fun getRune(@Path("id") runeId: Int, @QueryMap options: Map<String, String>? =null): Rune?

    @GET(RiotUri.URI_STATIC_DATA_RUNE)
    fun getRune(@Path("id") runeId: Int, callback: Callback<Rune>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves summoner spell list
     *
     * @param options Optional parameters. Nullable
     * @return Requested summoner spell list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Retrieves summoner spell list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELLS)
    fun getSummonerSpells(@QueryMap options: Map<String, String>? =null): SummonerSpellList?

    /**
     * Retrieves summoner spell list
     *
     * @param callback Callback method. Success callback will return summoner spell list
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Retrieves summoner spell list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELLS)
    fun getSummonerSpells(callback: Callback<SummonerSpellList>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves summoner spell by ID
     *
     * @param summonerSpellId id of the summoner spell
     * @param options Optional parameters. Nullable
     * @return Requested summoner spell
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Retrieves summoner spell by ID</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELL)
    fun getSummonerSpell(@Path("id") summonerSpellId: Int, @QueryMap options: Map<String, String>? =null): SummonerSpell?

    /**
     * Retrieves summoner spell by ID
     *
     * @param summonerSpellId id of the summoner spell
     * @param callback Callback method. Success callback will return summoner spell
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Retrieves summoner spell by ID</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELL)
    fun getSummonerSpell(@Path("id") summonerSpellId: Int, callback: Callback<SummonerSpell>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieves full tarball link
     *
     * @param options Optional parameters. Nullable
     * @return Requested full tarball link
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getFullTarballLink">Retrieves full tarball link</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_TARBALL_LINKS)
    fun getTarballLinks(@QueryMap options: Map<String, String>? =null): String?

    /**
     * Retrieves full tarball link
     *
     * @param callback Callback method. Success callback will return full tarball link
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getFullTarballLink">Retrieves full tarball link</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_TARBALL_LINKS)
    fun getTarballLinks(callback: Callback<String>, @QueryMap options: Map<String, String>? =null)

    /**
     * Retrieve version data
     *
     * @param options Optional parameters. Nullable
     * @return Requested version data
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getVersions">Retrieve version data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_VERSIONS)
    fun getVersions(@QueryMap options: Map<String, String>? =null): List<String>?

    /**
     * Retrieve version data
     *
     * @param callback Callback method. Success callback will return version data
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getVersions">Retrieve version data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_VERSIONS)
    fun getVersions(callback: Callback<List<String>>, @QueryMap options: Map<String, String>? =null)
}