package com.moises.cryptocurrency.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyListModelETH(
    @SerializedName("ETH")
    @Expose
    val currencyModel: CurrencyModel
)