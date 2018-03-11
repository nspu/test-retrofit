package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 09/03/18.
 */
data class ChampionPassive(
        var image: Image? = null,
        var sanitizedDescription: String? = null,
        var name: String? = null,
        var description: String? = null
) : Parcelable {

    constructor(source: Parcel) : this(
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(image, 0)
        writeString(sanitizedDescription)
        writeString(name)
        writeString(description)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionPassive> = object : Parcelable.Creator<ChampionPassive> {
            override fun createFromParcel(source: Parcel): ChampionPassive = ChampionPassive(source)
            override fun newArray(size: Int): Array<ChampionPassive?> = arrayOfNulls(size)
        }
    }
}