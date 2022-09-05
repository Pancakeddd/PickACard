package com.example.pickacard

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.*

class CardPagerAdapter(fragment: Fragment, val extras: Bundle?) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return CardFragmentFactory.newInstance(extras?.getString((position).toString()))
    }

}