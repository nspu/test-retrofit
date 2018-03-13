package fr.nspu.riot_api

import fr.nspu.riot_api.models.LeagueList
import fr.nspu.riot_api.services.LeagueService
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit.RestAdapter
import java.io.IOException

/**
 * Created by nspu on 12/03/18.
 */
class LeagueServiceTest: ServiceTest() {
    var service: LeagueService? = null
    override fun implementService() {
        val restAdapter = RestAdapter.Builder()
                .setClient(mockClient!!)
                .setEndpoint(RiotApi.RIOT_API_ENDPOINT)
                .build()
        service= restAdapter.create(LeagueService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChallengerByQueueData() {
        val body = TestUtils.readTestData("challenger-queue.json")
        val fixture = gson!!.fromJson(body, LeagueList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LeagueList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(fixture.queue!!)))).thenReturn(response)

        val challengers = service!!.getChallengersByQueue(ModeQueue.RANKED_SOLO_5x5)
        this.compareJSONWithoutNulls(body, challengers)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLeagueByIdData() {
        val body = TestUtils.readTestData("league-by-id.json")
        val fixture = gson!!.fromJson(body, LeagueList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LeagueList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(fixture.leagueId!!)))).thenReturn(response)

        val league = service!!.getLeagueById("930faadc-f191-3fc0-b715-79804ef73cfc")
        this.compareJSONWithoutNulls(body, league)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMasterByQueueData() {
        val body = TestUtils.readTestData("master-league.json")
        val fixture = gson!!.fromJson(body, LeagueList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LeagueList::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(fixture.queue!!)))).thenReturn(response)

        val master = service!!.getLeagueMasterByQueue(ModeQueue.RANKED_SOLO_5x5)
        this.compareJSONWithoutNulls(body, master)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetPositionBySummonerData() {
        val body = TestUtils.readTestData("position-by-summoner.json")
        val fixture = gson!!.fromJson(body, Set::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Set::class.java)
        Mockito.`when`(mockClient!!.execute(Matchers.argThat(MatchesId(25166026L)))).thenReturn(response)

        val master = service!!.getPositionBySummoner(25166026L)
        this.compareJSONWithoutNulls(body, master)
    }

}