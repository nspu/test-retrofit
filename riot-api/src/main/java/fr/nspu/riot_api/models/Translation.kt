package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class Translation(
        private var locale: String? = null,
        private var content: String? = null,
        private var updated_at: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(locale)
        writeString(content)
        writeString(updated_at)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Translation> = object : Parcelable.Creator<Translation> {
            override fun createFromParcel(source: Parcel): Translation = Translation(source)
            override fun newArray(size: Int): Array<Translation?> = arrayOfNulls(size)
        }
    }
}