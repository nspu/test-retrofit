package fr.nspu.riot_api;

/**
 * Created by nspu on 09/03/18.
 */


import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * A convenience object converting {@link retrofit.RetrofitError}s to {@link RiotError}s
 * in the error callbacks.
 *
 * @param <T> expected response type
 * @see retrofit.Callback
 */
public abstract class RiotCallback<T> implements Callback<T> {
    public abstract void failure(RiotError error);

    @Override
    public void failure(RetrofitError error) {
        failure(RiotError.fromRetrofitError(error));
    }
}

