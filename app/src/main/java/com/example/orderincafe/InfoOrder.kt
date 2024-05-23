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

        //TODO fun initialisation() we need
        txtViewOrder = findViewById(R.id.txtVOrder)
        txtVInfo = findViewById(R.id.txtVInfo)
        txtWaitOrder = findViewById(R.id.textViewWait)

       //тут пыталась распаковать Bundle
        /* val bundleName = intent.getBundleExtra("Bundle")
        val bundleNameRes = bundleName?.getString("sendUserName")
        // val msgTxtUserLogin2 = intent.getStringExtra("sendUserName")
        txtVInfo.text = bundleNameRes.toString()
        //+ "," + getString(R.string.your_order)*/

         //??? имя дошло,но просто перепрыгнуло в данную активити
        //FIXME no name through DrinkSelection!
        val name = intent.getStringExtra("sendUserName")
        txtVInfo.text = name.toString()


        val cof = intent.getStringExtra("coffee")
        var ice = intent.getStringExtra("ice")
        var syr = intent.getStringExtra("syrup")

        //??? тут пыталась избавиться от надписи null, если не выбираю лед или сироп
        //FIXME null checking where we accumulate information
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