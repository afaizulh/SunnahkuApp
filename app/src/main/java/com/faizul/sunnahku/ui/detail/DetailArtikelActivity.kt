package com.faizul.sunnahku.ui.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.faizul.sunnahku.databinding.ActivityDetailArtikelBinding

class DetailArtikelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailArtikelBinding

    companion object {
        const val DETAIL_TITLE = "detail_title"
        const val DETAIL_DESC = "detail_description"
        const val DETAIL_IMAGE = "detail_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#AC0D0D")))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra(DETAIL_TITLE)
        val description = intent.getStringExtra(DETAIL_DESC)
        val image = intent.getIntExtra(DETAIL_IMAGE, 0)

        binding.apply {
            tvDetailTitle.text = title
            tvDetailDesc.text = description

            Glide.with(this@DetailArtikelActivity)
                .load(image)
                .into(imgDetail)
        }

        supportActionBar?.title = binding.tvDetailTitle.text
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}