package com.example.orderincafe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.orderincafe.databinding.ActivityInfoOrderBinding

class InfoOrder : AppCompatActivity() {
    /*private lateinit var txtViewOrder: TextView
    private lateinit var txtVInfo: TextView
    private lateinit var txtWaitOrder: TextView*/
    private lateinit var binding: ActivityInfoOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*txtViewOrder = findViewById(R.id.txtVOrder)
        txtVInfo = findViewById(R.id.txtVInfo)
        txtWaitOrder = findViewById(R.id.txtWaitOrder)*/

        if (intent.getStringExtra("userName2") != null) initTeaOrder()
        if (intent.getStringExtra("userName") != null) initCoffeeOrder()
    }

    private fun initCoffeeOrder() {
        val name = intent.getStringExtra("userName")
        binding.txtVInfo.text = name + "," + getString(R.string.your_order)

        val orderCoffee = intent.getStringArrayExtra("userOrder")
        for (i in 0 until orderCoffee!!.size) {
            binding.txtVOrder.append(orderCoffee[i])
        }
    }

    private fun initTeaOrder() {
        val name2 = intent.getStringExtra("userName2")
        binding.txtVInfo.text = name2 + "," + getString(R.string.your_order)

        val orderTea = intent.getStringArrayExtra("userOrder2")
        for (l in 0 until orderTea!!.size) {
            binding.txtVOrder.append(orderTea[l])
        }
    }
}