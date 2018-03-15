package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 12/03/18.
 */
data class RuneStats(
        private var PercentTimeDeadModPerLevel: Double? = null,
        private var PercentArmorPenetrationModPerLevel: Double? = null,
        private var PercentCritDamageMod: Double? = null,
        private var PercentSpellBlockMod: Double? = null,
        private var PercentHPRegenMod: Double? = null,
        private var PercentMovementSpeedMod: Double? = null,
        private var FlatSpellBlockMod: Double? = null,
        private var FlatEnergyRegenModPerLevel: Double? = null,
        private var FlatEnergyPoolMod: Double? = null,
        private var FlatMagicPenetrationModPerLevel: Double? = null,
        private var PercentLifeStealMod: Double? = null,
        private var FlatMPPoolMod: Double? = null,
        private var PercentCooldownMod: Double? = null,
        private var PercentMagicPenetrationMod: Double? = null,
        private var FlatArmorPenetrationModPerLevel: Double? = null,
        private var FlatMovementSpeedMod: Double? = null,
        private var FlatTimeDeadModPerLevel: Double? = null,
        private var FlatArmorModPerLevel: Double? = null,
        private var PercentAttackSpeedMod: Double? = null,
        private var FlatDodgeModPerLevel: Double? = null,
        private var PercentMagicDamageMod: Double? = null,
        private var PercentBlockMod: Double? = null,
        private var FlatDodgeMod: Double? = null,
        private var FlatEnergyRegenMod: Double? = null,
        private var FlatHPModPerLevel: Double? = null,
        private var PercentAttackSpeedModPerLevel: Double? = null,
        private var PercentSpellVampMod: Double? = null,
        private var FlatMPRegenMod: Double? = null,
        private var PercentHPPoolMod: Double? = null,
        private var PercentDodgeMod: Double? = null,
        private var FlatAttackSpeedMod: Double? = null,
        private var FlatArmorMod: Double? = null,
        private var FlatMagicDamageModPerLevel: Double? = null,
        private var FlatHPRegenMod: Double? = null,
        private var PercentPhysicalDamageMod: Double? = null,
        private var FlatCritChanceModPerLevel: Double? = null,
        private var FlatSpellBlockModPerLevel: Double? = null,
        private var PercentTimeDeadMod: Double? = null,
        private var FlatBlockMod: Double? = null,
        private var PercentMPPoolMod: Double? = null,
        private var FlatMagicDamageMod: Double? = null,
        private var PercentMPRegenMod: Double? = null,
        private var PercentMovementSpeedModPerLevel: Double? = null,
        private var PercentCooldownModPerLevel: Double? = null,
        private var FlatMPModPerLevel: Double? = null,
        private var FlatEnergyModPerLevel: Double? = null,
        private var FlatPhysicalDamageMod: Double? = null,
        private var FlatHPRegenModPerLevel: Double? = null,
        private var FlatCritDamageMod: Double? = null,
        private var PercentArmorMod: Double? = null,
        private var FlatMagicPenetrationMod: Double? = null,
        private var PercentCritChanceMod: Double? = null,
        private var FlatPhysicalDamageModPerLevel: Double? = null,
        private var PercentArmorPenetrationMod: Double? = null,
        private var PercentEXPBonus: Double? = null,
        private var FlatMPRegenModPerLevel: Double? = null,
        private var PercentMagicPenetrationModPerLevel: Double? = null,
        private var FlatTimeDeadMod: Double? = null,
        private var FlatMovementSpeedModPerLevel: Double? = null,
        private var FlatGoldPer10Mod: Double? = null,
        private var FlatArmorPenetrationMod: Double? = null,
        private var FlatCritDamageModPerLevel: Double? = null,
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
        writeValue(PercentTimeDeadModPerLevel)
        writeValue(PercentArmorPenetrationModPerLevel)
        writeValue(PercentCritDamageMod)
        writeValue(PercentSpellBlockMod)
        writeValue(PercentHPRegenMod)
        writeValue(PercentMovementSpeedMod)
        writeValue(FlatSpellBlockMod)
        writeValue(FlatEnergyRegenModPerLevel)
        writeValue(FlatEnergyPoolMod)
        writeValue(FlatMagicPenetrationModPerLevel)
        writeValue(PercentLifeStealMod)
        writeValue(FlatMPPoolMod)
        writeValue(PercentCooldownMod)
        writeValue(PercentMagicPenetrationMod)
        writeValue(FlatArmorPenetrationModPerLevel)
        writeValue(FlatMovementSpeedMod)
        writeValue(FlatTimeDeadModPerLevel)
        writeValue(FlatArmorModPerLevel)
        writeValue(PercentAttackSpeedMod)
        writeValue(FlatDodgeModPerLevel)
        writeValue(PercentMagicDamageMod)
        writeValue(PercentBlockMod)
        writeValue(FlatDodgeMod)
        writeValue(FlatEnergyRegenMod)
        writeValue(FlatHPModPerLevel)
        writeValue(PercentAttackSpeedModPerLevel)
        writeValue(PercentSpellVampMod)
        writeValue(FlatMPRegenMod)
        writeValue(PercentHPPoolMod)
        writeValue(PercentDodgeMod)
        writeValue(FlatAttackSpeedMod)
        writeValue(FlatArmorMod)
        writeValue(FlatMagicDamageModPerLevel)
        writeValue(FlatHPRegenMod)
        writeValue(PercentPhysicalDamageMod)
        writeValue(FlatCritChanceModPerLevel)
        writeValue(FlatSpellBlockModPerLevel)
        writeValue(PercentTimeDeadMod)
        writeValue(FlatBlockMod)
        writeValue(PercentMPPoolMod)
        writeValue(FlatMagicDamageMod)
        writeValue(PercentMPRegenMod)
        writeValue(PercentMovementSpeedModPerLevel)
        writeValue(PercentCooldownModPerLevel)
        writeValue(FlatMPModPerLevel)
        writeValue(FlatEnergyModPerLevel)
        writeValue(FlatPhysicalDamageMod)
        writeValue(FlatHPRegenModPerLevel)
        writeValue(FlatCritDamageMod)
        writeValue(PercentArmorMod)
        writeValue(FlatMagicPenetrationMod)
        writeValue(PercentCritChanceMod)
        writeValue(FlatPhysicalDamageModPerLevel)
        writeValue(PercentArmorPenetrationMod)
        writeValue(PercentEXPBonus)
        writeValue(FlatMPRegenModPerLevel)
        writeValue(PercentMagicPenetrationModPerLevel)
        writeValue(FlatTimeDeadMod)
        writeValue(FlatMovementSpeedModPerLevel)
        writeValue(FlatGoldPer10Mod)
        writeValue(FlatArmorPenetrationMod)
        writeValue(FlatCritDamageModPerLevel)
        writeValue(FlatHPPoolMod)
        writeValue(FlatCritChanceMod)
        writeValue(FlatEXPBonus)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RuneStats> = object : Parcelable.Creator<RuneStats> {
            override fun createFromParcel(source: Parcel): RuneStats = RuneStats(source)
            override fun newArray(size: Int): Array<RuneStats?> = arrayOfNulls(size)
        }
    }
}