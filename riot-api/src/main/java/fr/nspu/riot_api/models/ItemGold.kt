package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 11/03/18.
 */
data class ItemGold(
        private var sell: Int? = null,
        private var total: Int? = null,
        var base: Int? = null,
        private var purchasable: Boolean? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(sell)
        writeValue(total)
        writeValue(base)
        writeValue(purchasable)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ItemGold> = object : Parcelable.Creator<ItemGold> {
            override fun createFromParcel(source: Parcel): ItemGold = ItemGold(source)
            override fun newArray(size: Int): Array<ItemGold?> = arrayOfNulls(size)
        }
    }
}