package com.paulo.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_conversao.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class ConversaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversao)

        var toll = intent.getStringExtra("Toolbar").toString()

        if (toll == "null") {
            toolbar.setTitle("Calculadora")
        }else {
            (toolbar.setTitle(toll))
        }

        btnConverter.setOnClickListener(){
            if (edTxtCelsius.text.isNotEmpty()){
                var celsius = edTxtCelsius.text.toString().toDouble()
                var fahre = (celsius * 1.8) + 32
                edTxtFahre.setText(fahre.toString())
            }else if (edTxtFahre.text.isNotEmpty()) {
                var fahre = edTxtFahre.text.toString().toDouble()
                var celsius = (fahre - 32) / 1.8
                edTxtCelsius.setText(celsius.toString())
            }
        }
        btnLimpar.setOnClickListener(){
            edTxtFahre.setText("")
            edTxtCelsius.setText("")
        }
    }
}