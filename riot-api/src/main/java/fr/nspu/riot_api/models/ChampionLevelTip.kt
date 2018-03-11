package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 09/03/18.
 */

data class ChampionLevelTip(var effect: List<String>? = null,
                       var label: List<String>? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.createStringArrayList(),
            source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeStringList(effect)
        writeStringList(label)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionLevelTip> = object : Parcelable.Creator<ChampionLevelTip> {
            override fun createFromParcel(source: Parcel): ChampionLevelTip = ChampionLevelTip(source)
            override fun newArray(size: Int): Array<ChampionLevelTip?> = arrayOfNulls(size)
        }
    }
}