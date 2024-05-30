package com.example.orderincafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.orderincafe.databinding.ActivityOrderTeaBinding

class OrderTea : AppCompatActivity() {
    /*private lateinit var radGroupTea:RadioGroup
    private lateinit var radioButLem:RadioButton
    private lateinit var radioButSug:RadioButton
    private lateinit var radioButMilk:RadioButton
    private lateinit var btnOrderTea:Button*/
    private lateinit var binding:ActivityOrderTeaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderTeaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialisation()
    }
    private fun initialisation(){
        /*radGroupTea = findViewById(R.id.radGroupTea)
        radioButLem = findViewById(R.id.radioButLem)
        radioButSug = findViewById(R.id.radioButSug)
        radioButMilk = findViewById(R.id.radioButMilk)
        btnOrderTea = findViewById(R.id.btnOrderTea)*/

        binding.btnOrderTea.setOnClickListener {
            var userOrder: Array<String> = arrayOf()

            val radButId = binding.radGroupTea.checkedRadioButtonId
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

            if (binding.radioButLem.isChecked) {
                val lemon = binding.radioButLem.text.toString()
                if (binding.radioButLem != null) userOrder += "\n" + lemon
            }

            if (binding.radioButSug.isChecked) {
                val sugar = binding.radioButSug.text.toString()
                if (binding.radioButSug != null) userOrder += "\n" + sugar
            }

            if (binding.radioButMilk.isChecked) {
                val milk = binding.radioButMilk.text.toString()
                if (binding.radioButMilk != null) userOrder += "\n" + milk
            }

            val messageTxtUserName = intent.getStringExtra("sendUserLogin")
            val intentChoose = Intent(this, InfoOrder::class.java)
            if (radButId != -1){
                intentChoose.putExtra("userOrder2", userOrder)
                intentChoose.putExtra("userName2", messageTxtUserName)
                startActivity(intentChoose) }
        }
    }
}