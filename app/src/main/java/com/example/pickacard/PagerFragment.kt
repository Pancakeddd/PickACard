package com.example.pickacard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class PagerFragment() : Fragment() {
    private lateinit var cardPagerAdapter: CardPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments = activity?.intent?.extras
        cardPagerAdapter = CardPagerAdapter(this, arguments)
        return inflater.inflate(R.layout.hand_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewPager = view.findViewById(R.id.viewpager)
        viewPager.adapter = cardPagerAdapter
    }

}