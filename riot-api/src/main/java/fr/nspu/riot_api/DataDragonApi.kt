package fr.nspu.riot_api

import android.content.Context
import android.content.SyncRequest
import android.util.Log
import com.jakewharton.retrofit.Ok3Client
import fr.nspu.riot_api.data_dragon_services.DataDragonService
import fr.nspu.riot_api.data_dragon_services.ImageService
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit.RequestInterceptor
import retrofit.RestAdapter
import retrofit.android.MainThreadExecutor
import java.io.IOException
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by nspu on 15/03/18.
 *
 * If no context, no cache
 */
class DataDragonApi(
        httpExecutor: Executor,
        callbackExecutor: Executor,
        var version: String,
        var language: String,
        var context: Context? = null
) {
    val dataDragonService: DataDragonService
    val imageService: ImageService

    init {



        val restAdapterBuilder = RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(DATA_DRAGON_API_ENDPOINT)


        if (context != null) {
            useCache(restAdapterBuilder)
        }else{
            restAdapterBuilder.setRequestInterceptor{ request ->
                requestAddParameter(request)
            }
        }

        val restAdapter = restAdapterBuilder.build()

        dataDragonService = restAdapter.create(DataDragonService::class.java)
        imageService = ImageService(DATA_DRAGON_API_ENDPOINT, version)
    }

    fun requestAddParameter(request: RequestInterceptor.RequestFacade) {
        request.addPathParam("version", version)
        request.addPathParam("language", language)
    }


    constructor(version: String, language: String, context: Context?) : this(
            Executors.newSingleThreadExecutor(),
            MainThreadExecutor(),
            version,
            language,
            context

    )

    private fun useCache(buildRestAdapter: RestAdapter.Builder) {
        var okHttpClient: OkHttpClient? = null

        try {
            var cacheSize: Long = 10 * 1024 * 1024  // 10 Mb
            var cache = Cache(context!!.externalCacheDir, cacheSize);
            okHttpClient = OkHttpClient.Builder().cache(cache).build()

        } catch (e: IOException) {
            Log.e(TAG, "Could not set cache", e);
        }

        val cacheInterceptor = RequestInterceptor {
            request -> request.addHeader("Cache-Control", "max-stale=" + Integer.MAX_VALUE)
            requestAddParameter(request)
        }

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