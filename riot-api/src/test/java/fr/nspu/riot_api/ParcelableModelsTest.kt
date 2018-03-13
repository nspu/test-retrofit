package fr.nspu.riot_api

import android.os.Parcel
import android.os.Parcelable

import com.google.common.collect.Lists
import com.google.gson.GsonBuilder
import fr.nspu.riot_api.models.*

import org.fest.util.Arrays
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

import java.util.ArrayList

import org.fest.assertions.api.Assertions.assertThat

@RunWith(RobolectricTestRunner::class)
class ParcelableModelsTest {

    internal val modelClasses: ArrayList<Class<out Parcelable>>
        get() = Lists.newArrayList(
                Image::class.java,
                ChampionListData::class.java,
                ChampionSpellVar::class.java,
                ChampionDataInfo::class.java,
                LevelTip::class.java,
                ChampionPassive::class.java,
                ChampionRecommandedBlockItem::class.java,
                ChampionRecommandedData::class.java,
                ChampionSkin::class.java,
                ChampionSpell::class.java,
                ChampionStats::class.java,
                ChampionData::class.java,
                Item::class.java,
                ItemGold::class.java,
                ItemGroup::class.java,
                ItemInventoryDataStats::class.java,
                ItemList::class.java,
                ItemTree::class.java,
                LanguageStrings::class.java,
                MapDetails::class.java,
                Maps::class.java,
                Mastery::class.java,
                MasteryList::class.java,
                MasteryTree::class.java,
                MasteryTreeItem::class.java,
                MasteryTreeList::class.java,
                ProfileIconData::class.java,
                ProfileIconDetails::class.java,
                Realm::class.java,
                ReforgedRune::class.java,
                ReforgedRunePath::class.java,
                ReforgedRuneSlot::class.java,
                MetaData::class.java,
                Rune::class.java,
                RuneList::class.java,
                RuneStats::class.java,
                SummonerSpell::class.java,
                SummonerSpellList::class.java,
                SpellVars::class.java,
                ChampionMastery::class.java,
                ChampionInfo::class.java,
                ChampionListInfo::class.java,
                LeagueItem::class.java,
                LeagueList::class.java,
                LeaguePosition::class.java,
                MiniSeries::class.java
        )

    @Test
    @Throws(IllegalAccessException::class, InstantiationException::class, NoSuchFieldException::class)
    fun allParcelables() {

        val populator = ModelPopulator("CREATOR", "\$jacocoData", "companion")

        for (modelClass in modelClasses) {

            val instance = populator.populateWithRandomValues<Parcelable>(modelClass as Class<Parcelable>)

            testSingleParcelable(instance)
            testParcelableArray(instance)

            /* Trick to increase code coverage */
            instance.describeContents()
            (modelClass.getField("CREATOR").get(null) as Parcelable.Creator<*>).newArray(13)
        }
    }

    internal fun <T : Parcelable> testSingleParcelable(underTest: T) {

        val parcel = Parcel.obtain()
        parcel.writeParcelable(underTest, 0)
        parcel.setDataPosition(0)
        val fromParcel = parcel.readParcelable<T>(underTest.javaClass.classLoader)

        ModelAssert.assertThat(fromParcel).isEqualByComparingFields(underTest)
    }

    internal fun <T : Parcelable> testParcelableArray(underTest: T) {

        val parcel = Parcel.obtain()
        parcel.writeParcelableArray(Arrays.array(underTest, underTest), 0)
        parcel.setDataPosition(0)
        val fromParcel = parcel.readParcelableArray(underTest.javaClass.classLoader)

        assertThat(fromParcel).hasSize(2)
        assertThat(fromParcel[0]).isEqualsToByComparingFields(underTest)
        assertThat(fromParcel[1]).isEqualsToByComparingFields(underTest)
    }

    @Test
    fun championAreGoodParcelableCitizen() {
        val body = TestUtils.readTestData("champion-wukong.json")
        val fixture = GsonBuilder().create().fromJson(body, ChampionData::class.java)
        testSingleParcelable(fixture)
    }

}