package com.example.orderincafe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTxtUserName:EditText
    private lateinit var btnRegistration:Button
    private lateinit var eTxtNumPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTxtUserName = findViewById(R.id.userLogin)
        btnRegistration = findViewById(R.id.buttonRegistration)
        eTxtNumPassword = findViewById(R.id.userNumberPassword)

        btnRegistration.setOnClickListener {

            val strUserName = editTxtUserName.text.toString().uppercase()
            val txtLength = strUserName.trim().length

            val lengthUserPassword = eTxtNumPassword.text.toString().trim().length

            if (txtLength == 0 ){
                editTxtUserName.setHint(R.string.errorInLogin).toString()
            }
            if (lengthUserPassword == 3 && txtLength > 0) {
                val intent = Intent(this, DrinkSelection::class.java)
                intent.putExtra("sendUserName", strUserName)

                startActivity(intent)
            }
        }
    }
}