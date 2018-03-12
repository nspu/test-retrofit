package fr.nspu.riot_api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import fr.nspu.riot_api.models.*
import fr.nspu.riot_api.services.StaticDataService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatcher
import org.mockito.Matchers.argThat
import org.mockito.Matchers.isA
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner
import retrofit.RestAdapter
import retrofit.client.Client
import retrofit.client.Request
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

/**
 * Inspired by spotify-web-api-android
 */
@RunWith(RobolectricTestRunner::class)
class RiotServiceTest {

    private var staticDataService: StaticDataService? = null
    private var mockClient: Client? = null
    private var gson: Gson? = null

    private inner class MatchesId internal constructor(private val mId: Int) : ArgumentMatcher<Request>() {

        override fun matches(request: Any): Boolean {
            try {
                return (request as Request).url.contains(URLEncoder.encode(Integer.toString(mId), "UTF-8"))
            } catch (e: UnsupportedEncodingException) {
                return false
            }

        }
    }

    @Before
    fun setUp() {
        mockClient = mock(Client::class.java)

        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint(RiotApi.RIOT_API_ENDPOINT)
                .build()

        staticDataService = restAdapter.create(StaticDataService::class.java)
        gson = GsonBuilder().create()
    }



    @Test
    @Throws(IOException::class)
    fun shouldGetChampionsData() {
        val body = TestUtils.readTestData("champions.json")
        val fixture = gson!!.fromJson(body, ChampionList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionList::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        var options : Map<String, String> = hashMapOf("tags" to  "all", "champListData" to "all")

        val champions = staticDataService!!.getChampions(options)
        this.compareJSONWithoutNulls(body, champions)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionData() {
        val body = TestUtils.readTestData("championWukong.json")
        val fixture = gson!!.fromJson(body, Champion::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Champion::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        var options : Map<String, String> = hashMapOf("tags" to  "all", "champData" to "all")

        val champion = staticDataService!!.getChampion(fixture.id!!, options)
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

        val items = staticDataService!!.getItems(options)
        this.compareJSONWithoutNulls(body, items)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetItemData() {
        val body = TestUtils.readTestData("itemWardensMail.json")
        val fixture = gson!!.fromJson(body, Item::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Item::class.java)
        `when`(mockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        var options : Map<String, String> = hashMapOf("tags" to  "all", "itemData" to "all")

        val item = staticDataService!!.getItem(fixture.id!!, options)
        this.compareJSONWithoutNulls(body, item)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguageStringsData() {
        val body = TestUtils.readTestData("language-strings.json")
        val fixture = gson!!.fromJson(body, LanguageStrings::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LanguageStrings::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val languageStrings = staticDataService!!.getLanguageString()
        this.compareJSONWithoutNulls(body, languageStrings)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguagesData() {
        val body = TestUtils.readTestData("languages.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val languages = staticDataService!!.getLanguages()
        this.compareJSONWithoutNulls(body, languages)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMapsData() {
        val body = TestUtils.readTestData("maps.json")
        val fixture = gson!!.fromJson(body, Maps::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Maps::class.java)
        `when`(mockClient!!.execute(isA(Request::class.java))).thenReturn(response)

        val maps = staticDataService!!.getMaps()
        this.compareJSONWithoutNulls(body, maps)
    }


    /**
     * Compares the mapping fixture <-> object, ignoring NULL fields
     * This is useful to prevent issues with entities such as "Image" in
     * which width and height are not always present, and they result in
     * null values in the Image object
     *
     * @param fixture The JSON to test against
     * @param model   The object to be serialized
     */
    private fun <T> compareJSONWithoutNulls(fixture: String, model: T?) {
        val parser = JsonParser()

        // Parsing fixture twice gets rid of nulls
        var fixtureJsonElement = parser.parse(fixture)
        val fixtureWithoutNulls = gson!!.toJson(fixtureJsonElement)
        fixtureJsonElement = parser.parse(fixtureWithoutNulls)

        val modelJsonElement = gson!!.toJsonTree(model)

        // We compare JsonElements from fixture
        // with the one created from model. If they're different
        // it means the model is wrong
        Assert.assertEquals(fixtureJsonElement, modelJsonElement)
    }

    /**
     * Compares two JSON strings if they contain the same data even if the order
     * of the keys differs.
     *
     * @param expected The JSON to test against
     * @param actual   The tested JSON
     * @return true if JSONs contain the same data, false otherwise.
     */
    private fun JSONsContainSameData(expected: String, actual: String): Boolean {
        val parser = JsonParser()
        val expectedJsonElement = parser.parse(expected)
        val actualJsonElement = parser.parse(actual)

        return expectedJsonElement == actualJsonElement
    }
}
