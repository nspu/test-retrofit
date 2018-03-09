package fr.nspu.riot_api

/**
 * Created by nspu on 09/03/18.
 */

import fr.nspu.riot_api.models.ErrorDetails
import fr.nspu.riot_api.models.ErrorResponse
import retrofit.RetrofitError

/**
 * This object wraps error responses from the API
 * and provides access to details returned by the request that are usually more
 * descriptive than default Retrofit error messages.
 *
 *
 * To use with asynchronous requests pass [RiotCallback]
 * instead of [retrofit.Callback] when making the request:
 */
class RiotError : Exception {

    val retrofitError: RetrofitError
    val errorDetails: ErrorDetails?

    constructor(retrofitError: RetrofitError, errorDetails: ErrorDetails?, message: String):super(message, retrofitError){
        this.retrofitError = retrofitError
        this.errorDetails = errorDetails
    }

    constructor(retrofitError: RetrofitError) : super(retrofitError){
        this.retrofitError = retrofitError
        this.errorDetails = null
    }

    /**
     * @return true if there are [ErrorDetails]
     * associated with this error. False otherwise.
     */
    fun hasErrorDetails(): Boolean = errorDetails != null


    companion object {

        fun fromRetrofitError(error: RetrofitError): RiotError {
            var errorResponse: ErrorResponse? = null

            try {
                errorResponse = error.getBodyAs(ErrorResponse::class.java) as ErrorResponse
            } catch (e: Exception) {
                e.printStackTrace()
            }

            if (errorResponse!!.error != null) {
                val message = errorResponse.error.status.toString() + " " + errorResponse.error.message
                return RiotError(error, errorResponse.error, message)
            } else {
                return RiotError(error)
            }
        }
    }
}
