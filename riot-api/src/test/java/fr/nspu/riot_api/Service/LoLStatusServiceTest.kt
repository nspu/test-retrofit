package fr.nspu.riot_api.Service

import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.models.ShardStatus
import fr.nspu.riot_api.riot_services.LoLStatusService
import okhttp3.Call
import okhttp3.Request
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException

/**
 * Created by nspu on 13/03/18.
 */
class LoLStatusServiceTest: ServiceTest(){
    var service: LoLStatusService? = null
    override fun implementService() {
        val restAdapter = Retrofit.Builder()
                .client(mockClient!!)
                .baseUrl("https://na1.api.riotgames.com")
                .build()
        service= restAdapter.create(LoLStatusService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChallengerByQueueData() {
        val body = TestUtils.readTestData("lol-status.json")
        val fixture = gson!!.fromJson(body, ShardStatus::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ShardStatus::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java))).thenReturn(response as Call)

        val challengers = service!!.getLoLStatus()
        this.compareJSONWithoutNulls(body, challengers)
    }
}