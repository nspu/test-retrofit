package fr.nspu.riot_api.models

import android.os.Parcel
import android.os.Parcelable

class ErrorResponse : Parcelable {
    lateinit var error: ErrorDetails

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeParcelable(this.error, 0)
    }

    constructor() {}

    protected constructor(parcel: Parcel) {
        this.error = parcel.readParcelable(ErrorDetails::class.java.classLoader)
    }

    companion object {

        val CREATOR: Parcelable.Creator<ErrorResponse> = object : Parcelable.Creator<ErrorResponse> {
            override fun createFromParcel(source: Parcel): ErrorResponse {
                return ErrorResponse(source)
            }

            override fun newArray(size: Int): Array<ErrorResponse?> {
                return arrayOfNulls(size)
            }
        }
    }
}
