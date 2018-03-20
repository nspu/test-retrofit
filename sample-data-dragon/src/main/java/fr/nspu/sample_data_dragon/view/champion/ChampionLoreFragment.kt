package fr.nspu.sample_data_dragon.view.champion


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import fr.nspu.sample_data_dragon.R
import kotlinx.android.synthetic.main.fragment_champion_lore.*


/**
 * A simple [Fragment] subclass.
 * Use the [ChampionLoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChampionLoreFragment : Fragment() {

    private var mLore: String? = null
    private var mName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mLore = arguments!!.getString(ARG_LORE)
            mName = arguments!!.getString(ARG_NAME)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_champion_lore, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_lore.text = mLore
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_LORE = "lore"
        private val ARG_NAME = "name"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param lore Parameter 1.
         * @param name Parameter 2.
         * @return A new instance of fragment ChampionLoreFragment.
         */
        fun newInstance(lore: String, name: String): ChampionLoreFragment {
            val fragment = ChampionLoreFragment()
            val args = Bundle()
            args.putString(ARG_LORE, lore)
            args.putString(ARG_NAME, name)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
