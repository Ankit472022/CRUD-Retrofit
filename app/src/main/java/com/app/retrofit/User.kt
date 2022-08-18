package com.app.retrofit

import android.os.Parcel
import android.os.Parcelable

data class User(
    val page: Int,
    val per_page: Int,
    val total: String,
    val total_pages: String,
    val data: List<Data>
)
data class Data(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(email)
        dest.writeString(first_name)
        dest.writeString(last_name)
        dest.writeString(avatar)
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}