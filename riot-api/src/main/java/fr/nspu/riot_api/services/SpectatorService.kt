package fr.nspu.riot_api.services

import fr.nspu.riot_api.models.SpectatorFeaturedGames
import fr.nspu.riot_api.models.SpectatorGameInfo
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 13/03/18.
 */
interface SpectatorService {
    /**
     * Active game by summonerId
     */
    @GET(RiotUri.URI_SPECTATOR_ACTIVE_GAMES_BY_SUMMONER_ID)
    fun getActiveGameBySummonerId(@Path("summonerId") summonerId: Long): SpectatorGameInfo?

    @GET(RiotUri.URI_SPECTATOR_ACTIVE_GAMES_BY_SUMMONER_ID)
    fun getActiveGameBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>): SpectatorGameInfo?

    @GET(RiotUri.URI_SPECTATOR_ACTIVE_GAMES_BY_SUMMONER_ID)
    fun getActiveGameBySummonerId(@Path("summonerId") summonerId: Long, callback: Callback<SpectatorGameInfo>)

    @GET(RiotUri.URI_SPECTATOR_ACTIVE_GAMES_BY_SUMMONER_ID)
    fun getActiveGameBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>, callback: Callback<SpectatorGameInfo>)


    /**
     * Featured Game
     */
    @GET(RiotUri.URI_SPECTATOR_FEATURED_GAME)
    fun getFeaturedGame(): SpectatorFeaturedGames?

    @GET(RiotUri.URI_SPECTATOR_FEATURED_GAME)
    fun getFeaturedGame(@QueryMap options: Map<String, String>): SpectatorFeaturedGames?

    @GET(RiotUri.URI_SPECTATOR_FEATURED_GAME)
    fun getFeaturedGame(callback: Callback<SpectatorFeaturedGames>)

    @GET(RiotUri.URI_SPECTATOR_FEATURED_GAME)
    fun getFeaturedGame(@QueryMap options: Map<String, String>, callback: Callback<SpectatorFeaturedGames>)
}