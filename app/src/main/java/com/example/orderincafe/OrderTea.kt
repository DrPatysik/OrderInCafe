package com.example.orderincafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderTea : AppCompatActivity() {
    private lateinit var radGroupTea:RadioGroup
    private lateinit var radioButLem:RadioButton
    private lateinit var radioButSug:RadioButton
    private lateinit var radioButMilk:RadioButton
    private lateinit var btnOrderTea:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_tea)

        initialisation()
    }
    private fun initialisation(){
        radGroupTea = findViewById(R.id.radGroupTea)
        radioButLem = findViewById(R.id.radioButLem)
        radioButSug = findViewById(R.id.radioButSug)
        radioButMilk = findViewById(R.id.radioButMilk)
        btnOrderTea = findViewById(R.id.btnOrderTea)

        val messageTxtUserName = intent.getStringExtra("sendUserLogin")

        btnOrderTea.setOnClickListener {
            var userOrder: Array<String> = arrayOf()
            val intentChoose = Intent(this, InfoOrder::class.java)

            val radButId = radGroupTea.checkedRadioButtonId
            if (radButId == -1) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.dont_choose),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val radioBut: RadioButton = findViewById(radButId)
                val tea = radioBut.text.toString()
                userOrder += tea
            }

            if (radioButLem.isChecked) {
                val lemon = radioButLem.text.toString()
                if (radioButLem != null) userOrder += "\n" + lemon
            } else {
                radioButLem == null
            }

            if (radioButSug.isChecked) {
                val sugar = radioButSug.text.toString()
                if (radioButSug != null) userOrder += "\n" + sugar
            } else {
                radioButSug == null
            }

            if (radioButMilk.isChecked) {
                val milk = radioButMilk.text.toString()
                if (radioButMilk != null) userOrder += "\n" + milk
            } else {
                radioButMilk == null
            }

            intentChoose.putExtra("userName2", messageTxtUserName)
            if (radButId != -1) intentChoose.putExtra("userOrder2", userOrder)

            startActivity(intentChoose)
        }
    }
}