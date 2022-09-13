package com.example.pickacard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PickACardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_acard)

        val cpf: CardPickFragment = (supportFragmentManager.findFragmentById(R.id.cardpickfragment)!! as CardPickFragment)
        cpf.wanted_cards = intent.getIntExtra("cardstype", 0)
    }
}