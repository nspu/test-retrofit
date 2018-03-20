package fr.nspu.sample_data_dragon.view.champion


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.databinding.DataBindingUtil
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.os.Parcelable
import android.preference.PreferenceManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nspu.riot_api.DataDragonApi
import fr.nspu.riot_api.models.ChampionSkin

import fr.nspu.sample_data_dragon.R
import fr.nspu.sample_data_dragon.databinding.FragmentChampionSkinBinding
import fr.nspu.sample_data_dragon.view.SettingsActivity
import java.util.ArrayList

class ChampionSkinsFragment : Fragment() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v13.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private lateinit var mChampionSkins:List<ChampionSkin>
    private lateinit var mChampionNameKey: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mChampionSkins = arguments!!.getParcelableArrayList<ChampionSkin>(ARG_CHAMPION_SKIN_LIST)
            mChampionNameKey= arguments!!.getString(ARG_CHAMPION_NAME)
        }
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(fragmentManager!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_champion_skins, container, false)
        val container = view.findViewById<ViewPager>(R.id.container)

        //Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter
        mSectionsPagerAdapter!!.notifyDataSetChanged()
        return view
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): PlaceholderFragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(mChampionSkins.get(position), mChampionNameKey)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return mChampionSkins.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mChampionSkins.get(position).name
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_CHAMPION_NAME = "champion_name"
        private val ARG_CHAMPION_SKIN = "champion_skin"
        private val ARG_CHAMPION_SKIN_LIST = "champion_skin_list"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(championSkin: List<ChampionSkin>, mChampionNameKey:String): Fragment {
            val fragment = ChampionSkinsFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_CHAMPION_SKIN_LIST, championSkin as ArrayList<out Parcelable>)
            args.putString(ARG_CHAMPION_NAME, mChampionNameKey)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onDetach() {
        super.onDetach()
        mSectionsPagerAdapter!!.notifyDataSetChanged()
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        private lateinit var mBinding : FragmentChampionSkinBinding

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_champion_skin, container, false)
            val sharedPref = PreferenceManager.getDefaultSharedPreferences(activity)
            val language = sharedPref.getString(SettingsActivity.PREF_LANGUAGE, "")
            val version = sharedPref.getString(SettingsActivity.PREF_VERSION, "")
            val championSkin:ChampionSkin = arguments!!.getParcelable(ARG_CHAMPION_SKIN)
            val mChampionNameKey= arguments!!.getString(ARG_CHAMPION_NAME)
            DataDragonApi(version, language, activity).imageService.getLoadingScreenArt(mChampionNameKey, championSkin.num!!, mBinding.ivSkin)
            return mBinding.root
        }

        companion object {
            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(championSkin: ChampionSkin, mChampionNameKey:String): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putParcelable(ARG_CHAMPION_SKIN, championSkin)
                args.putString(ARG_CHAMPION_NAME, mChampionNameKey)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
