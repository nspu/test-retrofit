package fr.nspu.riot_api.Service

import fr.nspu.riot_api.ServiceTest
import fr.nspu.riot_api.TestUtils
import fr.nspu.riot_api.riot_services.ThirdPartyCodeService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito.`when`
import retrofit2.Retrofit
import java.io.IOException

/**
 * Created by nspu on 13/03/18.
 */
class ThirdPartyCodeServiceTest: ServiceTest() {
    var service: ThirdPartyCodeService? = null

    override fun implementService() {
        val restAdapter = Retrofit.Builder()
                .client(mockClient!!)
                .baseUrl("https://na1.api.riotgames.com")
                .build()
        service  = restAdapter.create(ThirdPartyCodeService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerByAccountIdData() {
        val body = TestUtils.readTestData("third-party-code.json")
        val fixture = gson!!.fromJson(body, String::class.java)

        val response = TestUtils.getResponseFromModel(fixture, String::class.java)
        `when`(mockClient!!.newCall(Matchers.argThat(MatchesId(48509080.toString()))).execute()).thenReturn(response)

        val thirdPartyCode = service!!.getThirdPartyCodeBySummonerId(48509080).execute().body()
        this.compareJSONWithoutNulls(body, thirdPartyCode)
    }
}