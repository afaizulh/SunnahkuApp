package com.faizul.sunnahku.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.faizul.sunnahku.adapter.SunnahkuAdapter
import com.faizul.sunnahku.databinding.FragmentDzikirPagiBinding
import com.faizul.sunnahku.model.DataSunnahku

class DzikirPagiFragment : Fragment() {
    private lateinit var binding: FragmentDzikirPagiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDzikirPagiBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.apply {
            rvDzikirPagi.layoutManager = LinearLayoutManager(context)
            rvDzikirPagi.adapter = SunnahkuAdapter(DataSunnahku.listDzikirPagi(resources))
        }
        return rootView
    }
}