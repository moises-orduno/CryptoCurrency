package com.moises.cryptocurrency.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moises.cryptocurrency.model.CurrencyListModelBTC
import com.moises.cryptocurrency.model.CurrencyListModelETH
import com.moises.cryptocurrency.retrofit.RetroInstance
import com.moises.cryptocurrency.retrofit.RetroServiceInterface
import com.moises.cryptocurrency.ui.fragment.CryptoListFragment.Companion.BTC_CURRENCY
import com.moises.cryptocurrency.ui.fragment.CryptoListFragment.Companion.ETH_CURRENCY
import kotlinx.coroutines.*

class CurrencyListViewModel : ViewModel() {

    var job: Job? = null
    var eTHCurrencyLiveData: MutableLiveData<CurrencyListModelETH> = MutableLiveData()
    var bTCCurrencyLiveData: MutableLiveData<CurrencyListModelBTC> = MutableLiveData()

    val retroInstance = RetroInstance.getRetroInstance()
    val retroService = retroInstance.create(RetroServiceInterface::class.java)

    fun getETHLiveDataObserver(): MutableLiveData<CurrencyListModelETH> {
        return eTHCurrencyLiveData
    }

    fun getBTCLiveDataObserver(): MutableLiveData<CurrencyListModelBTC> {
        return bTCCurrencyLiveData
    }

    /**
     * Gets the current {@code value} price converted to Ethereum.
     *
     * @param value    value to be converted from
     */
    fun getEthConvertedToValue(value: String) {

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = retroService.getEthCurrentExchangePrice(ETH_CURRENCY, value)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                        eTHCurrencyLiveData.postValue(response.body())

                }
            }
        }
    }

    /**
     * Gets the current {@code value} price converted to Bitcoin.
     *
     * @param value    value to be converted from
     */
    fun getBtcConvertedToValue(value: String) {

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = retroService.getBtcCurrentExchangePrice(BTC_CURRENCY, value)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    bTCCurrencyLiveData.postValue(response.body())

                }
            }
        }
    }
}