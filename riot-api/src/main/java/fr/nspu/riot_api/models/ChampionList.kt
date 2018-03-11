package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable
import java.util.HashMap

/**
 * Created by nspu on 11/03/18.
 */
data class ChampionList(
        var keys: Map<String, String>? = null,
        var data: Map<String, Champion>? = null,
        var version: String? = null,
        var type: String? = null,
        var format: String? = null) : Parcelable {


    constructor(parcel: Parcel) : this(
            hashMapOf<String, String>().apply { parcel.readMap(this, Map::class.java.classLoader) },
            hashMapOf<String, Champion>().apply { parcel.readMap(this, Map::class.java.classLoader) },
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeMap(keys)
        parcel.writeMap(data)
        parcel.writeString(version)
        parcel.writeString(type)
        parcel.writeString(format)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChampionList> {
        override fun createFromParcel(parcel: Parcel): ChampionList = ChampionList(parcel)
        override fun newArray(size: Int): Array<ChampionList?> = arrayOfNulls(size)
    }

}