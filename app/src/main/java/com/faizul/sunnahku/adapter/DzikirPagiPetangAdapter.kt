package com.faizul.sunnahku.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.faizul.sunnahku.ui.fragment.DzikirPagiFragment
import com.faizul.sunnahku.ui.fragment.DzikirPetangFragment

class DzikirPagiPetangAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0){
            DzikirPagiFragment()
        } else {
            DzikirPetangFragment()
        }
    }
}