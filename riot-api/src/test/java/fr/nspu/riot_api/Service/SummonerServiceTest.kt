package fr.nspu.riot_api.Service

import fr.nspu.riot_api.RiotApi
import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.Summoner
import fr.nspu.riot_api.services.SummonerService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
import java.io.IOException

/**
 * Created by nspu on 13/03/18.
 */
class SummonerServiceTest: ServiceTest() {
    var service: SummonerService? = null

    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint(RiotApi.RIOT_API_ENDPOINT)
                .build()
        service  = restAdapter.create(SummonerService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerByAccountIdData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(fixture.accountId!!)))).thenReturn(response)

        val summoner = service!!.getSummonerByAccountId(fixture.accountId!!)
        this.compareJSONWithoutNulls(body, summoner)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerBySummonerNameData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(fixture.name!!)))).thenReturn(response)

        val summoner = service!!.getSummonerByName(fixture.name!!)
        this.compareJSONWithoutNulls(body, summoner)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerBySummonerIdData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        val summoner = service!!.getSummonerBySummonerId(fixture.id!!)
        this.compareJSONWithoutNulls(body, summoner)
    }
}