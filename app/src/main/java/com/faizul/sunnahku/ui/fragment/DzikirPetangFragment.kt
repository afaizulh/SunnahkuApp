package com.faizul.sunnahku.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.faizul.sunnahku.adapter.SunnahkuAdapter
import com.faizul.sunnahku.databinding.FragmentDzikirPetangBinding
import com.faizul.sunnahku.model.DataSunnahku

class DzikirPetangFragment : Fragment() {
    private lateinit var binding: FragmentDzikirPetangBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentDzikirPetangBinding.inflate(inflater, container, false)
            val rootView = binding.root

            binding.apply {
            rvDzikirPetang.layoutManager = LinearLayoutManager(context)
            rvDzikirPetang.adapter = SunnahkuAdapter(DataSunnahku.listDzikirPetang(resources))
            }
            return rootView
    }
}