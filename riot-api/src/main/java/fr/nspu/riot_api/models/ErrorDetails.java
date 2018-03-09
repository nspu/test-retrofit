package fr.nspu.riot_api.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <a href="https://developer.riotgames.com/response-codes.html">Error api</a>
 */
public class ErrorDetails implements Parcelable {
    public int status;
    public String message;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.status);
        dest.writeString(this.message);
    }

    public ErrorDetails() {
    }

    protected ErrorDetails(Parcel in) {
        this.status = in.readInt();
        this.message = in.readString();
    }

    public static final Creator<ErrorDetails> CREATOR = new Creator<ErrorDetails>() {
        public ErrorDetails createFromParcel(Parcel source) {
            return new ErrorDetails(source);
        }

        public ErrorDetails[] newArray(int size) {
            return new ErrorDetails[size];
        }
    };
}
