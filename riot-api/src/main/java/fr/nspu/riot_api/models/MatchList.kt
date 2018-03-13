package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchList(
        var matches: List<MatchReference>? = null,
        var totalGames: Int? = null,
        var startIndex: Int? = null,
        var endIndex: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(MatchReference.CREATOR),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(matches)
        writeValue(totalGames)
        writeValue(startIndex)
        writeValue(endIndex)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchList> = object : Parcelable.Creator<MatchList> {
            override fun createFromParcel(source: Parcel): MatchList = MatchList(source)
            override fun newArray(size: Int): Array<MatchList?> = arrayOfNulls(size)
        }
    }
}
