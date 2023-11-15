package com.faizul.sunnahku

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.faizul.sunnahku.adapter.ArtikelAdapter
import com.faizul.sunnahku.databinding.ActivityMainBinding
import com.faizul.sunnahku.model.ArtikelModel
import com.faizul.sunnahku.ui.DzikirDoaHarianActivity
import com.faizul.sunnahku.ui.DzikirPagiPetangActivity
import com.faizul.sunnahku.ui.DzikirSetiapSaatActivity
import com.faizul.sunnahku.ui.JadwalSholatActivity
import com.faizul.sunnahku.ui.SunnahQauliyahActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var slideIndicator: Array<ImageView?>

    private val listArtikel: ArrayList<ArtikelModel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                slideIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }
            slideIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)

        setDataArtikel()
        setUpViewPagerArtikel()
        setViewArtikel()
    }

    private fun setViewArtikel() {
//       SetUp View Artikel
        binding.apply {
//            Set Adapter for ViewPager
            vpArtikel.adapter = ArtikelAdapter(listArtikel)
//            Register the OnPageChangeCallback
            vpArtikel.registerOnPageChangeCallback(slidingCallback)
//
            cardFeaturesApp1.setOnClickListener(this@MainActivity)
            cardFeaturesApp2.setOnClickListener(this@MainActivity)
            cardFeaturesApp3.setOnClickListener(this@MainActivity)
            cardFeaturesApp4.setOnClickListener(this@MainActivity)
            cardFeaturesApp5.setOnClickListener(this@MainActivity)
        }
    }

    private fun setDataArtikel() {
        // bagian artikel
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)


        for (data in titleArtikel.indices) {
            val artikel = ArtikelModel(
                imgArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
    }

    private fun setUpViewPagerArtikel() {
        val llSliderDots = binding.dotsArtikel

        slideIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            slideIndicator[i] = ImageView(this)
            slideIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )

            // Menentukan lebar dan tinggi indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // Mengatur jarak antar indicator
            params.setMargins(9, 0, 8, 0)
            // Mengatur posisi indicator
            params.gravity = Gravity.CENTER_VERTICAL
            // Menerapkan params sebagai aturan bagaimana indicator ditampilkan
            llSliderDots.addView(slideIndicator[i], params)
        }

        slideIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_active
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.card_features_app_1 -> {
                val intentDPP = Intent(this@MainActivity, DzikirPagiPetangActivity::class.java)
                startActivity(intentDPP)
            }
            R.id.card_features_app_2 -> {
                val intentDSS = Intent(this@MainActivity, DzikirSetiapSaatActivity::class.java)
                startActivity(intentDSS)
            }
            R.id.card_features_app_3 -> {
                val intentSQ = Intent(this@MainActivity, SunnahQauliyahActivity::class.java)
                startActivity(intentSQ)
            }
            R.id.card_features_app_4 -> {
                val intentDDH = Intent(this@MainActivity, DzikirDoaHarianActivity::class.java)
                startActivity(intentDDH)
            }
            R.id.card_features_app_5 -> {
                val intentJS = Intent(this@MainActivity, JadwalSholatActivity::class.java)
                startActivity(intentJS)
            }
        }
    }
}