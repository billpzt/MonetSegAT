package com.infnet.devandroidat

import android.R
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.infnet.devandroidat.databinding.ActivityMainBinding
import com.infnet.devandroidat.main.ui.MainViewModel


class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>()

    private lateinit var bindingActivity: ActivityMainBinding
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = ActivityMainBinding.inflate(layoutInflater)

        viewModel.nome.observe(this) {
            bindingActivity.tvBemVindo.text = it
        }
        setContentView(bindingActivity.root)

        bindingActivity.btnSair.setOnClickListener {
            viewModel.logout()
            finishAffinity()
        }

        MobileAds.initialize(this) {}
        mAdView = bindingActivity.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }
}