package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchParticipantFrame(
        private var totalGold: Int? = null,
        private var teamScore: Int? = null,
        private var participantId: Int? = null,
        var level: Int? = null,
        private var currentGold: Int? = null,
        private var minionsKilled: Int? = null,
        private var dominionScore: Int? = null,
        private var position: MatchPosition? = null,
        private var xp: Int? = null,
        private var jungleMinionsKilled: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readParcelable<MatchPosition>(MatchPosition::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(totalGold)
        writeValue(teamScore)
        writeValue(participantId)
        writeValue(level)
        writeValue(currentGold)
        writeValue(minionsKilled)
        writeValue(dominionScore)
        writeParcelable(position, 0)
        writeValue(xp)
        writeValue(jungleMinionsKilled)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchParticipantFrame> = object : Parcelable.Creator<MatchParticipantFrame> {
            override fun createFromParcel(source: Parcel): MatchParticipantFrame = MatchParticipantFrame(source)
            override fun newArray(size: Int): Array<MatchParticipantFrame?> = arrayOfNulls(size)
        }
    }
}