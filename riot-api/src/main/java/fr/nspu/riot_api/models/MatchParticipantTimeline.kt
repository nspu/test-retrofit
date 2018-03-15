package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchParticipantTimeline(
        var lane: String? = null,
        private var participantId: Int? = null,
        private var csDiffPerMinDeltas: Map<String, Double>? = null,
        private var goldPerMinDeltas: Map<String, Double>? = null,
        private var xpDiffPerMinDeltas: Map<String, Double>? = null,
        private var creepsPerMinDeltas: Map<String, Double>? = null,
        private var xpPerMinDeltas: Map<String, Double>? = null,
        private var role: String? = null,
        private var damageTakenDiffPerMinDeltas: Map<String, Double>? = null,
        private var damageTakenPerMinDeltas: Map<String, Double>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.readString(),
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(lane)
        writeValue(participantId)
        writeMap(csDiffPerMinDeltas)
        writeMap(goldPerMinDeltas)
        writeMap(xpDiffPerMinDeltas)
        writeMap(creepsPerMinDeltas)
        writeMap(xpPerMinDeltas)
        writeString(role)
        writeMap(damageTakenDiffPerMinDeltas)
        writeMap(damageTakenPerMinDeltas)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchParticipantTimeline> = object : Parcelable.Creator<MatchParticipantTimeline> {
            override fun createFromParcel(source: Parcel): MatchParticipantTimeline = MatchParticipantTimeline(source)
            override fun newArray(size: Int): Array<MatchParticipantTimeline?> = arrayOfNulls(size)
        }
    }
}