package com.faizul.sunnahku.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.faizul.sunnahku.adapter.SunnahkuAdapter
import com.faizul.sunnahku.model.DataSunnahku
import com.faizul.sunnahku.databinding.ActivitySunnahQauliyahBinding

class SunnahQauliyahActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySunnahQauliyahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySunnahQauliyahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#AC0D0D")))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Sunnah Qauliyah"

        binding.apply {
            rvQauliyahShalat.layoutManager = LinearLayoutManager(this@SunnahQauliyahActivity)
            rvQauliyahShalat.adapter = SunnahkuAdapter(DataSunnahku.listDoaQouliuyah(resources))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}