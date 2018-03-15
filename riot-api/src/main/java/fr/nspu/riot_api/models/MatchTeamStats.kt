package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchTeamStats(
        private var firstDragon: Boolean? = null,
        private var firstInhibitor: Boolean? = null,
        private var bans: List<MatchTeamBans>? = null,
        private var baronKills: Int? = null,
        private var firstRiftHerald: Boolean? = null,
        private var firstBaron: Boolean? = null,
        private var riftHeraldKills: Int? = null,
        private var firstBlood: Boolean? = null,
        private var teamId: Int? = null,
        private var firstTower: Boolean? = null,
        private var vilemawKills: Int? = null,
        private var inhibitorKills: Int? = null,
        private var towerKills: Int? = null,
        private var dominionVictoryScore: Int? = null,
        private var win: String? = null,
        private var dragonKills: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.createTypedArrayList(MatchTeamBans.CREATOR),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(firstDragon)
        writeValue(firstInhibitor)
        writeTypedList(bans)
        writeValue(baronKills)
        writeValue(firstRiftHerald)
        writeValue(firstBaron)
        writeValue(riftHeraldKills)
        writeValue(firstBlood)
        writeValue(teamId)
        writeValue(firstTower)
        writeValue(vilemawKills)
        writeValue(inhibitorKills)
        writeValue(towerKills)
        writeValue(dominionVictoryScore)
        writeString(win)
        writeValue(dragonKills)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchTeamStats> = object : Parcelable.Creator<MatchTeamStats> {
            override fun createFromParcel(source: Parcel): MatchTeamStats = MatchTeamStats(source)
            override fun newArray(size: Int): Array<MatchTeamStats?> = arrayOfNulls(size)
        }
    }
}