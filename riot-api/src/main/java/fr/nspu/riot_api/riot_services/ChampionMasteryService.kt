package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.ChampionMastery
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 12/03/18.
 */
interface ChampionMasteryService{
    /**
     * ChampionData masteries by summoner
     */
    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER)
    fun getChampionMasteriesBySummoner(@Path("summonerId") summonerId: Long): List<ChampionMastery>?

    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER)
    fun getChampionMasteriesBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>): List<ChampionMastery>?

    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER)
    fun getChampionMasteriesBySummoner(@Path("summonerId") summonerId: Long, callback: Callback<List<ChampionMastery>>)

    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER)
    fun getChampionMasteriesBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>, callback: Callback<List<ChampionMastery>>)

    /**
     * ChampionData masteries by summoner by champion
     */
    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION)
    fun getChampionMasteriesBySummonerByChampion(@Path("summonerId") summonerId: Long, @Path("championId") championId: Long): ChampionMastery?

    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION)
    fun getChampionMasteriesBySummonerByChampion(@Path("summonerId") summonerId: Long, @Path("championId") championId: Long, @QueryMap options: Map<String, String>): ChampionMastery?

    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION)
    fun getChampionMasteriesBySummonerByChampion(@Path("summonerId") summonerId: Long, @Path("championId") championId: Long, callback: Callback<ChampionMastery>)

    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION)
    fun getChampionMasteriesBySummonerByChampion(@Path("summonerId") summonerId: Long, @Path("championId") championId: Long, @QueryMap options: Map<String, String>, callback: Callback<ChampionMastery>)

    /**
     * Scores by summoner
     */
    @GET(RiotUri.URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER)
    fun getScoresBySummoner(@Path("summonerId") summonerId: Long): Int?

    @GET(RiotUri.URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER)
    fun getScoresBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>): Int?

    @GET(RiotUri.URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER)
    fun getScoresBySummoner(@Path("summonerId") summonerId: Long, callback: Callback<Int>)

    @GET(RiotUri.URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER)
    fun getScoresBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>, callback: Callback<Int>)

}