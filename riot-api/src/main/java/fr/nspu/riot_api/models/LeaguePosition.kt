package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 12/03/18.
 */
data class LeaguePosition(
        var rank: String? = null,
        private var queueType: String? = null,
        private var hotStreak: Boolean? = null,
        private var miniSeries: MiniSeries? = null,
        private var wins: Int? = null,
        private var veteran: Boolean? = null,
        private var losses: Int? = null,
        private var freshBlood: Boolean? = null,
        private var leagueId: String? = null,
        private var playerOrTeamName: String? = null,
        private var inactive: Boolean? = null,
        private var playerOrTeamId: String? = null,
        private var leagueName: String? = null,
        private var tier: String? = null,
        private var leaguePoints: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readParcelable<MiniSeries>(MiniSeries::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(rank)
        writeString(queueType)
        writeValue(hotStreak)
        writeParcelable(miniSeries, 0)
        writeValue(wins)
        writeValue(veteran)
        writeValue(losses)
        writeValue(freshBlood)
        writeString(leagueId)
        writeString(playerOrTeamName)
        writeValue(inactive)
        writeString(playerOrTeamId)
        writeString(leagueName)
        writeString(tier)
        writeValue(leaguePoints)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LeaguePosition> = object : Parcelable.Creator<LeaguePosition> {
            override fun createFromParcel(source: Parcel): LeaguePosition = LeaguePosition(source)
            override fun newArray(size: Int): Array<LeaguePosition?> = arrayOfNulls(size)
        }
    }
}