package fr.nspu.riot_api.Service

import fr.nspu.riot_api.RiotApi
import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.ShardStatus
import fr.nspu.riot_api.services.LoLStatusService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
import retrofit.client.Request
import java.io.IOException

/**
 * Created by nspu on 13/03/18.
 */
class LoLStatusServiceTest: ServiceTest(){
    var service: LoLStatusService? = null
    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint(RiotApi.RIOT_API_ENDPOINT)
                .build()
        service= restAdapter.create(LoLStatusService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChallengerByQueueData() {
        val body = TestUtils.readTestData("lol-status.json")
        val fixture = gson!!.fromJson(body, ShardStatus::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ShardStatus::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.isA(Request::class.java))).thenReturn(response)

        val challengers = service!!.getLoLStatus()
        this.compareJSONWithoutNulls(body, challengers)
    }
}