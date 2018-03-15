package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchPlayer(
        private var currentPlatformId: String? = null,
        private var summonerName: String? = null,
        private var matchHistoryUri: String? = null,
        private var platformId: String? = null,
        private var currentAccountId: Long? = null,
        private var profileIcon: Int? = null,
        var summonerId: Long? = null,
        private var accountId: Long? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(currentPlatformId)
        writeString(summonerName)
        writeString(matchHistoryUri)
        writeString(platformId)
        writeValue(currentAccountId)
        writeValue(profileIcon)
        writeValue(summonerId)
        writeValue(accountId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchPlayer> = object : Parcelable.Creator<MatchPlayer> {
            override fun createFromParcel(source: Parcel): MatchPlayer = MatchPlayer(source)
            override fun newArray(size: Int): Array<MatchPlayer?> = arrayOfNulls(size)
        }
    }
}