package fr.nspu.riot_api_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import fr.nspu.riot_api.RiotApi
import fr.nspu.riot_api.models.Champion


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

        var callback =  object : Callback<Champion> {
            override fun failure(error: RetrofitError?) {
                Log.e("aa", "")
            }


            override fun success(t: Champion?, response: Response?) {
                Log.e("aa", "")
            }
        }


        riotApi.service.getChampion(62, options, callback)
    }

}
