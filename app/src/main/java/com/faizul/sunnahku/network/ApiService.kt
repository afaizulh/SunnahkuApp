package com.faizul.sunnahku.network

import com.faizul.sunnahku.model.JadwalAdzanResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("calendar/{year}/{month}")
    fun getCalendar(
        @Path("year") year: Int,
        @Path("month") month: Int,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
    ): Call<JadwalAdzanResponse>
}