package fr.nspu.riot_api.riot_services

import fr.nspu.riot_api.models.SpectatorFeaturedGames
import fr.nspu.riot_api.models.SpectatorGameInfo
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * spectator
 */
interface SpectatorService {
    /**
     * Get current game information for the given summoner ID.
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return Requested the current game
     * @see <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Get the current game</a>
     */
    @GET(RiotUri.URI_SPECTATOR_ACTIVE_GAMES_BY_SUMMONER_ID)
    fun getActiveGameBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? =null): SpectatorGameInfo?

    /**
     * Get current game information for the given summoner ID.
     *
     * @param summonerId id of the summoner
     * @param callback Callback method. Success callback will return the current game
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Get the current game</a>
     */
    @GET(RiotUri.URI_SPECTATOR_ACTIVE_GAMES_BY_SUMMONER_ID)
    fun getActiveGameBySummonerId(@Path("summonerId") summonerId: Long, callback: Callback<SpectatorGameInfo>, @QueryMap options: Map<String, String>? =null)


    /**
     * Get list of featured games
     *
     * @param options Optional parameters. Nullable
     * @return Requested list of featured games
     * @see <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Get list of featured games</a>
     */
    @GET(RiotUri.URI_SPECTATOR_FEATURED_GAME)
    fun getFeaturedGame(@QueryMap options: Map<String, String>? =null): SpectatorFeaturedGames?

    /**
     * Get list of featured games
     *
     * @param callback Callback method. Success callback will return list of featured games
     * @param options Optional parameters. Nullable
     * @see <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Get list of featured games</a>
     */
    @GET(RiotUri.URI_SPECTATOR_FEATURED_GAME)
    fun getFeaturedGame(callback: Callback<SpectatorFeaturedGames>, @QueryMap options: Map<String, String>? =null)
}