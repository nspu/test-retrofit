package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 11/03/18.
 */
data class Mastery(
        private var prereq: String? = null,
        private var masteryTree: String? = null,    //(Legal values: Cunning, Ferocity, Resolve, Defense, Offense, Utility)
        var name: String? = null,
        private var ranks: Int? = null,
        var image: Image? = null,
        var sanitizedDescription: List<String>? = null,
        var id: Int? = null,
        var description: List<String>? = null
        ) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.createStringArrayList(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(prereq)
        writeString(masteryTree)
        writeString(name)
        writeValue(ranks)
        writeParcelable(image, 0)
        writeStringList(sanitizedDescription)
        writeValue(id)
        writeStringList(description)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Mastery> = object : Parcelable.Creator<Mastery> {
            override fun createFromParcel(source: Parcel): Mastery = Mastery(source)
            override fun newArray(size: Int): Array<Mastery?> = arrayOfNulls(size)
        }
    }
}