package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchParticipantStats(
        private var physicalDamageDealt: Long? = null,
        private var neutralMinionsKilledTeamJungle: Int? = null,
        private var magicDamageDealt: Long? = null,
        private var totalPlayerScore: Int? = null,
        private var deaths: Int? = null,
        private var win: Boolean? = null,
        private var neutralMinionsKilledEnemyJungle: Int? = null,
        private var altarsCaptured: Int? = null,
        private var largestCriticalStrike: Int? = null,
        private var totalDamageDealt: Long? = null,
        private var magicDamageDealtToChampions: Long? = null,
        private var visionWardsBoughtInGame: Int? = null,
        private var damageDealtToObjectives: Long? = null,
        private var largestKillingSpree: Int? = null,
        private var item1: Int? = null,
        private var quadraKills: Int? = null,
        private var teamObjective: Int? = null,
        private var totalTimeCrowdControlDealt: Int? = null,
        private var longestTimeSpentLiving: Int? = null,
        private var wardsKilled: Int? = null,
        private var firstTowerAssist: Boolean? = null,
        private var firstTowerKill: Boolean? = null,
        private var item2: Int? = null,
        private var item3: Int? = null,
        private var item0: Int? = null,
        private var firstBloodAssist: Boolean? = null,
        private var visionScore: Long? = null,
        private var wardsPlaced: Int? = null,
        private var item4: Int? = null,
        private var item5: Int? = null,
        private var item6: Int? = null,
        private var turretKills: Int? = null,
        private var tripleKills: Int? = null,
        private var damageSelfMitigated: Long? = null,
        private var champLevel: Int? = null,
        private var nodeNeutralizeAssist: Int? = null,
        private var firstInhibitorKill: Boolean? = null,
        private var goldEarned: Int? = null,
        private var magicalDamageTaken: Long? = null,
        private var kills: Int? = null,
        private var doubleKills: Int? = null,
        private var nodeCaptureAssist: Int? = null,
        private var trueDamageTaken: Long? = null,
        private var nodeNeutralize: Int? = null,
        private var firstInhibitorAssist: Boolean? = null,
        private var assists: Int? = null,
        private var unrealKills: Int? = null,
        private var neutralMinionsKilled: Int? = null,
        private var objectivePlayerScore: Int? = null,
        private var combatPlayerScore: Int? = null,
        private var damageDealtToTurrets: Long? = null,
        private var altarsNeutralized: Int? = null,
        private var physicalDamageDealtToChampions: Long? = null,
        private var goldSpent: Int? = null,
        private var trueDamageDealt: Long? = null,
        private var trueDamageDealtToChampions: Long? = null,
        private var participantId: Int? = null,
        private var pentaKills: Int? = null,
        private var totalHeal: Long? = null,
        private var totalMinionsKilled: Int? = null,
        private var firstBloodKill: Boolean? = null,
        private var nodeCapture: Int? = null,
        private var largestMultiKill: Int? = null,
        private var sightWardsBoughtInGame: Int? = null,
        private var totalDamageDealtToChampions: Long? = null,
        private var totalUnitsHealed: Int? = null,
        private var inhibitorKills: Int? = null,
        private var totalScoreRank: Int? = null,
        private var totalDamageTaken: Long? = null,
        private var killingSprees: Int? = null,
        private var timeCCingOthers: Long? = null,
        private var physicalDamageTaken: Long? = null,
        private var perk0: Int? = null,
        private var perk0Var1: Int? = null,
        private var perk0Var2: Int? = null,
        private var perk0Var3: Int? = null,
        private var perk1: Int? = null,
        private var perk1Var1: Int? = null,
        private var perk1Var2: Int? = null,
        private var perk1Var3: Int? = null,
        private var perk2: Int? = null,
        private var perk2Var1: Int? = null,
        private var perk2Var2: Int? = null,
        private var perk2Var3: Int? = null,
        private var perk3: Int? = null,
        private var perk3Var1: Int? = null,
        private var perk3Var2: Int? = null,
        private var perk3Var3: Int? = null,
        private var perk4: Int? = null,
        private var perk4Var1: Int? = null,
        private var perk4Var2: Int? = null,
        private var perk4Var3: Int? = null,
        private var perk5: Int? = null,
        private var perk5Var1: Int? = null,
        private var perk5Var2: Int? = null,
        private var perk5Var3: Int? = null,
        private var perkPrimaryStyle: Int? = null,
        private var perkSubStyle: Int? = null,
        private var playerScore0: Int? = 0,
        private var playerScore1: Int? = 0,
        private var playerScore2: Int? = 0,
        private var playerScore3: Int? = 0,
        private var playerScore4: Int? = 0,
        private var playerScore5: Int? = 0,
        private var playerScore6: Int? = 0,
        private var playerScore7: Int? = 0,
        private var playerScore8: Int? = 0,
        private var playerScore9: Int? = 0
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(physicalDamageDealt)
        writeValue(neutralMinionsKilledTeamJungle)
        writeValue(magicDamageDealt)
        writeValue(totalPlayerScore)
        writeValue(deaths)
        writeValue(win)
        writeValue(neutralMinionsKilledEnemyJungle)
        writeValue(altarsCaptured)
        writeValue(largestCriticalStrike)
        writeValue(totalDamageDealt)
        writeValue(magicDamageDealtToChampions)
        writeValue(visionWardsBoughtInGame)
        writeValue(damageDealtToObjectives)
        writeValue(largestKillingSpree)
        writeValue(item1)
        writeValue(quadraKills)
        writeValue(teamObjective)
        writeValue(totalTimeCrowdControlDealt)
        writeValue(longestTimeSpentLiving)
        writeValue(wardsKilled)
        writeValue(firstTowerAssist)
        writeValue(firstTowerKill)
        writeValue(item2)
        writeValue(item3)
        writeValue(item0)
        writeValue(firstBloodAssist)
        writeValue(visionScore)
        writeValue(wardsPlaced)
        writeValue(item4)
        writeValue(item5)
        writeValue(item6)
        writeValue(turretKills)
        writeValue(tripleKills)
        writeValue(damageSelfMitigated)
        writeValue(champLevel)
        writeValue(nodeNeutralizeAssist)
        writeValue(firstInhibitorKill)
        writeValue(goldEarned)
        writeValue(magicalDamageTaken)
        writeValue(kills)
        writeValue(doubleKills)
        writeValue(nodeCaptureAssist)
        writeValue(trueDamageTaken)
        writeValue(nodeNeutralize)
        writeValue(firstInhibitorAssist)
        writeValue(assists)
        writeValue(unrealKills)
        writeValue(neutralMinionsKilled)
        writeValue(objectivePlayerScore)
        writeValue(combatPlayerScore)
        writeValue(damageDealtToTurrets)
        writeValue(altarsNeutralized)
        writeValue(physicalDamageDealtToChampions)
        writeValue(goldSpent)
        writeValue(trueDamageDealt)
        writeValue(trueDamageDealtToChampions)
        writeValue(participantId)
        writeValue(pentaKills)
        writeValue(totalHeal)
        writeValue(totalMinionsKilled)
        writeValue(firstBloodKill)
        writeValue(nodeCapture)
        writeValue(largestMultiKill)
        writeValue(sightWardsBoughtInGame)
        writeValue(totalDamageDealtToChampions)
        writeValue(totalUnitsHealed)
        writeValue(inhibitorKills)
        writeValue(totalScoreRank)
        writeValue(totalDamageTaken)
        writeValue(killingSprees)
        writeValue(timeCCingOthers)
        writeValue(physicalDamageTaken)
        writeValue(perk0)
        writeValue(perk0Var1)
        writeValue(perk0Var2)
        writeValue(perk0Var3)
        writeValue(perk1)
        writeValue(perk1Var1)
        writeValue(perk1Var2)
        writeValue(perk1Var3)
        writeValue(perk2)
        writeValue(perk2Var1)
        writeValue(perk2Var2)
        writeValue(perk2Var3)
        writeValue(perk3)
        writeValue(perk3Var1)
        writeValue(perk3Var2)
        writeValue(perk3Var3)
        writeValue(perk4)
        writeValue(perk4Var1)
        writeValue(perk4Var2)
        writeValue(perk4Var3)
        writeValue(perk5)
        writeValue(perk5Var1)
        writeValue(perk5Var2)
        writeValue(perk5Var3)
        writeValue(perkPrimaryStyle)
        writeValue(perkSubStyle)
        writeValue(playerScore0)
        writeValue(playerScore1)
        writeValue(playerScore2)
        writeValue(playerScore3)
        writeValue(playerScore4)
        writeValue(playerScore5)
        writeValue(playerScore6)
        writeValue(playerScore7)
        writeValue(playerScore8)
        writeValue(playerScore9)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchParticipantStats> = object : Parcelable.Creator<MatchParticipantStats> {
            override fun createFromParcel(source: Parcel): MatchParticipantStats = MatchParticipantStats(source)
            override fun newArray(size: Int): Array<MatchParticipantStats?> = arrayOfNulls(size)
        }
    }
}