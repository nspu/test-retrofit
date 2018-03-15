package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 09/03/18.
 */
data class ChampionStats(
        private var armorperlevel: Double? = null,
        private var hpperlevel: Double? = null,
        private var attackdamage: Double? = null,
        private var mpperlevel: Double? = null,
        private var attackspeedoffset: Double? = null,
        var armor: Double? = null,
        private var hp: Double? = null,
        private var hpregenperlevel: Double? = null,
        private var spellblock: Double? = null,
        private var attackrange: Double? = null,
        private var movespeed: Double? = null,
        private var attackdamageperlevel: Double? = null,
        private var mpregenperlevel: Double? = null,
        private var mp: Double? = null,
        private var spellblockperlevel: Double? = null,
        private var crit: Double? = null,
        private var mpregen: Double? = null,
        private var attackspeedperlevel: Double? = null,
        private var hpregen: Double? = null,
        private var critperlevel: Double? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(armorperlevel)
        writeValue(hpperlevel)
        writeValue(attackdamage)
        writeValue(mpperlevel)
        writeValue(attackspeedoffset)
        writeValue(armor)
        writeValue(hp)
        writeValue(hpregenperlevel)
        writeValue(spellblock)
        writeValue(attackrange)
        writeValue(movespeed)
        writeValue(attackdamageperlevel)
        writeValue(mpregenperlevel)
        writeValue(mp)
        writeValue(spellblockperlevel)
        writeValue(crit)
        writeValue(mpregen)
        writeValue(attackspeedperlevel)
        writeValue(hpregen)
        writeValue(critperlevel)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionStats> = object : Parcelable.Creator<ChampionStats> {
            override fun createFromParcel(source: Parcel): ChampionStats = ChampionStats(source)
            override fun newArray(size: Int): Array<ChampionStats?> = arrayOfNulls(size)
        }
    }
}