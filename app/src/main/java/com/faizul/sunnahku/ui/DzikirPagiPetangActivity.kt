package com.faizul.sunnahku.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faizul.sunnahku.adapter.DzikirPagiPetangAdapter
import com.faizul.sunnahku.databinding.ActivityDzikirPagiPetangBinding
import com.google.android.material.tabs.TabLayoutMediator

class DzikirPagiPetangActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDzikirPagiPetangBinding
    private lateinit var dzikirPagiPetangAdapter: DzikirPagiPetangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPagiPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#AC0D0D")))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Pagi & Petang"


        dzikirPagiPetangAdapter = DzikirPagiPetangAdapter(supportFragmentManager, lifecycle)

        with(binding){
            vpDzikirPagiPetang.adapter = dzikirPagiPetangAdapter
            TabLayoutMediator(tlDzikirPagiPetang, vpDzikirPagiPetang) { tab, position ->
                when (position) {
                    0 -> tab.text = "Dzikir Pagi"
                    1 -> tab.text = "Dzikir Petang"
                }
            }.attach()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}