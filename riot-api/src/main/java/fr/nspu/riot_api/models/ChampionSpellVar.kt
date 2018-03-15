package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 09/03/18.
 */

data class ChampionSpellVar(private var ranksWith: String? = null,
                            private var dyn: String? = null,
                            var link: String? = null,
                            private var coeff: List<Double>? = null,
                            var key: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            ArrayList<Double>().apply { source.readList(this, Double::class.java.classLoader) },
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(ranksWith)
        writeString(dyn)
        writeString(link)
        writeList(coeff)
        writeString(key)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionSpellVar> = object : Parcelable.Creator<ChampionSpellVar> {
            override fun createFromParcel(source: Parcel): ChampionSpellVar = ChampionSpellVar(source)
            override fun newArray(size: Int): Array<ChampionSpellVar?> = arrayOfNulls(size)
        }
    }
}
