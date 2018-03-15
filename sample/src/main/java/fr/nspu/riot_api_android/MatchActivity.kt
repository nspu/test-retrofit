package fr.nspu.riot_api_android

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.nspu.riot_api.models.ChampionData
import fr.nspu.riot_api.models.MatchReference
import fr.nspu.riot_api_android.databinding.ActivityMatchBinding

class MatchActivity : AppCompatActivity(), MatchFragment.OnListFragmentInteractionListener{
    override fun onListFragmentInteraction(item: MatchReference) {

    }

    var binding: ActivityMatchBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_match)

        binding!!.btnDisplay.setOnClickListener(View.OnClickListener { v ->
            var name = binding!!.etName.text.toString()
            if (!name.isEmpty()) {
                fragmentMatch(name)
            }
        })
    }

    private fun fragmentMatch(name: String) {
        val fragment = MatchFragment.newInstance(name)
        val args = Bundle()
        args.putString(MatchFragment.ARG_NAME, name)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fl_matches, fragment, MatchFragment.TAG)
                .commit()
    }
}
