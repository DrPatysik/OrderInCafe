package com.example.orderincafe

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.orderincafe.databinding.ActivityDrinkSelectionBinding

class DrinkSelection : AppCompatActivity() {
    /*private lateinit var editTxtWelcome:TextView
    private lateinit var btnTea:ImageButton
    private lateinit var btnCoffee:ImageButton*/
    private lateinit var binding: ActivityDrinkSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrinkSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialisation()
    }
    private fun initialisation(){
        /*editTxtWelcome = findViewById(R.id.editTxtWelcome)
        btnTea = findViewById(R.id.btnTea)
        btnCoffee = findViewById(R.id.btnCoffee)*/

        val msgUserLogin = intent.getStringExtra("sendUserName")
        binding.editTxtWelcome.text = getString(R.string.welcome) + msgUserLogin + getString(R.string.point)

        binding.btnTea.setOnClickListener {
            val intent1 = Intent(this,OrderTea::class.java)
            intent1.putExtra("sendUserLogin", msgUserLogin)

            startActivity(intent1)
        }

        binding.btnCoffee.setOnClickListener {
            val intent2 = Intent(this,OrderCoffee::class.java)
            intent2.putExtra("sendUserLogin", msgUserLogin)

            startActivity(intent2)
        }
    }
}