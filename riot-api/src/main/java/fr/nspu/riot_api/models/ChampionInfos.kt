package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 09/03/18.
 */
data class ChampionInfos(
         var difficulty: Int? = null,
        var attack: Int? = null,
        var defense: Int? = null,
        var magic: Int? = null
        ) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(difficulty)
        parcel.writeValue(attack)
        parcel.writeValue(defense)
        parcel.writeValue(magic)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChampionInfos> {
        override fun createFromParcel(parcel: Parcel): ChampionInfos {
            return ChampionInfos(parcel)
        }

        override fun newArray(size: Int): Array<ChampionInfos?> {
            return arrayOfNulls(size)
        }
    }

}