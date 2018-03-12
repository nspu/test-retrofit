package fr.nspu.riot_api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import fr.nspu.riot_api.models.*
import fr.nspu.riot_api.services.StaticDataService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatcher
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.client.Client
import retrofit.client.Request
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

/**
 * Created by nspu on 12/03/18.
 */
abstract class ServiceTest {

    protected var mockClient: Client? = null
    protected var gson: Gson? = null

    protected inner class MatchesId internal constructor(private val mId: Any) : ArgumentMatcher<Request>() {

        override fun matches(request: Any): Boolean {
            try {
                return (request as Request).url.contains(URLEncoder.encode(mId.toString(), "UTF-8"))
            } catch (e: UnsupportedEncodingException) {
                return false
            }

        }
    }

    @Before
    fun setUp() {
        mockClient = Mockito.mock(Client::class.java)
        implementService()
        gson = GsonBuilder().create()
    }

    abstract fun implementService()

    /**
     * Compares the mapping fixture <-> object, ignoring NULL fields
     * This is useful to prevent issues with entities such as "Image" in
     * which width and height are not always present, and they result in
     * null values in the Image object
     *
     * @param fixture The JSON to test against
     * @param model   The object to be serialized
     */
    protected fun <T> compareJSONWithoutNulls(fixture: String, model: T?) {
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
    protected fun JSONsContainSameData(expected: String, actual: String): Boolean {
        val parser = JsonParser()
        val expectedJsonElement = parser.parse(expected)
        val actualJsonElement = parser.parse(actual)

        return expectedJsonElement == actualJsonElement
    }
}