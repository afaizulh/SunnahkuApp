package com.faizul.sunnahku.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.faizul.sunnahku.databinding.ActivityJadwalSholatBinding
import com.faizul.sunnahku.repository.JadwalAdzanRepository
import com.faizul.sunnahku.utils.JadwalSholatViewModelFactory
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class JadwalSholatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJadwalSholatBinding
    private lateinit var viewModel: JadwalSholatVewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJadwalSholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up ViewModel
        val repository = JadwalAdzanRepository()
        val factory = JadwalSholatViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[JadwalSholatVewModel::class.java]

        val date = getCurrentDateTime()
        val dateInString = date.toString("EEEE, dd/MM/yyyy")

        binding.tvTanggal.text = dateInString

        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    // gasss
                    val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    dispatchJadwalShalatCall(locationManager)
                } else -> {
                    // loh kok kagak mau
                    Toast.makeText(this, "Jadwal shalat will not work unless you provide the permission to access your approximate location", Toast.LENGTH_LONG).show();
                }
            }
        }

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionRequest.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION))
        } else {
            val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            dispatchJadwalShalatCall(locationManager)
        }

        // Observer untuk update UI
        viewModel.jadwalAdzan.observe(this) { jadwalAdzanResponse ->
            if (jadwalAdzanResponse == null) {
                Log.w("JadwalSholatActivity", "Loh kok ilang");
            }
            jadwalAdzanResponse?.let { response ->
                response.data.firstOrNull()?.let { data ->
                    // Perbarui tampilan dengan data jadwalSholatResponse
                    binding.apply {
                        tvWaktuImsak.text = data.timings.imsak
                        tvWaktuSubuh.text = data.timings.fajr
                        tvWaktuDhuha.text = data.timings.dhuhr
                        tvWaktuZuhur.text = data.timings.dhuhr
                        tvWaktuAshar.text = data.timings.asr
                        tvWaktuMaghrib.text = data.timings.maghrib
                        tvWaktuIsya.text = data.timings.isha
                    }
                }
            }
        }
    }

    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    private fun dispatchJadwalShalatCall(locationManager: LocationManager) {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return;
        }

        val location = when {
            Build.VERSION.SDK_INT >= 31 -> locationManager.getLastKnownLocation(LocationManager.FUSED_PROVIDER)
            else -> locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        }

        if (location == null) {
            Toast.makeText(this, "takde lokasi lah", Toast.LENGTH_LONG).show();
        } else {
            viewModel.getJadwalAdzan(
                year = 2023,
                month = 11,
                latitude = location.latitude,
                longitude = location.longitude
            )
        }
    }
}

