package com.moises.cryptocurrency.repository

import com.moises.cryptocurrency.retrofit.RetroServiceInterface

class CurrencyRepository constructor(private val retrofitService: RetroServiceInterface) {

    suspend fun getCurrencyByName(from: String, to: String) =
        retrofitService.getEthCurrentExchangePrice(from, to)

}