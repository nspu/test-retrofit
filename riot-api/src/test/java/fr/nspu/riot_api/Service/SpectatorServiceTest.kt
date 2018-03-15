package fr.nspu.riot_api.Service

import fr.nspu.riot_api.RiotApi
import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.SpectatorFeaturedGames
import fr.nspu.riot_api.riot_services.SpectatorService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
import retrofit.client.Request
import java.io.IOException

/**
 * Created by nspu on 13/03/18.
 */
class SpectatorServiceTest: ServiceTest() {
    var service: SpectatorService? = null

    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint("https://na1.api.riotgames.com")
                .build()
        service  = restAdapter.create(SpectatorService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionData() {
        val body = TestUtils.readTestData("featured-games.json")
        val fixture = gson!!.fromJson(body, SpectatorFeaturedGames::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SpectatorFeaturedGames::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val featuredGames = service!!.getFeaturedGame()
        this.compareJSONWithoutNulls(body, featuredGames)
    }
}