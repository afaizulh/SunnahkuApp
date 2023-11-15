package com.faizul.sunnahku.model

import android.content.res.Resources
import com.faizul.sunnahku.R

object DataSunnahku {
    fun listDoaQouliuyah(resources: Resources): ArrayList<SunnahkuModel> {
        val desc = resources.getStringArray(R.array.arr_desc_qauliyah)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_quliyah)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_quliyah)


        val kumpulan = arrayListOf<SunnahkuModel>()


        for (i in desc.indices) {
            var gabung = SunnahkuModel(
                desc[i],
                lafaz[i],
                terjemah[i]
            )
            kumpulan.addAll(listOf(gabung))
        }
        return kumpulan
    }


    fun listDzikirSetiapSaat(resources: Resources): ArrayList<SunnahkuModel> {
        val desc = resources.getStringArray(R.array.arr_desc_dzikir)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir)


        val kumpulan = arrayListOf<SunnahkuModel>()


        for (i in desc.indices) {
            var gabung = SunnahkuModel(
                desc[i],
                lafaz[i],
                terjemah[i]
            )
            kumpulan.addAll(listOf(gabung))
        }
        return kumpulan
    }


    fun listDzikirHarian(resources: Resources): ArrayList<SunnahkuModel> {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)


        val kumpulan = arrayListOf<SunnahkuModel>()


        for (i in desc.indices) {
            var gabung = SunnahkuModel(
                desc[i],
                lafaz[i],
                terjemah[i]
            )
            kumpulan.addAll(listOf(gabung))
        }
        return kumpulan
    }


    fun listDzikirPagi(resources: Resources): ArrayList<SunnahkuModel> {
        val desc = resources.getStringArray(R.array.arr_desc_dzikir_pagi)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_pagi)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_pagi)


        val kumpulan = arrayListOf<SunnahkuModel>()


        for (i in desc.indices) {
            var gabung = SunnahkuModel(
                desc[i],
                lafaz[i],
                terjemah[i]
            )
            kumpulan.addAll(listOf(gabung))
        }
        return kumpulan
    }


    fun listDzikirPetang(resources: Resources): ArrayList<SunnahkuModel> {
        val desc = resources.getStringArray(R.array.arr_desc_dzikir_petang)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_petang)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_petang)


        val kumpulan = arrayListOf<SunnahkuModel>()


        for (i in desc.indices) {
            var gabung = SunnahkuModel(
                desc[i],
                lafaz[i],
                terjemah[i]
            )
            kumpulan.addAll(listOf(gabung))
        }
        return kumpulan
    }
}