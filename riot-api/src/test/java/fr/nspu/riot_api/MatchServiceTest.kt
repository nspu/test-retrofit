package fr.nspu.riot_api

import fr.nspu.riot_api.models.Match
import fr.nspu.riot_api.models.ShardStatus
import fr.nspu.riot_api.services.LoLStatusService
import fr.nspu.riot_api.services.MatchService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
import retrofit.client.Request
import java.io.IOException

/**
 * Created by nspu on 13/03/18.
 */
class MatchServiceTest:ServiceTest() {
    var service: MatchService? = null
    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint(RiotApi.RIOT_API_ENDPOINT)
                .build()
        service= restAdapter.create(MatchService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChallengerByQueueData() {
        val body = TestUtils.readTestData("match-by-id.json")
        val fixture = gson!!.fromJson(body, Match::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Match::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(fixture.gameId!!)))).thenReturn(response)

        val challengers = service!!.getMatchById(fixture.gameId!!)
        this.compareJSONWithoutNulls(body, challengers)
    }
}