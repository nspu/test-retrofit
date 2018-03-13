package fr.nspu.riot_api

import fr.nspu.riot_api.models.Match
import fr.nspu.riot_api.models.MatchList
import fr.nspu.riot_api.models.MatchTimeline
import fr.nspu.riot_api.services.MatchService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
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

    @Test
    @Throws(IOException::class)
    fun shouldGetMatchListByAccountData() {
        val body = TestUtils.readTestData("match-list-by-account.json")
        val fixture = gson!!.fromJson(body, MatchList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MatchList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(211234522)))).thenReturn(response)

        val matchListByAccount = service!!.getMatchListByAccountId(211234522)
        this.compareJSONWithoutNulls(body, matchListByAccount)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRecentMatchListByAccountData() {
        val body = TestUtils.readTestData("recent-match-list-by-account.json")
        val fixture = gson!!.fromJson(body, MatchList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MatchList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(211234522)))).thenReturn(response)

        val matchListByAccount = service!!.getRecentMatchListByAccountId(211234522)
        this.compareJSONWithoutNulls(body, matchListByAccount)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetTimelineByMatchIdData() {
        val body = TestUtils.readTestData("timeline-by-match-id.json")
        val fixture = gson!!.fromJson(body, MatchTimeline::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MatchTimeline::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(211234522)))).thenReturn(response)

        val matchListByAccount = service!!.getTimelineByMatchId(211234522)
        this.compareJSONWithoutNulls(body, matchListByAccount)
    }
}