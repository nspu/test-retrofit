package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchParticipant(
        var stats: MatchParticipantStats? = null,
        private var participantId: Int? = null,
        var runes: List<MatchRune>? = null,
        private var timeline: MatchParticipantTimeline? = null,
        private var teamId: Int? = null,
        private var spell2Id: Int? = null,
        private var masteries: List<MatchMastery>? = null,
        private var highestAchievedSeasonTier: String? = null,
        private var spell1Id: Int? = null,
        var championId: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<MatchParticipantStats>(MatchParticipantStats::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.createTypedArrayList(MatchRune.CREATOR),
            source.readParcelable<MatchParticipantTimeline>(MatchParticipantTimeline::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.createTypedArrayList(MatchMastery.CREATOR),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(stats, 0)
        writeValue(participantId)
        writeTypedList(runes)
        writeParcelable(timeline, 0)
        writeValue(teamId)
        writeValue(spell2Id)
        writeTypedList(masteries)
        writeString(highestAchievedSeasonTier)
        writeValue(spell1Id)
        writeValue(championId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchParticipant> = object : Parcelable.Creator<MatchParticipant> {
            override fun createFromParcel(source: Parcel): MatchParticipant = MatchParticipant(source)
            override fun newArray(size: Int): Array<MatchParticipant?> = arrayOfNulls(size)
        }
    }
}