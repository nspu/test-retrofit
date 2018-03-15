package fr.nspu.riot_api.services

import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 13/03/18.
 */
interface ThirdPartyCodeService {
    /**
     * Third party code by Summoner Id
     */
    @GET(RiotUri.URI_THIRD_PARTY_CODE_BY_SUMMONER_ID)
    fun getThirdPartyCodeBySummonerId(@Path("summonerId") summonerId: Long): String?

    @GET(RiotUri.URI_THIRD_PARTY_CODE_BY_SUMMONER_ID)
    fun getThirdPartyCodeBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>): String?

    @GET(RiotUri.URI_THIRD_PARTY_CODE_BY_SUMMONER_ID)
    fun getThirdPartyCodeBySummonerId(@Path("summonerId") summonerId: Long, callback: Callback<String>)

    @GET(RiotUri.URI_THIRD_PARTY_CODE_BY_SUMMONER_ID)
    fun getThirdPartyCodeBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>, callback: Callback<String>)

}