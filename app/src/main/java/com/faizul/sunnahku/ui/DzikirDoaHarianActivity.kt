package com.faizul.sunnahku.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.faizul.sunnahku.adapter.SunnahkuAdapter
import com.faizul.sunnahku.databinding.ActivityDzikirDoaHarianBinding
import com.faizul.sunnahku.model.DataSunnahku

class DzikirDoaHarianActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDzikirDoaHarianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirDoaHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#AC0D0D")))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir & Doa Harian"

        binding.apply {
            rvQauliyahShalat.layoutManager = LinearLayoutManager(this@DzikirDoaHarianActivity)
            rvQauliyahShalat.adapter = SunnahkuAdapter(DataSunnahku.listDzikirHarian(resources))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}