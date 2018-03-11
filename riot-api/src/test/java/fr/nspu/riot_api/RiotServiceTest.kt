package fr.nspu.riot_api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import fr.nspu.riot_api.models.Champion
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatcher
import org.mockito.Matchers.argThat
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner
import retrofit.RestAdapter
import retrofit.client.Client
import retrofit.client.Request
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

@RunWith(RobolectricTestRunner::class)
class RiotServiceTest {

    private var mRiotService: RiotService? = null
    private var mMockClient: Client? = null
    private var mGson: Gson? = null

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
        mMockClient = mock(Client::class.java)

        val restAdapter = RestAdapter.Builder()
                .setClient(mMockClient!!)
                .setEndpoint(RiotApi.RIOT_API_ENDPOINT)
                .build()

        mRiotService = restAdapter.create(RiotService::class.java)
        mGson = GsonBuilder().create()
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionData() {
        val body = TestUtils.readTestData("championWukong.json")
        val fixture = mGson!!.fromJson(body, Champion::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Champion::class.java)
        `when`(mMockClient!!.execute(argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        var options : Map<String, String> = hashMapOf("tags" to  "all", "champData" to "all")

        val champion = mRiotService!!.getChampion(fixture.id!!, options)
        this.compareJSONWithoutNulls(body, champion)
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
        val fixtureWithoutNulls = mGson!!.toJson(fixtureJsonElement)
        fixtureJsonElement = parser.parse(fixtureWithoutNulls)

        val modelJsonElement = mGson!!.toJsonTree(model)

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
