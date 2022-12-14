package com.app.retrofit
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("users?per_page=20")
    fun getUsers() : Call<User>

    companion object
    {
        var BASE_URL = "https://reqres.in/api/"
        fun create() : ApiInterface
        {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}