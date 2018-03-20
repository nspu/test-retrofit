package fr.nspu.sample_data_dragon.view.champion


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import fr.nspu.sample_data_dragon.R
import kotlinx.android.synthetic.main.fragment_champion_tips.*
import java.util.ArrayList
import android.widget.ArrayAdapter




/**
 * A simple [Fragment] subclass.
 * Use the [ChampionTipsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChampionTipsFragment : Fragment() {

    private var mAllyTips: List<String>? = null
    private var mTypeTips: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mAllyTips = arguments!!.getStringArrayList(ARG_TIPS)
            mTypeTips = arguments!!.getString(ARG_TYPE_TIPS)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_champion_tips, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = ArrayAdapter<String>(activity,
                android.R.layout.simple_list_item_1,
                mAllyTips)
        iv_ally_tips.adapter = adapter
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_TIPS = "ally-tips"
        private val ARG_TYPE_TIPS = "type_tips"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param allytips Parameter 1.
         * @param type_tips Parameter 2.
         * @return A new instance of fragment ChampionTipsFragment.
         */
        fun newInstance(allytips: List<String>, typeTips:String): ChampionTipsFragment {
            val fragment = ChampionTipsFragment()
            val args = Bundle()
            args.putStringArrayList(ARG_TIPS, allytips as ArrayList<String>)
            args.putString(ARG_TYPE_TIPS, typeTips)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
