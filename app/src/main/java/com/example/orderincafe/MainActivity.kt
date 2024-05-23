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

        //TODO fun initialisation() we need
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
                val intentName = Intent(this,InfoOrder::class.java)
                intent.putExtra("sendUserName", strUserName)
                intentName.putExtra("sendUserName", strUserName)
                //??? через arrayIntent не срабатывает,кидает в последнюю активити
                val arrayIntent = arrayOf(intent,intentName)

                startActivities(arrayIntent)

                //??? пыталась через Bundle,никак
               /* val bundleName = Bundle()
                bundleName.putString("sendUserName",strUserName)
                val intentName = Intent(this,InfoOrder::class.java)
                intentName.putExtra("Bundle",bundleName)*/
            }
        }
    }
}