package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 09/03/18.
 */
data class Champion(
        var info: ChampionInfos? = null,
        var enemytips: List<String>? = null,
        var stats: ChampionStats? = null,
        var name: String? = null,
        var title: String? = null,
        var image: Image? = null,
        var tags: List<String>? = null,
        var partype: String? = null,
        var skins: List<ChampionSkin>? = null,
        var passive: ChampionPassive? = null,
        var recommended: List<ChampionRecommandedData>? = null,
        var allytips: List<String>? = null,
        var key: String? = null,
        var lore: String? = null,
        var id: Int? = null,
        var blurb: String? = null,
        var spells: List<ChampionSpell>? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<ChampionInfos>(ChampionInfos::class.java.classLoader),
            source.createStringArrayList(),
            source.readParcelable<ChampionStats>(ChampionStats::class.java.classLoader),
            source.readString(),
            source.readString(),
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.createStringArrayList(),
            source.readString(),
            source.createTypedArrayList(ChampionSkin.CREATOR),
            source.readParcelable<ChampionPassive>(ChampionPassive::class.java.classLoader),
            source.createTypedArrayList(ChampionRecommandedData.CREATOR),
            source.createStringArrayList(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.createTypedArrayList(ChampionSpell.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(info, 0)
        writeStringList(enemytips)
        writeParcelable(stats, 0)
        writeString(name)
        writeString(title)
        writeParcelable(image, 0)
        writeStringList(tags)
        writeString(partype)
        writeTypedList(skins)
        writeParcelable(passive, 0)
        writeTypedList(recommended)
        writeStringList(allytips)
        writeString(key)
        writeString(lore)
        writeValue(id)
        writeString(blurb)
        writeTypedList(spells)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Champion> = object : Parcelable.Creator<Champion> {
            override fun createFromParcel(source: Parcel): Champion = Champion(source)
            override fun newArray(size: Int): Array<Champion?> = arrayOfNulls(size)
        }
    }
}