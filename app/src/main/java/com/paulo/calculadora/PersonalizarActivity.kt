package com.paulo.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_personalizar.*

class PersonalizarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalizar)

        var toll = intent.getStringExtra("Toolbar").toString()

        if (toll == "null") {
            toolbar.setTitle("Calculadora")
        }else {
            (toolbar.setTitle(toll))
        }


        btnConfirmar.setOnClickListener() {
            toll = edTxtAlterar.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Toolbar", toll)
            startActivity(intent)
        }


    }

}