package fr.nspu.riot_api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;

import org.fest.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import fr.nspu.riot_api.models.Champion;
import fr.nspu.riot_api.models.ChampionInfos;
import fr.nspu.riot_api.models.ChampionLevelTip;
import fr.nspu.riot_api.models.ChampionList;
import fr.nspu.riot_api.models.ChampionPassive;
import fr.nspu.riot_api.models.ChampionRecommandedBlockItem;
import fr.nspu.riot_api.models.ChampionRecommandedData;
import fr.nspu.riot_api.models.ChampionSkin;
import fr.nspu.riot_api.models.ChampionSpell;
import fr.nspu.riot_api.models.ChampionSpellVar;
import fr.nspu.riot_api.models.ChampionStats;
import fr.nspu.riot_api.models.Image;
import fr.nspu.riot_api.models.Item;
import fr.nspu.riot_api.models.ItemGold;
import fr.nspu.riot_api.models.ItemGroup;
import fr.nspu.riot_api.models.ItemInventoryDataStats;
import fr.nspu.riot_api.models.ItemList;
import fr.nspu.riot_api.models.ItemTree;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class ParcelableModelsTest {

    @Test
    public void allParcelables() throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        ModelPopulator populator = new ModelPopulator("CREATOR", "$jacocoData", "companion");

        for (Class<? extends Parcelable> modelClass : getModelClasses()) {

            Parcelable instance = populator.populateWithRandomValues(modelClass);

            testSingleParcelable(instance);
            testParcelableArray(instance);

            /* Trick to increase code coverage */
            instance.describeContents();
            ((Parcelable.Creator<?>) modelClass.getField("CREATOR").get(null)).newArray(13);
        }
    }

    ArrayList<Class<? extends Parcelable>> getModelClasses() {
        return Lists.newArrayList(
                Image.class,
                ChampionList.class,
                ChampionSpellVar.class,
                ChampionInfos.class,
                ChampionLevelTip.class,
                ChampionPassive.class,
                ChampionRecommandedBlockItem.class,
                ChampionRecommandedData.class,
                ChampionSkin.class,
                ChampionSpell.class,
                ChampionStats.class,
                Champion.class,
                Item.class,
                ItemGold.class,
                ItemGroup.class,
                ItemInventoryDataStats.class,
                ItemList.class,
                ItemTree.class
        );
    }

    <T extends Parcelable> void testSingleParcelable(T underTest) {

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(underTest, 0);
        parcel.setDataPosition(0);
        T fromParcel = parcel.readParcelable(underTest.getClass().getClassLoader());

        ModelAssert.Companion.assertThat(fromParcel).isEqualByComparingFields(underTest);
    }

    <T extends Parcelable> void testParcelableArray(T underTest) {

        Parcel parcel = Parcel.obtain();
        parcel.writeParcelableArray(Arrays.array(underTest, underTest), 0);
        parcel.setDataPosition(0);
        Parcelable[] fromParcel = parcel.readParcelableArray(underTest.getClass().getClassLoader());

        assertThat(fromParcel).hasSize(2);
        assertThat(fromParcel[0]).isEqualsToByComparingFields(underTest);
        assertThat(fromParcel[1]).isEqualsToByComparingFields(underTest);
    }

    @Test
    public void championAreGoodParcelableCitizen() {
        String body = TestUtils.INSTANCE.readTestData("championWukong.json");
        Champion fixture = new GsonBuilder().create().fromJson(body, Champion.class);
        testSingleParcelable(fixture);
    }

}