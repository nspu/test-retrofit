package fr.nspu.riot_api

import fr.nspu.riot_api.models.ChampionData
import fr.nspu.riot_api.models.SpectatorFeaturedGames
import fr.nspu.riot_api.models.SpectatorGameInfo
import fr.nspu.riot_api.services.SpectatorService
import fr.nspu.riot_api.services.StaticDataService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import org.mockito.internal.matchers.Matches
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
                .setEndpoint(RiotApi.RIOT_API_ENDPOINT)
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