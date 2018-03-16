package fr.nspu.riot_api_android

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView

import com.squareup.picasso.Picasso

/**
 * Created by nspu on 02/03/18.
 */

object BindingAdapters {
    @BindingAdapter("playPause")
    fun changeImagePlayPause(view: View, isPlaying: Boolean) {
        val btn = view as ImageButton
        if (isPlaying) {
            btn.setImageResource(android.R.drawable.ic_media_pause)
        } else {
            btn.setImageResource(android.R.drawable.ic_media_play)
        }
    }

    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageUrl: String) {
        Picasso.with(view.context)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder).error(R.color.background_floating_material_dark)
                .into(view)
    }
}