package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class MatchEvent(
        private var eventType: String? = null,
        private var towerType: String? = null,
        private var teamId: Int? = null,
        private var ascendedType: String? = null,
        private var killerId: Int? = null,
        private var levelUpType: String? = null,
        private var pointCaptured: String? = null,
        private var assistingParticipantIds: List<Int>? = null,
        private var wardType: String? = null,
        private var monsterType: String? = null,
        var type: String? = null,    //(Legal values: CHAMPION_KILL, WARD_PLACED, WARD_KILL, BUILDING_KILL, ELITE_MONSTER_KILL, ITEM_PURCHASED, ITEM_SOLD, ITEM_DESTROYED, ITEM_UNDO, SKILL_LEVEL_UP, ASCENDED_EVENT, CAPTURE_POINT, PORO_KING_SUMMON)
        private var skillSlot: Int? = null,
        private var victimId: Int? = null,
        private var timestamp: Long? = null,
        private var afterId: Int? = null,
        private var monsterSubType: String? = null,
        private var laneType: String? = null,
        private var itemId: Int? = null,
        private var participantId: Int? = null,
        private var buildingType: String? = null,
        private var creatorId: Int? = null,
        private var position: MatchPosition? = null,
        private var beforeId: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            ArrayList<Int>().apply { source.readList(this, Int::class.java.classLoader) },
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readParcelable<MatchPosition>(MatchPosition::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(eventType)
        writeString(towerType)
        writeValue(teamId)
        writeString(ascendedType)
        writeValue(killerId)
        writeString(levelUpType)
        writeString(pointCaptured)
        writeList(assistingParticipantIds)
        writeString(wardType)
        writeString(monsterType)
        writeString(type)
        writeValue(skillSlot)
        writeValue(victimId)
        writeValue(timestamp)
        writeValue(afterId)
        writeString(monsterSubType)
        writeString(laneType)
        writeValue(itemId)
        writeValue(participantId)
        writeString(buildingType)
        writeValue(creatorId)
        writeParcelable(position, 0)
        writeValue(beforeId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchEvent> = object : Parcelable.Creator<MatchEvent> {
            override fun createFromParcel(source: Parcel): MatchEvent = MatchEvent(source)
            override fun newArray(size: Int): Array<MatchEvent?> = arrayOfNulls(size)
        }
    }
}