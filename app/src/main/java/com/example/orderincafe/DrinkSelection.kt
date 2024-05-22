package com.example.orderincafe

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DrinkSelection : AppCompatActivity() {
    private lateinit var editTxtWelcome:TextView
    private lateinit var btnTea:ImageButton
    private lateinit var btnCoffee:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_selection)

        editTxtWelcome = findViewById(R.id.textWelcome)
        btnTea = findViewById(R.id.imageButtonTea)
        btnCoffee = findViewById(R.id.imageButtonCoffee)


        val msgTxtUserLogin = intent.getStringExtra("sendUserName")
        editTxtWelcome.text = getString(R.string.welcome) + msgTxtUserLogin + getString(R.string.point)



        btnTea.setOnClickListener {
            val intent1 = Intent(this,OrderTea::class.java)
            intent1.putExtra("sendUserName", msgTxtUserLogin)

            startActivity(intent1)
        }

        btnCoffee.setOnClickListener {
            val intent2 = Intent(this,OrderCoffee::class.java)
            intent2.putExtra("sendUserName", msgTxtUserLogin)

            startActivity(intent2)
        }

    }
}