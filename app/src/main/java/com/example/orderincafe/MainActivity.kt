package com.example.orderincafe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.orderincafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    /*private lateinit var editTxtUserName:EditText
    private lateinit var btnRegistration:Button
    private lateinit var eTxtNumPassword:EditText*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialisation()
    }
    private fun initialisation(){
        /*editTxtUserName = findViewById(R.id.editTxtUserName)
        btnRegistration = findViewById(R.id.btnRegistration)
        eTxtNumPassword = findViewById(R.id.eTxtNumPassword)*/

        binding.btnRegistration.setOnClickListener {

            val strUserName = binding.editTxtUserName.text.toString().uppercase()
            val txtLength = strUserName.trim().length

            val lengthUserPassword = binding.eTxtNumPassword.text.toString().trim().length

            if (txtLength == 0 ){
                binding.editTxtUserName.setHint(R.string.errorInLogin).toString()
            }
            if (lengthUserPassword == 3 && txtLength > 0) {
                val intent = Intent(this, DrinkSelection::class.java)
                intent.putExtra("sendUserName", strUserName)

                startActivity(intent)
            }
        }
    }
}