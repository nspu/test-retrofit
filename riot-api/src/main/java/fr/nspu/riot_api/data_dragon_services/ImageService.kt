package fr.nspu.riot_api.data_dragon_services

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator


/**
 * Created by nspu on 16/03/18.
 */
class ImageService(var uri: String, var version: String, private val mContext: Context) {

    private fun getProfileIconUri(profileIconId: Int) = "$uri/cdn/$version/img/profileicon/$profileIconId.png"
    private fun getSplashArtUri(nameChampion: String, skinNum: Int) = "$uri/cdn/img/champion/splash/${nameChampion}_$skinNum.jpg"
    private fun getLoadingScreenArtUri(nameChampion: String, skinNum: Int) = "$uri/cdn/img/champion/loading/${nameChampion}_$skinNum.jpg"
    private fun getChampionSquareUri(nameChampion: String) = "$uri/cdn/$version/img/champion/$nameChampion.png"
    private fun getPassiveAbilityUri(nameImage: String) = "$uri/cdn/$version/img/passive/$nameImage"
    private fun getChampionAbilityUri(nameImage: String) = "$uri/cdn/$version/img/spell/$nameImage"
    private fun getSummonerSpellUri(nameImage: String) = "$uri/cdn/$version/img/spell/$nameImage"
    private fun getItemUri(itemId: Int) = "$uri/cdn/$version/img/item/$itemId.png"
    private fun getMasteryUri(masteryId: String) = "$uri/cdn/$version/img/mastery/$masteryId.png"
    private fun getRuneUri(nameImage: String) = "$uri/cdn/$version/img/rune/$nameImage"
    private fun getSpriteUri(imageName: String) = "$uri/cdn/$version/img/sprite/$imageName"
    private fun getMapUri(mapId: Int) = "$uri/cdn/$version/img/map/map$mapId.png"

