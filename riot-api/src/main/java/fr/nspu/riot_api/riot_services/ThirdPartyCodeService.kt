package fr.nspu.riot_api.riot_services

import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 13/03/18.
 */
interface ThirdPartyCodeService {
    /**
     * Get third party code for a given summoner ID
     *
     * @param summonerId id of the summoner
     * @param callback Callback method. Success callback will return third party code
     * @param options Optional parameters. Nullable
     * @return Requested third party code
     * @see <a href="https://developer.riotgames.com/api-methods/#third-party-code-v3/GET_getThirdPartyCodeBySummonerId">Get third party code for a given summoner ID</a>
     */
    @GET(RiotUri.URI_THIRD_PARTY_CODE_BY_SUMMONER_ID)
    fun getThirdPartyCodeBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? =null): String?

    @GET(RiotUri.URI_THIRD_PARTY_CODE_BY_SUMMONER_ID)
    fun getThirdPartyCodeBySummonerId(@Path("summonerId") summonerId: Long, callback: Callback<String>, @QueryMap options: Map<String, String>? =null)
}