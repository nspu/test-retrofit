package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 11/03/18.
 */
data class ItemInventoryDataStats(
        private var PercentCritDamageMod: Double? = null,
        private var PercentSpellBlockMod: Double? = null,
        private var PercentHPRegenMod: Double? = null,
        private var PercentMovementSpeedMod: Double? = null,
        private var FlatSpellBlockMod: Double? = null,
        private var FlatCritDamageMod: Double? = null,
        private var FlatEnergyPoolMod: Double? = null,
        private var PercentLifeStealMod: Double? = null,
        private var FlatMPPoolMod: Double? = null,
        private var FlatMovementSpeedMod: Double? = null,
        private var PercentAttackSpeedMod: Double? = null,
        private var FlatBlockMod: Double? = null,
        private var PercentBlockMod: Double? = null,
        private var FlatEnergyRegenMod: Double? = null,
        private var PercentSpellVampMod: Double? = null,
        private var FlatMPRegenMod: Double? = null,
        private var PercentDodgeMod: Double? = null,
        private var FlatAttackSpeedMod: Double? = null,
        private var FlatArmorMod: Double? = null,
        private var FlatHPRegenMod: Double? = null,
        private var PercentMagicDamageMod: Double? = null,
        private var PercentMPPoolMod: Double? = null,
        private var FlatMagicDamageMod: Double? = null,
        private var PercentMPRegenMod: Double? = null,
        private var PercentPhysicalDamageMod: Double? = null,
        private var FlatPhysicalDamageMod: Double? = null,
        private var PercentHPPoolMod: Double? = null,
        private var PercentArmorMod: Double? = null,
        private var PercentCritChanceMod: Double? = null,
        private var PercentEXPBonus: Double? = null,
        private var FlatHPPoolMod: Double? = null,
        private var FlatCritChanceMod: Double? = null,
        private var FlatEXPBonus: Double? = null
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
        writeValue(PercentCritDamageMod)
        writeValue(PercentSpellBlockMod)
        writeValue(PercentHPRegenMod)
        writeValue(PercentMovementSpeedMod)
        writeValue(FlatSpellBlockMod)
        writeValue(FlatCritDamageMod)
        writeValue(FlatEnergyPoolMod)
        writeValue(PercentLifeStealMod)
        writeValue(FlatMPPoolMod)
        writeValue(FlatMovementSpeedMod)
        writeValue(PercentAttackSpeedMod)
        writeValue(FlatBlockMod)
        writeValue(PercentBlockMod)
        writeValue(FlatEnergyRegenMod)
        writeValue(PercentSpellVampMod)
        writeValue(FlatMPRegenMod)
        writeValue(PercentDodgeMod)
        writeValue(FlatAttackSpeedMod)
        writeValue(FlatArmorMod)
        writeValue(FlatHPRegenMod)
        writeValue(PercentMagicDamageMod)
        writeValue(PercentMPPoolMod)
        writeValue(FlatMagicDamageMod)
        writeValue(PercentMPRegenMod)
        writeValue(PercentPhysicalDamageMod)
        writeValue(FlatPhysicalDamageMod)
        writeValue(PercentHPPoolMod)
        writeValue(PercentArmorMod)
        writeValue(PercentCritChanceMod)
        writeValue(PercentEXPBonus)
        writeValue(FlatHPPoolMod)
        writeValue(FlatCritChanceMod)
        writeValue(FlatEXPBonus)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ItemInventoryDataStats> = object : Parcelable.Creator<ItemInventoryDataStats> {
            override fun createFromParcel(source: Parcel): ItemInventoryDataStats = ItemInventoryDataStats(source)
            override fun newArray(size: Int): Array<ItemInventoryDataStats?> = arrayOfNulls(size)
        }
    }
}