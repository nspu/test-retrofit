package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class SpectatorCurrentGameParticipant(
        private var profileIconId: Long? = null,// 	The ID of the profile icon used by this participant
        var championId: Long? = null,// 	The ID of the champion played by this participant
        private var summonerName: String? = null,// 	The summoner name of this participant
        private var gameCustomizationObjects: List<SpectatorGameCustomization>? = null,// 	List of Game Customizations
        private var bot: Boolean? = null,// 	Flag indicating whether or not this participant is a bot
        private var perks: SpectatorPerks? = null,// 	Perks/Runes Reforged Information
        private var spell2Id: Long? = null,// 	The ID of the second summoner spell used by this participant
        private var teamId: Long? = null,// 	The team ID of this participant, indicating the participant's team
        private var spell1Id: Long? = null,// 	The ID of the first summoner spell used by this participant
        var summonerId: Long? = null// 	The summoner ID of this participant
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readString(),
            source.createTypedArrayList(SpectatorGameCustomization.CREATOR),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readParcelable<SpectatorPerks>(SpectatorPerks::class.java.classLoader),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(profileIconId)
        writeValue(championId)
        writeString(summonerName)
        writeTypedList(gameCustomizationObjects)
        writeValue(bot)
        writeParcelable(perks, 0)
        writeValue(spell2Id)
        writeValue(teamId)
        writeValue(spell1Id)
        writeValue(summonerId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SpectatorCurrentGameParticipant> = object : Parcelable.Creator<SpectatorCurrentGameParticipant> {
            override fun createFromParcel(source: Parcel): SpectatorCurrentGameParticipant = SpectatorCurrentGameParticipant(source)
            override fun newArray(size: Int): Array<SpectatorCurrentGameParticipant?> = arrayOfNulls(size)
        }
    }
}