package com.example.pickacard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.viewpager2.widget.ViewPager2
import com.example.pickacard.databinding.ActivityMainBinding
import com.google.android.material.internal.ContextUtils.getActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        //var currenthand = HandFactory.generateHand(this, binding, 3)



    }
}