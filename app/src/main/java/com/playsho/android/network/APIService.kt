package com.playsho.android.network

import com.playsho.android.config.Conf
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @POST(Conf.Path.V1_DEVICE_GENERATE)
    fun generateDevice(@Body body: RequestBody): Call<Response>

    @POST(Conf.Path.V1_ROOM_CREATE)
    fun createRoom(): Call<Response>

    @POST(Conf.Path.V1_DEVICE_NAME)
    fun updateName(@Body body: RequestBody): Call<Response>

    @POST(Conf.Path.V1_DEVICE_KEYPAIR_REGENERATE)
    fun regenerateDeviceKeypair(@Body body: RequestBody): Call<Response>

    @GET(Conf.Path.V1_ROOM_GET)
    fun getRoom(
        @Path("tag") tag: String
    ): Call<Response>

    @GET(Conf.Path.V1_ROOM_ENTRANCE)
    fun checkEntrance(
        @Path("tag") tag: String
    ): Call<Response>

    @POST(Conf.Path.V1_ROOM_LINK)
    fun addLink(
        @Path("tag") tag: String,
        @Body body: RequestBody
    ): Call<Response>

}
