package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
class Match(
        private var seasonId: Int? = null,
        private var queueId: Int? = null,
        var gameId: Long? = null,
        private var participantIdentities: List<MatchParticipantIdentity>? = null,
        private var gameVersion: String? = null,
        private var platformId: String? = null,
        private var gameMode: String? = null,
        private var mapId: Int? = null,
        private var gameType: String? = null,
        private var teams: List<MatchTeamStats>? = null,
        private var participants: List<MatchParticipant>? = null,
        private var gameDuration: Long? = null,
        private var gameCreation: Long? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.createTypedArrayList(MatchParticipantIdentity.CREATOR),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.createTypedArrayList(MatchTeamStats.CREATOR),
            source.createTypedArrayList(MatchParticipant.CREATOR),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(seasonId)
        writeValue(queueId)
        writeValue(gameId)
        writeTypedList(participantIdentities)
        writeString(gameVersion)
        writeString(platformId)
        writeString(gameMode)
        writeValue(mapId)
        writeString(gameType)
        writeTypedList(teams)
        writeTypedList(participants)
        writeValue(gameDuration)
        writeValue(gameCreation)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Match> = object : Parcelable.Creator<Match> {
            override fun createFromParcel(source: Parcel): Match = Match(source)
            override fun newArray(size: Int): Array<Match?> = arrayOfNulls(size)
        }
    }
}