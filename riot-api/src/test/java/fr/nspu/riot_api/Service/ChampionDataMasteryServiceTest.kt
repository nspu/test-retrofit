package fr.nspu.riot_api.Service

import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.ChampionMastery
import fr.nspu.riot_api.riot_services.ChampionMasteryService
import okhttp3.Call
import okhttp3.Request
import org.junit.Test
import org.mockito.ArgumentMatcher
import org.mockito.Matchers
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import retrofit2.Retrofit
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import okhttp3.mockwebserver.MockResponse



/**
 * Created by nspu on 12/03/18.
 */
class ChampionDataMasteryServiceTest : ServiceTest() {
    private val SUMMONER_ID = 48509080L

    var service: ChampionMasteryService? = null

    override fun implementService() {
        val restAdapter = Retrofit.Builder()
                .client(mockClient!!)
                .baseUrl("https://na1.api.riotgames.com")
                .build()
        service = restAdapter.create(ChampionMasteryService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionMasteriesBySummonerData() {
        val body = TestUtils.readTestData("champion-masteries-summoner.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(SUMMONER_ID.toString()))).execute()).thenReturn(response)


        val championMastery = service!!.getChampionMasteriesBySummoner(SUMMONER_ID)!!.execute().body()
        this.compareJSONWithoutNulls(body, championMastery)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionMasteriesBySummonerByChampionData() {
        val body = TestUtils.readTestData("champion-masteries-summoner-champion.json")
        val fixture = gson!!.fromJson(body, ChampionMastery::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionMastery::class.java)
        `when`(mockClient!!.newCall(Matchers.argThat((object : ArgumentMatcher<Request>() {
            override fun matches(argument: Any): Boolean {
                try {
                    return (argument as Request).url().encodedPath().contains("by-summoner/" + URLEncoder.encode(fixture.playerId.toString(), "UTF-8"))
                            && argument.url().encodedPath().contains("by-champion/" + URLEncoder.encode(fixture.championId.toString(), "UTF-8"))
                } catch (e: UnsupportedEncodingException) {
                    return false
                }

            }
        }))).execute()).thenReturn(response)

        val championMastery = service!!.getChampionMasteriesBySummonerByChampion(fixture.playerId!!, fixture.championId!!)
        this.compareJSONWithoutNulls(body, championMastery)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetScoresBySummonerData() {
        val body = TestUtils.readTestData("scores-by-summoner.json")
        val fixture = gson!!.fromJson(body, Int::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Int::class.java)
        `when`(mockClient!!.newCall(Matchers.argThat(MatchesId(SUMMONER_ID.toString()))).execute()).thenReturn(response)

        val scores = service!!.getScoresBySummoner(SUMMONER_ID)
        this.compareJSONWithoutNulls(body, scores)
    }

}