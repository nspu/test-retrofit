package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 12/03/18.
 */
data class ReforgedRune(
        private var runePathName: String? = null,
        private var runePathId: Int? = null,
        var name: String? = null,
        var id: Int? = null,
        var key: String? = null,
        private var shortDesc: String? = null,
        private var longDesc: String? = null,
        var icon: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(runePathName)
        writeValue(runePathId)
        writeString(name)
        writeValue(id)
        writeString(key)
        writeString(shortDesc)
        writeString(longDesc)
        writeString(icon)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ReforgedRune> = object : Parcelable.Creator<ReforgedRune> {
            override fun createFromParcel(source: Parcel): ReforgedRune = ReforgedRune(source)
            override fun newArray(size: Int): Array<ReforgedRune?> = arrayOfNulls(size)
        }
    }
}