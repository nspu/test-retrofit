package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class SpectatorFeaturedGames(
        private var clientRefreshInterval: Long? = null,    //The suggested interval to wait before requesting FeaturedGames again
        private var gameList: List<SpectatorGameInfo>? = null    //The list of featured games
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Long::class.java.classLoader) as Long?,
            source.createTypedArrayList(SpectatorGameInfo.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(clientRefreshInterval)
        writeTypedList(gameList)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SpectatorFeaturedGames> = object : Parcelable.Creator<SpectatorFeaturedGames> {
            override fun createFromParcel(source: Parcel): SpectatorFeaturedGames = SpectatorFeaturedGames(source)
            override fun newArray(size: Int): Array<SpectatorFeaturedGames?> = arrayOfNulls(size)
        }
    }
}