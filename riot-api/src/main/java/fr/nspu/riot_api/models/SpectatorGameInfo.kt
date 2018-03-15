package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class SpectatorGameInfo(
        private var gameId: Long? = null,// 	The ID of the game
        private var gameStartTime: Long? = null,// 	The game start time represented in epoch milliseconds
        private var platformId: String? = null,// 	The ID of the platform on which the game is being played
        private var gameMode: String? = null,// 	The game mode
        private var mapId: Long? = null,// 	The ID of the map
        private var gameType: String? = null,// 	The game type
        private var bannedChampions: List<SpectatorBannedChampion>? = null,// 	Banned champion information
        private var observers: SpectatorObserver? = null,// 	The observer information
        private var participants: List<SpectatorCurrentGameParticipant>? = null,// 	The participant information
        private var gameLength: Long? = null,// 	The amount of time in seconds that has passed since the game started
        private var gameQueueConfigId: Long? = null// 	The queue type (queue types are documented on the Game Constants page)
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readString(),
            source.readString(),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readString(),
            source.createTypedArrayList(SpectatorBannedChampion.CREATOR),
            source.readParcelable<SpectatorObserver>(SpectatorObserver::class.java.classLoader),
            source.createTypedArrayList(SpectatorCurrentGameParticipant.CREATOR),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(gameId)
        writeValue(gameStartTime)
        writeString(platformId)
        writeString(gameMode)
        writeValue(mapId)
        writeString(gameType)
        writeTypedList(bannedChampions)
        writeParcelable(observers, 0)
        writeTypedList(participants)
        writeValue(gameLength)
        writeValue(gameQueueConfigId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SpectatorGameInfo> = object : Parcelable.Creator<SpectatorGameInfo> {
            override fun createFromParcel(source: Parcel): SpectatorGameInfo = SpectatorGameInfo(source)
            override fun newArray(size: Int): Array<SpectatorGameInfo?> = arrayOfNulls(size)
        }
    }
}