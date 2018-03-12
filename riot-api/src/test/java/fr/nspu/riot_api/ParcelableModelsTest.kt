package fr.nspu.riot_api

import android.os.Parcel
import android.os.Parcelable

import com.google.common.collect.Lists
import com.google.gson.GsonBuilder

import org.fest.util.Arrays
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

import java.util.ArrayList

import fr.nspu.riot_api.models.Champion
import fr.nspu.riot_api.models.ChampionInfos
import fr.nspu.riot_api.models.ChampionLevelTip
import fr.nspu.riot_api.models.ChampionList
import fr.nspu.riot_api.models.ChampionPassive
import fr.nspu.riot_api.models.ChampionRecommandedBlockItem
import fr.nspu.riot_api.models.ChampionRecommandedData
import fr.nspu.riot_api.models.ChampionSkin
import fr.nspu.riot_api.models.ChampionSpell
import fr.nspu.riot_api.models.ChampionSpellVar
import fr.nspu.riot_api.models.ChampionStats
import fr.nspu.riot_api.models.Image
import fr.nspu.riot_api.models.Item
import fr.nspu.riot_api.models.ItemGold
import fr.nspu.riot_api.models.ItemGroup
import fr.nspu.riot_api.models.ItemInventoryDataStats
import fr.nspu.riot_api.models.ItemList
import fr.nspu.riot_api.models.ItemTree
import fr.nspu.riot_api.models.LanguageStrings

import org.fest.assertions.api.Assertions.assertThat

@RunWith(RobolectricTestRunner::class)
class ParcelableModelsTest {

    internal val modelClasses: ArrayList<Class<out Parcelable>>
        get() = Lists.newArrayList(
                Image::class.java,
                ChampionList::class.java,
                ChampionSpellVar::class.java,
                ChampionInfos::class.java,
                ChampionLevelTip::class.java,
                ChampionPassive::class.java,
                ChampionRecommandedBlockItem::class.java,
                ChampionRecommandedData::class.java,
                ChampionSkin::class.java,
                ChampionSpell::class.java,
                ChampionStats::class.java,
                Champion::class.java,
                Item::class.java,
                ItemGold::class.java,
                ItemGroup::class.java,
                ItemInventoryDataStats::class.java,
                ItemList::class.java,
                ItemTree::class.java,
                LanguageStrings::class.java
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
        val body = TestUtils.readTestData("championWukong.json")
        val fixture = GsonBuilder().create().fromJson(body, Champion::class.java)
        testSingleParcelable(fixture)
    }

}