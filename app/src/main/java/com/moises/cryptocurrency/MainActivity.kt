package com.moises.cryptocurrency

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moises.cryptocurrency.databinding.ActivityMainBinding
import com.moises.cryptocurrency.ui.fragment.CryptoListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val CryptoListFragment = CryptoListFragment.newInstance()


        val fragmentTransaction = supportFragmentManager.
        beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,CryptoListFragment,"CryptoListFragment").commit()
    }
}