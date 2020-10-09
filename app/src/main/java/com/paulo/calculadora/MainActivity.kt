package com.paulo.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var toll = intent.getStringExtra("Toolbar").toString()

        if (toll == "null") {
            toolbar.setTitle("Calculadora")
        }else {
            (toolbar.setTitle(toll))
        }


        btnBolso.setOnClickListener(){
            val intent = Intent(this, BolsoActivity::class.java)
            intent.putExtra("Toolbar", toll)
            startActivity(intent)
        }

        btnDesconto.setOnClickListener(){
            val intent = Intent(this, DescontoActivity::class.java)
            intent.putExtra("Toolbar", toll)
            startActivity(intent)
        }

        btnTemp.setOnClickListener(){
            val intent = Intent(this, ConversaoActivity::class.java)
            intent.putExtra("Toolbar", toll)
            startActivity(intent)
        }

        btnPersonalizar.setOnClickListener(){
            val intent = Intent(this, PersonalizarActivity::class.java)
            intent.putExtra("Toolbar", toll)
            startActivity(intent)
        }


    }
}