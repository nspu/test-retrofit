package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 11/03/18.
 */
data class MasteryTree(
        private var Resolve: List<MasteryTreeList>? = null,
        private var Defense: List<MasteryTreeList>? = null,
        private var Utility: List<MasteryTreeList>? = null,
        private var Offense: List<MasteryTreeList>? = null,
        private var Ferocity: List<MasteryTreeList>? = null,
        private var Cunning: List<MasteryTreeList>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(Resolve)
        writeTypedList(Defense)
        writeTypedList(Utility)
        writeTypedList(Offense)
        writeTypedList(Ferocity)
        writeTypedList(Cunning)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MasteryTree> = object : Parcelable.Creator<MasteryTree> {
            override fun createFromParcel(source: Parcel): MasteryTree = MasteryTree(source)
            override fun newArray(size: Int): Array<MasteryTree?> = arrayOfNulls(size)
        }
    }
}