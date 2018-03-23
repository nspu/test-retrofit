package fr.nspu.riot_api.Service

import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.Summoner
import fr.nspu.riot_api.riot_services.SummonerService
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException



/**
 * Created by nspu on 13/03/18.
 */
class SummonerServiceTest: ServiceTest() {
    var service: SummonerService? = null
    var mockWebServer:MockWebServer?=null
    override fun implementService() {
        val restAdapter = Retrofit.Builder()
                .client(mockClient!!)
                .baseUrl("https://na1.api.riotgames.com")
                .build()

        mockWebServer = MockWebServer()

        val retrofit = Retrofit.Builder()
                .baseUrl(mockWebServer!!.url("").toString())
                .build()

        service  = retrofit.create(SummonerService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerByAccountIdData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(fixture.accountId!!.toString()))).execute()).thenReturn( response)

        mockWebServer!!.enqueue(MockResponse().setBody(body))
        val summoner = service!!.getSummonerByAccountId(fixture.accountId!!)
        this.compareJSONWithoutNulls(body, summoner!!.execute().body())
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerBySummonerNameData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(fixture.name!!))).execute()).thenReturn( response)

        val summoner = service!!.getSummonerByName(fixture.name!!)
        this.compareJSONWithoutNulls(body, summoner)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerBySummonerIdData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn( response)

        val summoner = service!!.getSummonerBySummonerId(fixture.id!!)
        this.compareJSONWithoutNulls(body, summoner)
    }
}