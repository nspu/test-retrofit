package fr.nspu.riot_api

import fr.nspu.riot_api.models.ChampionList
import fr.nspu.riot_api.models.ChampionMastery
import fr.nspu.riot_api.services.ChampionMasteryService
import fr.nspu.riot_api.services.StaticDataService
import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatcher
import org.mockito.Matchers
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import retrofit.RestAdapter
import retrofit.client.Request
import retrofit.client.Response
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

/**
 * Created by nspu on 12/03/18.
 */
class ChampionMasteryServiceTest : ServiceTest() {
    val SUMMONER_ID = 48509080L

    var service: ChampionMasteryService? = null

    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint(RiotApi.RIOT_API_ENDPOINT)
                .build()
        service = restAdapter.create(ChampionMasteryService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionMasteriesBySummonerData() {
        val body = TestUtils.readTestData("champion-masteries-summoner.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(SUMMONER_ID)))).thenReturn(response)

        val championMastery = service!!.getChampionMasteriesBySummoner(SUMMONER_ID)
        this.compareJSONWithoutNulls(body, championMastery)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionMasteriesBySummonerByChampionData() {
        val body = TestUtils.readTestData("champion-masteries-summoner-champion.json")
        val fixture = gson!!.fromJson(body, ChampionMastery::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionMastery::class.java)
        `when`<Response>(mockClient!!.execute(Matchers.argThat((object : ArgumentMatcher<Request>() {
            override fun matches(argument: Any): Boolean {
                try {
                    return (argument as Request).url.contains("by-summoner/" + URLEncoder.encode(fixture.playerId.toString(), "UTF-8"))
                            && argument.url.contains("by-champion/" + URLEncoder.encode(fixture.championId.toString(), "UTF-8"))
                } catch (e: UnsupportedEncodingException) {
                    return false
                }

            }
        })))).thenReturn(response)

        val championMastery = service!!.getChampionMasteriesBySummonerByChampion(fixture.playerId!!, fixture.championId!!)
        this.compareJSONWithoutNulls(body, championMastery)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetScoresBySummonerData() {
        val body = TestUtils.readTestData("scores-by-summoner.json")
        val fixture = gson!!.fromJson(body, Int::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Int::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(SUMMONER_ID)))).thenReturn(response)

        val scores = service!!.getScoresBySummoner(SUMMONER_ID)
        this.compareJSONWithoutNulls(body, scores)
    }

}