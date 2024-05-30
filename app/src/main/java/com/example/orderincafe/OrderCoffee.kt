package com.example.orderincafe

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.orderincafe.databinding.ActivityOrderCoffeeBinding

class OrderCoffee : AppCompatActivity() {
    private lateinit var binding: ActivityOrderCoffeeBinding
    /*private lateinit var radGroupCoffee: RadioGroup
    private lateinit var radButIce: RadioButton
    private lateinit var radButSyrup: RadioButton
    private lateinit var btnOrderCoffee: Button*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderCoffeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialisation()
    }
    private fun initialisation(){
        /*radGroupCoffee = findViewById(R.id.radGroupCoffee)
        radButIce = findViewById(R.id.radioButtonIce)
        radButSyrup = findViewById(R.id.radioButtonSyrup)
        btnOrderCoffee = findViewById(R.id.buttonOrderCoffee)*/

        binding.buttonOrderCoffee.setOnClickListener {
            var userOrder: Array<String> = arrayOf()

            val radButId = binding.radGroupCoffee.checkedRadioButtonId
            if (radButId == -1) {
                Toast.makeText(applicationContext, getString(R.string.dont_choose), Toast.LENGTH_LONG).show()
            } else {
                val radioBut: RadioButton = findViewById(radButId)
                val coffee = radioBut.text.toString()
                userOrder += coffee
            }

            if (binding.radioButtonIce.isChecked) {
                val ice = binding.radioButtonIce.text.toString()
                if (binding.radioButtonIce != null) userOrder += "\n" + ice
            }

            if (binding.radioButtonSyrup.isChecked) {
                val syrup = binding.radioButtonSyrup.text.toString()
                if (binding.radioButtonSyrup != null) userOrder += "\n" + syrup
            }

            val messageTxtUserName = intent.getStringExtra("sendUserLogin")
            val intentChoose = Intent(this, InfoOrder::class.java)
            if (radButId != -1){
                intentChoose.putExtra("userOrder", userOrder)
                intentChoose.putExtra("userName", messageTxtUserName)
                startActivity(intentChoose) }
        }
    }
}