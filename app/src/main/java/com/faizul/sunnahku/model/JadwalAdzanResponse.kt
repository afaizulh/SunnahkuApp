package com.faizul.sunnahku.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class JadwalAdzanResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("status")
	val status: String
) : Parcelable

@Parcelize
data class Hijri(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("month")
	val month: Month,

	@field:SerializedName("year")
	val year: String,

	@field:SerializedName("format")
	val format: String,

	@field:SerializedName("weekday")
	val weekday: Weekday,

	@field:SerializedName("designation")
	val designation: Designation,

	@field:SerializedName("day")
	val day: String
) : Parcelable


@Parcelize
data class Offset(

	@field:SerializedName("Sunset")
	val sunset: Int,

	@field:SerializedName("Asr")
	val asr: Int,

	@field:SerializedName("Isha")
	val isha: Int,

	@field:SerializedName("Fajr")
	val fajr: Int,

	@field:SerializedName("Dhuhr")
	val dhuhr: Int,

	@field:SerializedName("Maghrib")
	val maghrib: Int,

	@field:SerializedName("Sunrise")
	val sunrise: Int,

	@field:SerializedName("Midnight")
	val midnight: Int,

	@field:SerializedName("Imsak")
	val imsak: Int
) : Parcelable

@Parcelize
data class Params(

	@field:SerializedName("Isha")
	val isha: Int,

	@field:SerializedName("Fajr")
	val fajr: Int
) : Parcelable

@Parcelize
data class Designation(

	@field:SerializedName("expanded")
	val expanded: String,

	@field:SerializedName("abbreviated")
	val abbreviated: String
) : Parcelable

@Parcelize
data class Gregorian(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("month")
	val month: Month,

	@field:SerializedName("year")
	val year: String,

	@field:SerializedName("format")
	val format: String,

	@field:SerializedName("weekday")
	val weekday: Weekday,

	@field:SerializedName("designation")
	val designation: Designation,

	@field:SerializedName("day")
	val day: String
) : Parcelable

@Parcelize
data class Weekday(

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("ar")
	val ar: String
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("date")
	val date: Date,

	@field:SerializedName("meta")
	val meta: Meta,

	@field:SerializedName("timings")
	val timings: Timings
) : Parcelable

@Parcelize
data class Timings(

	@field:SerializedName("Sunset")
	val sunset: String,

	@field:SerializedName("Asr")
	val asr: String,

	@field:SerializedName("Isha")
	val isha: String,

	@field:SerializedName("Fajr")
	val fajr: String,

	@field:SerializedName("Dhuhr")
	val dhuhr: String,

	@field:SerializedName("Maghrib")
	val maghrib: String,

	@field:SerializedName("Lastthird")
	val lastthird: String,

	@field:SerializedName("Firstthird")
	val firstthird: String,

	@field:SerializedName("Sunrise")
	val sunrise: String,

	@field:SerializedName("Midnight")
	val midnight: String,

	@field:SerializedName("Imsak")
	val imsak: String
) : Parcelable

@Parcelize
data class Date(

	@field:SerializedName("readable")
	val readable: String,

	@field:SerializedName("hijri")
	val hijri: Hijri,

	@field:SerializedName("gregorian")
	val gregorian: Gregorian,

	@field:SerializedName("timestamp")
	val timestamp: String
) : Parcelable

@Parcelize
data class Method(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("params")
	val params: Params
) : Parcelable

@Parcelize
data class Meta(

	@field:SerializedName("method")
	val method: Method,

	@field:SerializedName("offset")
	val offset: Offset,

	@field:SerializedName("school")
	val school: String,

	@field:SerializedName("timezone")
	val timezone: String,

	@field:SerializedName("midnightMode")
	val midnightMode: String,

	@field:SerializedName("latitudeAdjustmentMethod")
	val latitudeAdjustmentMethod: String
) : Parcelable

@Parcelize
data class Month(

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("ar")
	val ar: String
) : Parcelable
