package com.moises.cryptocurrency.ui.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.moises.cryptocurrency.databinding.FragmentCryptoListBinding
import com.moises.cryptocurrency.viewmodel.CurrencyListViewModel

/**
 * A fragment representing a list of Items.
 */
class CryptoListFragment : Fragment() {

    private var _binding: FragmentCryptoListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CurrencyListViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        initViewModel()

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[CurrencyListViewModel::class.java]

        viewModel.getETHLiveDataObserver().observe(this) {
            if (it != null) {
                binding.tvPriceEth.text = it.currencyModel.price
                binding.tvLastDateEth.text = it.currencyModel.timestamp
            }
        }

        viewModel.getBTCLiveDataObserver().observe(this) {
            if (it != null) {
                binding.tvPriceBtc.text = it.currencyModel.price
                binding.tvLastDateBtc.text = it.currencyModel.timestamp
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCryptoListBinding.inflate(inflater, container, false)

        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {
                viewModel.getEthConvertedToValue(USDT_CURRENCY)
                viewModel.getBtcConvertedToValue(USDT_CURRENCY)

                // Call api every 30 seconds
                mainHandler.postDelayed(this, DELAYED_SECONDS)
            }
        })

        return binding.root
    }

    companion object {

        const val ETH_CURRENCY = "ETH"
        const val BTC_CURRENCY = "BTC"
        const val USDT_CURRENCY = "USDT"
        const val DELAYED_SECONDS = 30000L

        @JvmStatic
        fun newInstance() =
            CryptoListFragment().apply {

            }
    }
}