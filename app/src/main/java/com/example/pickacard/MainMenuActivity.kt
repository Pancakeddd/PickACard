package com.example.pickacard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var cards_3 = findViewById<Button>(R.id.threecardreading)

        cards_3.setOnClickListener {

            val intent = Intent(this, PickACardActivity::class.java)
            intent.putExtra("cardstype", "threecards")

            startActivity(intent)
        }
    }
}