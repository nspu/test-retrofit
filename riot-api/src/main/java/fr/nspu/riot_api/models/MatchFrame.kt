package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchFrame(
        private var timestamp: Long? = null,
        private var participantFrames: Map<Int, MatchParticipantFrame>? = null,
        private var events: List<MatchEvent>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Long::class.java.classLoader) as Long?,
            mapOf<Int, MatchParticipantFrame>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.createTypedArrayList(MatchEvent.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(timestamp)
        writeMap(participantFrames)
        writeTypedList(events)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchFrame> = object : Parcelable.Creator<MatchFrame> {
            override fun createFromParcel(source: Parcel): MatchFrame = MatchFrame(source)
            override fun newArray(size: Int): Array<MatchFrame?> = arrayOfNulls(size)
        }
    }
}