package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchTeamBans(
        private var pickTurn: Int? = null,
        var championId: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(pickTurn)
        writeValue(championId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchTeamBans> = object : Parcelable.Creator<MatchTeamBans> {
            override fun createFromParcel(source: Parcel): MatchTeamBans = MatchTeamBans(source)
            override fun newArray(size: Int): Array<MatchTeamBans?> = arrayOfNulls(size)
        }
    }
}