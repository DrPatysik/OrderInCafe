package com.example.orderincafe

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InfoOrder : AppCompatActivity() {

    private lateinit var txtViewOrder :TextView
    private lateinit var txtVInfo:TextView
    private lateinit var txtWaitOrder:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_order)

        txtViewOrder = findViewById(R.id.txtVOrder)
        txtVInfo = findViewById(R.id.txtVInfo)
        txtWaitOrder = findViewById(R.id.textViewWait)

        val name = intent.getStringExtra("sendUserName")
        txtVInfo.text = name + "," + getString(R.string.your_order)

        val cof = intent.getStringExtra("coffee")
        var ice = intent.getStringExtra("ice")
        var syr = intent.getStringExtra("syrup")

        //??? тут пыталась избавиться от надписи null, если не выбираю лед или сироп
        if (ice == null){
            ice = ""
            txtViewOrder.text = cof + "\n" + syr + ice
        }
        if (syr == null){
            syr = ""
            txtViewOrder.text = cof + "\n" + ice + "\n"+ syr
        }
        else{
            txtViewOrder.text = cof + "\n" + ice + "\n"+ syr
        }





    }
}