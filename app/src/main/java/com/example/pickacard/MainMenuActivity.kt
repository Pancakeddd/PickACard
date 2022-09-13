package com.example.pickacard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        findViewById<Button>(R.id.onecardreading).setOnClickListener {

            val intent = Intent(this, PickACardActivity::class.java)
            intent.putExtra("cardstype", 1)

            startActivity(intent)
        }

        findViewById<Button>(R.id.threecardreading).setOnClickListener {

            val intent = Intent(this, PickACardActivity::class.java)
            intent.putExtra("cardstype", 3)

            startActivity(intent)
        }

        findViewById<Button>(R.id.threedailycards).setOnClickListener {

            val intent = Intent(this, PickACardActivity::class.java)
            intent.putExtra("cardstype", 3)

            startActivity(intent)
        }
    }
}