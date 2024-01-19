package com.example.splashscrrenrequestexample.ApiUtil

import android.os.Parcel
import android.os.Parcelable

data class Products(
    val id: Int,
    val title: String,
    val category: String,
    val image: String,
    val price: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(category)
        parcel.writeString(image)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Products> {
        override fun createFromParcel(parcel: Parcel): Products {
            return Products(parcel)
        }

        override fun newArray(size: Int): Array<Products?> {
            return arrayOfNulls(size)
        }
    }
}
