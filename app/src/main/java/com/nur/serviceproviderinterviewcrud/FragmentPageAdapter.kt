package com.nur.serviceproviderinterviewcrud

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nur.serviceproviderinterviewcrud.view.FirstFragment
import com.nur.serviceproviderinterviewcrud.view.SecondFragment

class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
    ):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return  2
    }

    override fun createFragment(position: Int): Fragment {
        if(position==0)
            return  FirstFragment()
        else return SecondFragment()
    }
}