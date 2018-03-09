package fr.nspu.riot_api

/**
 * Created by nspu on 09/03/18.
 */


import retrofit.Callback
import retrofit.RetrofitError

/**
 * A convenience object converting [retrofit.RetrofitError]s to [RiotError]s
 * in the error callbacks.
 *
 * @param <T> expected response type
 * @see retrofit.Callback
</T> */
abstract class RiotCallback<T> : Callback<T> {
    abstract fun failure(error: RiotError)

    override fun failure(error: RetrofitError)
        = failure(RiotError.fromRetrofitError(error))

}

