package fr.nspu.sample_data_dragon

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nspu.riot_api.DataDragonApi
import android.preference.PreferenceManager
import android.content.SharedPreferences
import fr.nspu.riot_api.models.ChampionData
import fr.nspu.riot_api.models.ChampionListData
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response


/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
