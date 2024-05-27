package com.example.orderincafe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoOrder : AppCompatActivity() {

    private lateinit var txtViewOrder: TextView
    private lateinit var txtVInfo: TextView
    private lateinit var txtWaitOrder: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_order)

        txtViewOrder = findViewById(R.id.txtVOrder)
        txtVInfo = findViewById(R.id.txtVInfo)
        txtWaitOrder = findViewById(R.id.txtWaitOrder)

        if (intent.getStringExtra("userName2") != null) initTeaOrder()
        if (intent.getStringExtra("userName") != null) initCoffeeOrder()
    }

    private fun initCoffeeOrder() {
        val name = intent.getStringExtra("userName")
        txtVInfo.text = name + "," + getString(R.string.your_order)

        val orderCoffee = intent.getStringArrayExtra("userOrder")
        for (i in 0 until orderCoffee!!.size) {
            txtViewOrder.append(orderCoffee[i])
        }
    }

    private fun initTeaOrder() {
        val name2 = intent.getStringExtra("userName2")
        txtVInfo.text = name2 + "," + getString(R.string.your_order)

        val orderTea = intent.getStringArrayExtra("userOrder2")
        for (l in 0 until orderTea!!.size) {
            txtViewOrder.append(orderTea[l])
            println()
        }
    }
}