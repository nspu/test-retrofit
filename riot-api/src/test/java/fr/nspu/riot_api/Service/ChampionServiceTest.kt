package fr.nspu.riot_api.Service

import fr.nspu.riot_api.RiotApi
import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.ChampionInfo
import fr.nspu.riot_api.models.ChampionListInfo
import fr.nspu.riot_api.riot_services.ChampionService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
import retrofit.client.Request
import java.io.IOException

/**
 * Created by nspu on 12/03/18.
 */
class ChampionServiceTest : ServiceTest()  {
    var service: ChampionService? = null
    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint("https://na1.api.riotgames.com")
                .build()
        service= restAdapter.create(ChampionService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionListInfo() {
        val body = TestUtils.readTestData("champion-list-info.json")
        val fixture = gson!!.fromJson(body, ChampionListInfo::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionListInfo::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val champions = service!!.getChampions()
        this.compareJSONWithoutNulls(body, champions)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionInfo() {
        val body = TestUtils.readTestData("champion-info.json")
        val fixture = gson!!.fromJson(body, ChampionInfo::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionInfo::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(fixture.id!!)))).thenReturn(response)

        val champion = service!!.getChampion(fixture.id!!)
        this.compareJSONWithoutNulls(body, champion)
    }
}