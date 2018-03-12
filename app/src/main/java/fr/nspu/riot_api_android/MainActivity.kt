package fr.nspu.riot_api_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import fr.nspu.riot_api.RiotApi
import fr.nspu.riot_api.models.Champion
import fr.nspu.riot_api.models.ChampionMastery


import kotlinx.android.synthetic.main.activity_main.*
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

class MainActivity : AppCompatActivity() {

//    private lateinit var binding :

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        val riotApi : RiotApi = RiotApi(getString(R.string.riotkey))

        var options : Map<String, String> = hashMapOf("tags" to  "all", "champData" to "all")

        var callback =  object : Callback<ChampionMastery> {
            override fun failure(error: RetrofitError?) {
            }


            override fun success(t: ChampionMastery?, response: Response?) {
            }
        }


        riotApi.championMasteryService.getChampionMasteriesBySummonerByChampion(48509080, 223, callback)
    }

}
