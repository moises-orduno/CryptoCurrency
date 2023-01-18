package com.moises.cryptocurrency.retrofit

import com.moises.cryptocurrency.model.CurrencyListModelBTC
import com.moises.cryptocurrency.model.CurrencyListModelETH
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    companion object{
        const val PRICE_RATE_URL = "price/rate"
    }

    @GET(PRICE_RATE_URL)
    suspend fun getEthCurrentExchangePrice(@Query("from") from:String,
                                           @Query("to") to: String,
    ): Response<CurrencyListModelETH>

    @GET(PRICE_RATE_URL)
    suspend fun getBtcCurrentExchangePrice(@Query("from") from:String,
                                           @Query("to") to: String,
    ): Response<CurrencyListModelBTC>

}