package fr.nspu.riot_api

import android.content.Context
import android.util.Log
import com.jakewharton.retrofit.Ok3Client
import fr.nspu.riot_api.data_dragon_services.DataDragonService
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit.RestAdapter
import java.io.IOException
import java.util.concurrent.Executor
import retrofit.RequestInterceptor
import retrofit.android.MainThreadExecutor
import java.util.concurrent.Executors

/**
 * Created by nspu on 15/03/18.
 *
 * If no context, no cache
 */
class DataDragonApi(httpExecutor: Executor, callbackExecutor: Executor, var context: Context? = null) {
    val dataDragonService: DataDragonService

    init {

        val restAdapterBuilder = RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(DATA_DRAGON_API_ENDPOINT);

        if (context != null) {
            useCache(restAdapterBuilder)
        }

        val restAdapter = restAdapterBuilder.build()

        dataDragonService = restAdapter.create(DataDragonService::class.java)
    }

    constructor(context: Context?) : this(
            Executors.newSingleThreadExecutor(),
            MainThreadExecutor(), context

    )

    private fun useCache(buildRestAdapter: RestAdapter.Builder) {
        var okHttpClient: OkHttpClient? = null

        try {
            var cacheSize: Long = 10 * 1024 * 1024  // 10 MiB
            var cache = Cache(context!!.externalCacheDir, cacheSize);
            okHttpClient = OkHttpClient.Builder().cache(cache).build()

        } catch (e: IOException) {
            Log.e(TAG, "Could not set cache", e);
        }

        // Forces cache. Used for cache connection
        val cacheInterceptor = RequestInterceptor { request -> request.addHeader("Cache-Control", "max-stale=" + Integer.MAX_VALUE) }

        buildRestAdapter.setClient(Ok3Client(okHttpClient))
                .setRequestInterceptor(cacheInterceptor)
    }


    companion object {

        const val TAG = "DataDragonApi"

        /**
         * Data dragon endpoint
         */
        const val DATA_DRAGON_API_ENDPOINT = "https://ddragon.leagueoflegends.com"
    }
}