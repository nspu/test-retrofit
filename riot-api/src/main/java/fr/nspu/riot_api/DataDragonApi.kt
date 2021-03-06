package fr.nspu.riot_api

import android.content.Context
import android.util.Log
import fr.nspu.riot_api.data_dragon_services.DataDragonService
import fr.nspu.riot_api.data_dragon_services.ImageService
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.Executor
import java.util.concurrent.Executors


/**
 * Creates and configures a REST adapter for DataDragon.
 *
 * Basic usage:
 * DataDragonApi dataDragonApi = new DataDragonApi(endPoint, accessToken);
 *
 * Create instance of DataDragonApi with given executors.
 *   @property httpExecutor executor for http request. Cannot be null.
 *   @property callbackExecutor executor for callbacks. If null is passed than the same
 *   @property version version of the data dragon
 *   @property language language use for get the different informations
 *   @property context context of application.If context is null, the cache will be not use
 *
 *   @property dataDragonService instance for access to data dragon
 *   @property imageService instance for access to image
 *   @constructor thread that created the instances.
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
        val restAdapterBuilder = Retrofit.Builder()
                .baseUrl(DATA_DRAGON_API_ENDPOINT)
                .callbackExecutor(callbackExecutor)
                .callbackExecutor(httpExecutor)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

        val okhttpClient = OkHttpClient.Builder()
        setupClient(okhttpClient)
        restAdapterBuilder.client(okhttpClient.build())

        dataDragonService = restAdapterBuilder.build().create(DataDragonService::class.java)
        imageService = ImageService(DATA_DRAGON_API_ENDPOINT, version, context!!)
    }


    /**
     *   @param version version of the data dragon
     *   @param language language use for get the different informations
     *   @param context context of application.If context is null, the cache will be not use
     *   @constructor thread that created the instances.
     */
    constructor(version: String, language: String, context: Context?) : this(
            Executors.newSingleThreadExecutor(),
            Executors.newSingleThreadExecutor(),
            version,
            language,
            context)

    /**
     * Set up the client
     */
    private fun setupClient(okHttpClient: OkHttpClient.Builder) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient.addInterceptor(logging)

        if (context != null) {
            try {
                var cacheSize: Long = 10 * 1024 * 1024  // 10 Mb
                var cache = Cache(context!!.externalCacheDir, cacheSize);
                okHttpClient.cache(cache)

            } catch (e: IOException) {
                Log.e(TAG, "Could not set cache", e);
            }
            okHttpClient.addNetworkInterceptor(AddHeaderCacheInterceptor())
        }

        okHttpClient.addNetworkInterceptor(AddHeaderQueryParamInterceptor())
    }

    /**
     * The request interceptor that will add the header with the maximal time for the cache.
     */
    inner class AddHeaderCacheInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder = chain.request().newBuilder()
            builder.addHeader("Cache-Control", "public, max-stale=2419200")
            return chain.proceed(builder.build())
        }
    }

    /**
     * The request interceptor that will add the header with the version and the language.
     */
    inner class AddHeaderQueryParamInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder = chain.request().newBuilder()
            val url = chain.request().url().newBuilder()
            val segments = chain.request().url().pathSegments()

            for (i in 0 until segments.size) {
                if ("{version}".equals(segments[i])) {
                    url.setPathSegment(i, version)
                }
                if ("{language}".equals(segments[i])) {
                    url.setPathSegment(i, language)
                }
            }
            builder.url(url.build())
            return chain.proceed(builder.build())
        }
    }


    companion object {
        const val TAG = "DataDragonApi"

        /** Data dragon endpoint */
        const val DATA_DRAGON_API_ENDPOINT = "https://ddragon.leagueoflegends.com"
    }
}