package fr.nspu.riot_api.Service

import fr.nspu.riot_api.DataDragonApi
import fr.nspu.riot_api.ModeQueue
import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.data_dragon_services.DataDragonService
import fr.nspu.riot_api.models.*
import fr.nspu.riot_api.riot_services.LeagueService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
import retrofit.client.Request
import java.io.IOException

/**
 * Created by nspu on 15/03/18.
 */
class DataDragonServiceTest: ServiceTest(){
    var service: DataDragonService? = null
    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint(DataDragonApi.DATA_DRAGON_API_ENDPOINT)
                .build()
        service= restAdapter.create(DataDragonService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetProfileIconData() {
        val body = TestUtils.readTestData("profile-icons.json")
        val fixture = gson!!.fromJson(body, ProfileIconData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ProfileIconData::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val profileIconData = service!!.getProfileIcon("", "")
        this.compareJSONWithoutNulls(body, profileIconData)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionsData() {
        val body = TestUtils.readTestData("champions.json")
        val fixture = gson!!.fromJson(body, ChampionListData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionListData::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val championListData = service!!.getChampions("", "")
        this.compareJSONWithoutNulls(body, championListData)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionData() {
        val body = TestUtils.readTestData("champion-wukong.json")
        val fixture = gson!!.fromJson(body, ChampionData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionData::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val championData = service!!.getChampion("","","")
        this.compareJSONWithoutNulls(body, championData)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetItemsData() {
        val body = TestUtils.readTestData("items.json")
        val fixture = gson!!.fromJson(body, ItemList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ItemList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val items = service!!.getItems("","")
        this.compareJSONWithoutNulls(body, items)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMasteriesData() {
        val body = TestUtils.readTestData("masteries.json")
        val fixture = gson!!.fromJson(body, MasteryList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MasteryList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val masteries = service!!.getMasteries("","")
        this.compareJSONWithoutNulls(body, masteries)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRunesData() {
        val body = TestUtils.readTestData("runes.json")
        val fixture = gson!!.fromJson(body, RuneList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, RuneList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val runes = service!!.getRunes("","")
        this.compareJSONWithoutNulls(body, runes)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerSpellsData() {
        val body = TestUtils.readTestData("summoner-spells.json")
        val fixture = gson!!.fromJson(body, SummonerSpellList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SummonerSpellList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val summonerSpells = service!!.getSummonerSpells("","")
        this.compareJSONWithoutNulls(body, summonerSpells)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetVersionsData() {
        val body = TestUtils.readTestData("versions.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val versions = service!!.getVersions()
        this.compareJSONWithoutNulls(body, versions)
    }



    @Test
    @Throws(IOException::class)
    fun shouldGetLanguagesData() {
        val body = TestUtils.readTestData("languages.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val languages = service!!.getLanguages()
        this.compareJSONWithoutNulls(body, languages)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguageStringsData() {
        val body = TestUtils.readTestData("language-strings.json")
        val fixture = gson!!.fromJson(body, LanguageStrings::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LanguageStrings::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val languageStrings = service!!.getLanguageString("", "")
        this.compareJSONWithoutNulls(body, languageStrings)
    }

}