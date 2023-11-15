package com.faizul.sunnahku.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.faizul.sunnahku.repository.JadwalAdzanRepository
import com.faizul.sunnahku.ui.JadwalSholatVewModel

class JadwalSholatViewModelFactory(private val repository: JadwalAdzanRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(JadwalSholatVewModel::class.java)) {
           return JadwalSholatVewModel(repository) as T
       }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
