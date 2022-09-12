package com.example.pickacard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PickACardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_acard)

        if (intent.getStringExtra("cardstype") == "threecards")
        {
            val cpf: CardPickFragment = (supportFragmentManager.findFragmentById(R.id.cardpickfragment)!! as CardPickFragment)
            cpf.wanted_cards = 3
        }
    }
}