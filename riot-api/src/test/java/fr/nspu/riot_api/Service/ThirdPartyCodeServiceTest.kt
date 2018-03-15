package fr.nspu.riot_api.Service

import fr.nspu.riot_api.RiotApi
import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.riot_services.ThirdPartyCodeService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
import java.io.IOException

/**
 * Created by nspu on 13/03/18.
 */
class ThirdPartyCodeServiceTest: ServiceTest() {
    var service: ThirdPartyCodeService? = null

    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint("https://na1.api.riotgames.com")
                .build()
        service  = restAdapter.create(ThirdPartyCodeService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerByAccountIdData() {
        val body = TestUtils.readTestData("third-party-code.json")
        val fixture = gson!!.fromJson(body, String::class.java)

        val response = TestUtils.getResponseFromModel(fixture, String::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(48509080)))).thenReturn(response)

        val thirdPartyCode = service!!.getThirdPartyCodeBySummonerId(48509080)
        this.compareJSONWithoutNulls(body, thirdPartyCode)
    }
}