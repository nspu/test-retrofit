package fr.nspu.riot_api.Service

import fr.nspu.riot_api.DataDragonApi
import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.data_dragon_services.DataDragonService
import fr.nspu.riot_api.models.*
import okhttp3.Call
import okhttp3.Request
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException

/**
 * Created by nspu on 15/03/18.
 */
class DataDragonServiceTest: ServiceTest(){
    var service: DataDragonService? = null
    override fun implementService() {
        val restAdapter = Retrofit.Builder()
                .client(mockClient!!)
                .baseUrl(DataDragonApi.DATA_DRAGON_API_ENDPOINT)
                .build()
        service= restAdapter.create(DataDragonService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetProfileIconData() {
        val body = TestUtils.readTestData("profile-icons.json")
        val fixture = gson!!.fromJson(body, ProfileIconData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ProfileIconData::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val profileIconData = service!!.getProfileIcon()
        this.compareJSONWithoutNulls(body, profileIconData)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionsData() {
        val body = TestUtils.readTestData("champions.json")
        val fixture = gson!!.fromJson(body, ChampionListData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionListData::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val championListData = service!!.getChampions()
        this.compareJSONWithoutNulls(body, championListData)
    }

    //Disable because the Riot Data dragon api is not update
//    @Test
//    @Throws(IOException::class)
//    fun shouldGetChampionData() {
//        val body = TestUtils.readTestData("champion-data-dragon.json")
//        val fixture = gson!!.fromJson(body, ChampionListData::class.java)
//
//        val response = TestUtils.getResponseFromModel(fixture, ChampionListData::class.java)
//        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn( response as Call)
//
//        val championData = service!!.getChampion("","","")
//        this.compareJSONWithoutNulls(body, championData)
//    }

    @Test
    @Throws(IOException::class)
    fun shouldGetItemsData() {
        val body = TestUtils.readTestData("items.json")
        val fixture = gson!!.fromJson(body, ItemList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ItemList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val items = service!!.getItems()
        this.compareJSONWithoutNulls(body, items)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMasteriesData() {
        val body = TestUtils.readTestData("masteries.json")
        val fixture = gson!!.fromJson(body, MasteryList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MasteryList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val masteries = service!!.getMasteries()
        this.compareJSONWithoutNulls(body, masteries)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRunesData() {
        val body = TestUtils.readTestData("runes.json")
        val fixture = gson!!.fromJson(body, RuneList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, RuneList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val runes = service!!.getRunes()
        this.compareJSONWithoutNulls(body, runes)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerSpellsData() {
        val body = TestUtils.readTestData("summoner-spells.json")
        val fixture = gson!!.fromJson(body, SummonerSpellList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SummonerSpellList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val summonerSpells = service!!.getSummonerSpells()
        this.compareJSONWithoutNulls(body, summonerSpells)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetVersionsData() {
        val body = TestUtils.readTestData("versions.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val versions = service!!.getVersions()
        this.compareJSONWithoutNulls(body, versions)
    }



    @Test
    @Throws(IOException::class)
    fun shouldGetLanguagesData() {
        val body = TestUtils.readTestData("languages.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val languages = service!!.getLanguages()
        this.compareJSONWithoutNulls(body, languages)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguageStringsData() {
        val body = TestUtils.readTestData("language-strings.json")
        val fixture = gson!!.fromJson(body, LanguageStrings::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LanguageStrings::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn( response as Call)

        val languageStrings = service!!.getLanguageString()
        this.compareJSONWithoutNulls(body, languageStrings)
    }

}