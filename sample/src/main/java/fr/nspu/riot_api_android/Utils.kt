package fr.nspu.riot_api_android

import android.databinding.BindingAdapter
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_matchitem.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by nspu on 14/03/18.
 */
fun Date.toSimpleString() : String {
    val format = SimpleDateFormat("dd/MM/yyy HH:mm:ss")
    return format.format(this)
}

@BindingAdapter("date")
fun timestampToDate(view: View, timestamp: Long) {
    (view as TextView).text = Date(timestamp).toSimpleString()
}
