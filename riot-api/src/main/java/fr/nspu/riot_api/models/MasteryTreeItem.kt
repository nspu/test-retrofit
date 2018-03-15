package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 11/03/18.
 */
data class MasteryTreeItem(
        private var masteryId: Int? = null,
        private var prereq: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(masteryId)
        writeString(prereq)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MasteryTreeItem> = object : Parcelable.Creator<MasteryTreeItem> {
            override fun createFromParcel(source: Parcel): MasteryTreeItem = MasteryTreeItem(source)
            override fun newArray(size: Int): Array<MasteryTreeItem?> = arrayOfNulls(size)
        }
    }
}