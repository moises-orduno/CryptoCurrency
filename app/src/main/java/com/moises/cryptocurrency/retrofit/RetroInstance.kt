package com.moises.cryptocurrency.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{
        val BASE_URL = "https://api.hitbtc.com/api/"
        val BASE_URL_VER = "3/"
        val BASE_URL_PROTECTION = "public/"

        fun getRetroInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL+ BASE_URL_VER+ BASE_URL_PROTECTION)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}