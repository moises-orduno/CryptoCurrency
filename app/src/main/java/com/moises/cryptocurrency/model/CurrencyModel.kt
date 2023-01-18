package com.moises.cryptocurrency.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyModel(
    @SerializedName("currency")
    @Expose
    val currency: String?,
    @SerializedName("price")
    @Expose
    val price: String?,
    @SerializedName("timestamp")
    @Expose
    val timestamp: String?
)
