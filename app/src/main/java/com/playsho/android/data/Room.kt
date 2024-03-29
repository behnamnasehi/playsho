package com.playsho.android.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("tag")
    @Expose
    val tag: String = "",

    @SerializedName("stream_link")
    @Expose
    var streamLink: String? = "",

    @SerializedName("status")
    @Expose
    val status: String? = "",

    @SerializedName("room_key")
    @Expose
    var roomKey: String? = "",

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Room

        return tag == other.tag
        // Check other properties similarly
        // return true if all properties are equal

    }

    override fun hashCode(): Int {
        return tag.hashCode()
    }
}
