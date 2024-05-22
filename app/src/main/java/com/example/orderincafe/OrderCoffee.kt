package com.example.orderincafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderCoffee : AppCompatActivity() {
    
    private lateinit var radGroupCoffee:RadioGroup
    private lateinit var radButIce:RadioButton
    private lateinit var radButSyrup:RadioButton
    private lateinit var btnOrderCoffee:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_coffee)

        radGroupCoffee = findViewById(R.id.radGroupCoffee)
        radButIce = findViewById(R.id.radioButtonIce)
        radButSyrup = findViewById(R.id.radioButtonSyrup)
        btnOrderCoffee = findViewById(R.id.buttonOrderCoffee)

        val msgTxtUserLogin = intent.getStringExtra("sendUserName")



        btnOrderCoffee.setOnClickListener {
           val intentChoose = Intent(this, InfoOrder::class.java)

            val radButId = radGroupCoffee.checkedRadioButtonId
            if (radButId == -1) {
                Toast.makeText(applicationContext,getString(R.string.dont_choose),Toast.LENGTH_LONG).show()
            }
            else {
                val radioBut: RadioButton = findViewById(radButId)
                val coffee = radioBut.text.toString()
                intentChoose.putExtra("coffee", coffee)
                intentChoose.putExtra("sendUserName", msgTxtUserLogin)

            }

            // не нашла другого способа выбора,точнее нашла,но почему-то не срабатывал
            if (radButIce.isChecked ) {
                val ice = radButIce.text.toString()
                intentChoose.putExtra("ice", ice)
            }

            if (radButSyrup.isChecked){
                val syrup = radButSyrup.text.toString()
                intentChoose.putExtra("syrup",syrup)
            }
            startActivity(intentChoose)
        }
    }
}