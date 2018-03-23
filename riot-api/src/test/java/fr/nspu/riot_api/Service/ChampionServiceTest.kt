package fr.nspu.riot_api.Service

import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.ChampionInfo
import fr.nspu.riot_api.models.ChampionListInfo
import fr.nspu.riot_api.riot_services.ChampionService
import okhttp3.Request
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException

/**
 * Created by nspu on 12/03/18.
 */
class ChampionServiceTest : ServiceTest()  {
    var service: ChampionService? = null
    override fun implementService() {
        val restAdapter = Retrofit.Builder()
                .client(mockClient!!)
                .baseUrl("https://na1.api.riotgames.com")
                .build()
        service= restAdapter.create(ChampionService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionListInfo() {
        val body = TestUtils.readTestData("champion-list-info.json")
        val fixture = gson!!.fromJson(body, ChampionListInfo::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionListInfo::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response )

        val champions = service!!.getChampions()
        this.compareJSONWithoutNulls(body, champions)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionInfo() {
        val body = TestUtils.readTestData("champion-info.json")
        val fixture = gson!!.fromJson(body, ChampionInfo::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionInfo::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn(response)

        val champion = service!!.getChampion(fixture.id!!)
        this.compareJSONWithoutNulls(body, champion)
    }
}