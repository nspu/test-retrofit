package fr.nspu.riot_api.Service

import fr.nspu.riot_api.RiotApi
import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.*
import fr.nspu.riot_api.riot_services.StaticDataService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.argThat
import org.mockito.Matchers.isA
import org.mockito.Mockito.`when`
import org.robolectric.RobolectricTestRunner
import retrofit.RestAdapter
import retrofit.client.Request
import java.io.IOException

/**
 * Inspired by spotify-web-api-android
 */
@RunWith(RobolectricTestRunner::class)
class StaticDataServiceTest : ServiceTest(){

    var service: StaticDataService? = null

    override fun implementService() {
                val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint("https://na1.api.riotgames.com")
                .build()
        service  = restAdapter.create(StaticDataService::class.java)
    }


    @Test
    @Throws(IOException::class)
    fun shouldGetChampionsData() {
        val body = TestUtils.readTestData("champions.json")
        val fixture = gson!!.fromJson(body, ChampionListData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionListData::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        var options : Map<String, String> = hashMapOf("tags" to  "all", "champListData" to "all")

        val champions = service!!.getChampions(options)
        this.compareJSONWithoutNulls(body, champions)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionData() {
        val body = TestUtils.readTestData("champion-wukong.json")
        val fixture = gson!!.fromJson(body, ChampionData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionData::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        var options : Map<String, String> = hashMapOf("tags" to  "all", "champData" to "all")

        val champion = service!!.getChampion(fixture.id!!, options)
        this.compareJSONWithoutNulls(body, champion)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetItemsData() {
        val body = TestUtils.readTestData("items.json")
        val fixture = gson!!.fromJson(body, ItemList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ItemList::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        var options : Map<String, String> = hashMapOf("tags" to  "all", "itemListData" to "all")

        val items = service!!.getItems(options)
        this.compareJSONWithoutNulls(body, items)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetItemData() {
        val body = TestUtils.readTestData("item-wardens-mail.json")
        val fixture = gson!!.fromJson(body, Item::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Item::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        var options : Map<String, String> = hashMapOf("tags" to  "all", "itemData" to "all")

        val item = service!!.getItem(fixture.id!!, options)
        this.compareJSONWithoutNulls(body, item)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguageStringsData() {
        val body = TestUtils.readTestData("language-strings.json")
        val fixture = gson!!.fromJson(body, LanguageStrings::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LanguageStrings::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val languageStrings = service!!.getLanguageString()
        this.compareJSONWithoutNulls(body, languageStrings)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguagesData() {
        val body = TestUtils.readTestData("languages.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val languages = service!!.getLanguages()
        this.compareJSONWithoutNulls(body, languages)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMapsData() {
        val body = TestUtils.readTestData("maps.json")
        val fixture = gson!!.fromJson(body, Maps::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Maps::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val maps = service!!.getMaps()
        this.compareJSONWithoutNulls(body, maps)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMasteriesData() {
        val body = TestUtils.readTestData("masteries.json")
        val fixture = gson!!.fromJson(body, MasteryList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MasteryList::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        var options: Map<String, String> = hashMapOf("tags" to "all", "masteryListData" to "all")
        val masteries = service!!.getMasteries(options)
        this.compareJSONWithoutNulls(body, masteries)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMasteryData() {
        val body = TestUtils.readTestData("mastery.json")
        val fixture = gson!!.fromJson(body, Mastery::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Mastery::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        var options: Map<String, String> = hashMapOf("tags" to "all", "masteryData" to "all")
        val mastery = service!!.getMastery(fixture.id!!, options)
        this.compareJSONWithoutNulls(body, mastery)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetProfileIconsData() {
        val body = TestUtils.readTestData("profile-icons.json")
        val fixture = gson!!.fromJson(body, ProfileIconData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ProfileIconData::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val profileIconData = service!!.getProfileIcons()
        this.compareJSONWithoutNulls(body, profileIconData)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRealmsData() {
        val body = TestUtils.readTestData("realms.json")
        val fixture = gson!!.fromJson(body, Realm::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Realm::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val realm = service!!.getRealms()
        this.compareJSONWithoutNulls(body, realm)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetReforgedRunePathsData() {
        val body = TestUtils.readTestData("reforged-rune-paths.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val reforgedRunePaths = service!!.getReforgedRunePaths()
        this.compareJSONWithoutNulls(body, reforgedRunePaths)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetReforgedRunePathData() {
        val body = TestUtils.readTestData("reforged-rune-path.json")
        val fixture = gson!!.fromJson(body, ReforgedRunePath::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ReforgedRunePath::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        val reforgedRunePath = service!!.getReforgedRunePath(fixture.id!!)
        this.compareJSONWithoutNulls(body, reforgedRunePath)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetReforgedRunesData() {
        val body = TestUtils.readTestData("reforged-runes.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val reforgedRunes = service!!.getReforgedRunes()
        this.compareJSONWithoutNulls(body, reforgedRunes)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetReforgedRuneData() {
        val body = TestUtils.readTestData("reforged-rune.json")
        val fixture = gson!!.fromJson(body, ReforgedRune::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ReforgedRune::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        val reforgedRune = service!!.getReforgedRune(fixture.id!!)
        this.compareJSONWithoutNulls(body, reforgedRune)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRunesData() {
        val body = TestUtils.readTestData("runes.json")
        val fixture = gson!!.fromJson(body, RuneList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, RuneList::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        var options: Map<String, String> = hashMapOf("tags" to "all", "runeListData" to "all")

        val runes = service!!.getRunes(options)
        this.compareJSONWithoutNulls(body, runes)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRuneData() {
        val body = TestUtils.readTestData("rune.json")
        val fixture = gson!!.fromJson(body, Rune::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Rune::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        var options: Map<String, String> = hashMapOf("tags" to "all", "runeData" to "all")

        val rune = service!!.getRune(fixture.id!!, options)
        this.compareJSONWithoutNulls(body, rune)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerSpellsData() {
        val body = TestUtils.readTestData("summoner-spells.json")
        val fixture = gson!!.fromJson(body, SummonerSpellList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SummonerSpellList::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        var options: Map<String, String> = hashMapOf("tags" to "all", "spellListData" to "all")

        val summonerSpells = service!!.getSummonerSpells(options)
        this.compareJSONWithoutNulls(body, summonerSpells)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerSpellData() {
        val body = TestUtils.readTestData("summoner-spell.json")
        val fixture = gson!!.fromJson(body, SummonerSpell::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SummonerSpell::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        var options: Map<String, String> = hashMapOf("tags" to "all", "spellData" to "all")

        val rune = service!!.getSummonerSpell(fixture.id!!, options)
        this.compareJSONWithoutNulls(body, rune)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetTabarballLinksData() {
        val body = TestUtils.readTestData("tarball-links.json")
        val fixture = gson!!.fromJson(body, String::class.java)

        val response = TestUtils.getResponseFromModel(fixture, String::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val tarballLinks = service!!.getTarballLinks()
        this.compareJSONWithoutNulls(body, tarballLinks)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetVersionsData() {
        val body = TestUtils.readTestData("versions.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val versions = service!!.getVersions()
        this.compareJSONWithoutNulls(body, versions)
    }
}
