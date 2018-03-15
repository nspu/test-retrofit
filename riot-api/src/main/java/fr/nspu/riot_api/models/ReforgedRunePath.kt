package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 12/03/18.
 */
data class ReforgedRunePath(
        private var slots: List<ReforgedRuneSlot>? = null,
        var icon: String? = null,
        var id: Int? = null,
        var key: String? = null,
        var name: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(ReforgedRuneSlot.CREATOR),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(slots)
        writeString(icon)
        writeValue(id)
        writeString(key)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ReforgedRunePath> = object : Parcelable.Creator<ReforgedRunePath> {
            override fun createFromParcel(source: Parcel): ReforgedRunePath = ReforgedRunePath(source)
            override fun newArray(size: Int): Array<ReforgedRunePath?> = arrayOfNulls(size)
        }
    }
}