    /**
     * Profile icon
     */
    fun getProfileIcon(profileIconId: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getProfileIconUri(profileIconId), options)
    }

    fun getProfileIcon(profileIconId: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getProfileIconUri(profileIconId), view, options)
    }

    fun getProfileIcon(profileIconId: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getProfileIconUri(profileIconId), callback, options)
    }

    /**
     * SplashArt
     */
    fun getSplashArt(nameChampion: String, skinNum: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getSplashArtUri(nameChampion, skinNum), options)
    }

    fun getSplashArt(nameChampion: String, skinNum: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getSplashArtUri(nameChampion, skinNum), view, options)
    }

    fun getSplashArt(nameChampion: String, skinNum: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getSplashArtUri(nameChampion, skinNum), callback, options)
    }

    /**
     * Loading screen art
     */
    fun getLoadingScreenArt(nameChampion: String, skinNum: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getLoadingScreenArtUri(nameChampion, skinNum), options)
    }

    fun getLoadingScreenArt(nameChampion: String, skinNum: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getLoadingScreenArtUri(nameChampion, skinNum), view, options)
    }

    fun getLoadingScreenArt(nameChampion: String, skinNum: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getLoadingScreenArtUri(nameChampion, skinNum), callback, options)
    }

    /**
     * Champion Square
     */
    fun getChampionSquare(nameChampion: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getChampionSquareUri(nameChampion), options)
    }


    fun getChampionSquare(nameChampion: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getChampionSquareUri(nameChampion), view, options)
    }

    fun getChampionSquare(nameChampion: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getChampionSquareUri(nameChampion), callback, options)
    }

    /**
     * Passive Abilities
     */
    fun getPassiveAbility(nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getPassiveAbilityUri(nameImage), options)
    }

    fun getPassiveAbility(nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getPassiveAbilityUri(nameImage), view, options)
    }

    fun getPassiveAbility(nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getPassiveAbilityUri(nameImage), callback, options)
    }

    /**
     * Champion Abilities
     */
    fun getChampionAbility(nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getChampionAbilityUri(nameImage), options)
    }


    fun getChampionAbility(nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getChampionAbilityUri(nameImage), view, options)
    }

    fun getChampionAbility(nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getChampionAbilityUri(nameImage), callback, options)
    }


    /**
     * Summoner Spells
     */
    fun getSummonerSpell(nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getSummonerSpellUri(nameImage), options)
    }

    fun getSummonerSpell(nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getSummonerSpellUri(nameImage), view, options)
    }

    fun getSummonerSpell(nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getSummonerSpellUri(nameImage), callback, options)
    }


    /**
     * Items
     */
    fun getItem(itemId: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getItemUri(itemId), options)
    }

    fun getItem(itemId: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getItemUri(itemId), view, options)
    }

    fun getItem(itemId: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getItemUri(itemId), callback, options)
    }

    /**
     * Masteries
     */
    fun getMastery(masteryId: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getMasteryUri(masteryId), options)
    }

    fun getMastery(masteryId: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getMasteryUri(masteryId), view, options)
    }

    fun getMastery(masteryId: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getMasteryUri(masteryId), callback, options)
    }

    /**
     * Rune
     */
    fun getRune(nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getRuneUri(nameImage), options)
    }

    fun getRune(nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getRuneUri(nameImage), view, options)
    }

    fun getRune(nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getRuneUri(nameImage), callback, options)
    }

    /**
     * Sprites
     */
    fun getSprite(nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getSpriteUri(nameImage), options)
    }

    fun getSprite(nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getSpriteUri(nameImage), view, options)
    }

    fun getSprite(nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getSpriteUri(nameImage), callback, options)
    }

    /**
     * Maps
     */
    fun getMap(mapId: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getMapUri(mapId), options)
    }

    fun getMap(mapId: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getMapUri(mapId), view, options)
    }

    fun getMap(mapId: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getMapUri(mapId), callback, options)
    }

    /**
     * Generic
     */
    private fun getImage(uri: String, options: Map<String, Any>? = null): Bitmap {
        return initPicasso(uri, options).get()
    }

    private fun getImage(uri: String, view: ImageView, options: Map<String, Any>? = null) {
        initPicasso(uri, options).into(view)
    }

    private fun getImage(uri: String, callback: Callback, options: Map<String, Any>? = null) {
        initPicasso(uri, options).fetch(callback)
    }

    private fun initPicasso(uri: String, options: Map<String, Any>? = null): RequestCreator {
        var picasso = Picasso.get()
        picasso.setIndicatorsEnabled(true)
        var requestCreator: RequestCreator = picasso.load(uri)
        config(options, requestCreator)
        return requestCreator
    }

    private fun config(options: Map<String, Any>?, requestCreator: RequestCreator) {
        if (options == null) return

        if (options!!.containsKey("resize")) {
            resize(options["resite"], requestCreator)
        }

        if (options!!.containsKey("center-crop")) {
            centerCrop(options["center-crop"], requestCreator)
        }

        if (options!!.containsKey("fit")) {
            fit(options["fit"], requestCreator)
        }
    }

    private fun fit(optionFit: Any?, requestCreator: RequestCreator) {
        if (optionFit is Boolean) {
            if (optionFit) {
                requestCreator.fit()
            }
        } else {
            Throwable("Fit value need to be a Boolean")
        }
    }

    private fun centerCrop(optionCenterCrop: Any?, requestCreator: RequestCreator) {
        if (optionCenterCrop is Boolean) {
            if (optionCenterCrop) {
                requestCreator.centerCrop()
            }
        } else if (optionCenterCrop is Int) {
            requestCreator.centerCrop(optionCenterCrop)
        } else {
            Throwable("Center crop value need to be a Boolean")
        }
    }

    private fun resize(optionResite: Any?, requestCreator: RequestCreator) {
        if (optionResite is Pair<*, *>) {
            if (optionResite.first is Int && optionResite.second is Int) {
                requestCreator.resize(optionResite.first as Int, optionResite.second as Int)
            } else {
                Throwable("Value in Pair need to bo a Integer")
            }
        } else {
            Throwable("Resize value need to be a Pair")
        }
    }
}