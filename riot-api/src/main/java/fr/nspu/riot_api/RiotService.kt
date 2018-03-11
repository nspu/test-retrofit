package fr.nspu.riot_api

import fr.nspu.riot_api.models.Champion
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.QueryMap

/**
 * Created by nspu on 09/03/18.
 */

interface RiotService {
    @GET("/lol/static-data/v3/champions/{id}")
    fun getChampion(@Path("id") championId: Int) : Champion?

    @GET("/lol/static-data/v3/champions/{id}")
    fun getChampion(@Path("id") championId: Int, @QueryMap options: Map<String, String>) : Champion?

    @GET("/lol/static-data/v3/champions/{id}")
    fun getChampion(@Path("id") championId: Int, callback: Callback<Champion>)

    @GET("/lol/static-data/v3/champions/{id}")
    fun getChampion(@Path("id") championId: Int, @QueryMap options: Map<String, String>, callback: Callback<Champion>)
}
