package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nspu on 13/03/18.
 */
data class Message(
        private var severity: String? = null,
        private var author: String? = null,
        private var created_at: String? = null,
        private var translations: List<Translation>? = null,
        private var updated_at: String? = null,
        private var content: String? = null,
        var id: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.createTypedArrayList(Translation.CREATOR),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(severity)
        writeString(author)
        writeString(created_at)
        writeTypedList(translations)
        writeString(updated_at)
        writeString(content)
        writeString(id)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Message> = object : Parcelable.Creator<Message> {
            override fun createFromParcel(source: Parcel): Message = Message(source)
            override fun newArray(size: Int): Array<Message?> = arrayOfNulls(size)
        }
    }
}