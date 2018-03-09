package fr.nspu.riot_api;

/**
 * Created by nspu on 09/03/18.
 */

import fr.nspu.riot_api.models.ErrorDetails;
import fr.nspu.riot_api.models.ErrorResponse;
import retrofit.RetrofitError;

/**
 * This object wraps error responses from the API
 * and provides access to details returned by the request that are usually more
 * descriptive than default Retrofit error messages.
 * <p>
 * To use with asynchronous requests pass {@link RiotCallback}
 * instead of {@link retrofit.Callback} when making the request:
 */
public class RiotError extends Exception {

    private final RetrofitError mRetrofitError;
    private final ErrorDetails mErrorDetails;

    public static RiotError fromRetrofitError(RetrofitError error) {
        ErrorResponse errorResponse = null;

        try {
            errorResponse = (ErrorResponse) error.getBodyAs(ErrorResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (errorResponse != null && errorResponse.error != null) {
            String message = errorResponse.error.status + " " + errorResponse.error.message;
            return new RiotError(error, errorResponse.error, message);
        } else {
            return new RiotError(error);
        }
    }

    public RiotError(RetrofitError retrofitError, ErrorDetails errorDetails, String message) {
        super(message, retrofitError);
        mRetrofitError = retrofitError;
        mErrorDetails = errorDetails;
    }

    public RiotError(RetrofitError retrofitError) {
        super(retrofitError);
        mRetrofitError = retrofitError;
        mErrorDetails = null;
    }

    /**
     * @return the original {@link retrofit.RetrofitError} that was returned for this request.
     */
    public RetrofitError getRetrofitError() {
        return mRetrofitError;
    }

    /**
     * @return true if there are {@link ErrorDetails}
     * associated with this error. False otherwise.
     */
    public boolean hasErrorDetails() {
        return mErrorDetails != null;
    }

    /**
     * @return Details returned from the API associated with this error if present.
     */
    public ErrorDetails getErrorDetails() {
        return mErrorDetails;
    }
}
