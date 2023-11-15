package com.faizul.sunnahku.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.faizul.sunnahku.model.JadwalAdzanResponse
import com.faizul.sunnahku.repository.JadwalAdzanRepository

class JadwalSholatVewModel(private val repository: JadwalAdzanRepository) : ViewModel() {
    val jadwalAdzan: LiveData<JadwalAdzanResponse> = repository.jadwalAdzan

    fun getJadwalAdzan(year: Int, month: Int, latitude: Double, longitude: Double) {
        repository.getJadwalAdzan(year, month, latitude, longitude)
    }
}