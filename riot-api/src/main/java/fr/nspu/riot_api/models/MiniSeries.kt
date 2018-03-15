package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 12/03/18.
 */
data class MiniSeries(
        private var wins: Int? = null,
        private var losses: Int? = null,
        var target: Int? = null,
        private var progress: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(wins)
        writeValue(losses)
        writeValue(target)
        writeString(progress)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MiniSeries> = object : Parcelable.Creator<MiniSeries> {
            override fun createFromParcel(source: Parcel): MiniSeries = MiniSeries(source)
            override fun newArray(size: Int): Array<MiniSeries?> = arrayOfNulls(size)
        }
    }
}