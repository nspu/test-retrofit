package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 12/03/18.
 */
data class LeagueItem(
        var rank: String? = null,
        private var hotStreak: Boolean? = null,
        private var miniSeries: MiniSeries? = null,
        private var wins: Int? = null,
        private var veteran: Boolean? = null,
        private var losses: Int? = null,
        private var freshBlood: Boolean? = null,
        private var playerOrTeamName: String? = null,
        private var inactive: Boolean? = null,
        private var playerOrTeamId: String? = null,
        private var leaguePoints: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readParcelable<MiniSeries>(MiniSeries::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(rank)
        writeValue(hotStreak)
        writeParcelable(miniSeries, 0)
        writeValue(wins)
        writeValue(veteran)
        writeValue(losses)
        writeValue(freshBlood)
        writeString(playerOrTeamName)
        writeValue(inactive)
        writeString(playerOrTeamId)
        writeValue(leaguePoints)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LeagueItem> = object : Parcelable.Creator<LeagueItem> {
            override fun createFromParcel(source: Parcel): LeagueItem = LeagueItem(source)
            override fun newArray(size: Int): Array<LeagueItem?> = arrayOfNulls(size)
        }
    }
}