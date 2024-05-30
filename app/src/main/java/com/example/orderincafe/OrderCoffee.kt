package com.example.orderincafe

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderCoffee : AppCompatActivity() {

    private lateinit var radGroupCoffee: RadioGroup
    private lateinit var radButIce: RadioButton
    private lateinit var radButSyrup: RadioButton
    private lateinit var btnOrderCoffee: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_coffee)

        initialisation()
    }
    private fun initialisation(){
        radGroupCoffee = findViewById(R.id.radGroupCoffee)
        radButIce = findViewById(R.id.radioButtonIce)
        radButSyrup = findViewById(R.id.radioButtonSyrup)
        btnOrderCoffee = findViewById(R.id.buttonOrderCoffee)

        val messageTxtUserName = intent.getStringExtra("sendUserLogin")

        btnOrderCoffee.setOnClickListener {
            var userOrder: Array<String> = arrayOf()

            val radButId = radGroupCoffee.checkedRadioButtonId
            if (radButId == -1) {
                val toast = Toast.makeText(applicationContext, getString(R.string.dont_choose), Toast.LENGTH_LONG)
                    toast.show()
            } else {
                val radioBut: RadioButton = findViewById(radButId)
                val coffee = radioBut.text.toString()
                userOrder += coffee
            }

            if (radButIce.isChecked) {
                val ice = radButIce.text.toString()
                if (radButIce != null) userOrder += "\n" + ice
            } else {
                radButIce == null
            }

            if (radButSyrup.isChecked) {
                val syrup = radButSyrup.text.toString()
                if (radButSyrup != null) userOrder += "\n" + syrup
            } else {
                radButSyrup == null
            }

            val intentChoose = Intent(this, InfoOrder::class.java)
            if (radButId != -1){
                intentChoose.putExtra("userOrder", userOrder)
                intentChoose.putExtra("userName", messageTxtUserName)
                startActivity(intentChoose) }
        }
    }
}