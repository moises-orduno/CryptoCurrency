package com.moises.cryptocurrency.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyListModelBTC(
    @SerializedName("BTC")
    @Expose
    val currencyModel: CurrencyModel
)