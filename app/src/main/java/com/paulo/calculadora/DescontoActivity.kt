package com.paulo.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_desconto.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class DescontoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desconto)

        var toll = intent.getStringExtra("Toolbar").toString()

        if (toll == "null") {
            toolbar.setTitle("Calculadora")
        }else {
            (toolbar.setTitle(toll))
        }

        btnCalcular.setOnClickListener(){
            if (edTxtPreco.text.isNotEmpty()){
                if (edTxtDesconto.text.isNotEmpty() && edTxtDesconto.text.toString().toDouble() <= 100){
                    var preco = edTxtPreco.text.toString().toDouble()
                    var desconto = edTxtDesconto.text.toString().toDouble()
                    var res = preco * (desconto/100)
                    tvValorFinal.text = "R$ " +(preco - res)
                    tvResultado.text = "Voçê obteve um desconto de R$ $res"
                }
            }
        }
        btnLimpar.setOnClickListener(){
            tvValorFinal.text = ""
            tvResultado.text = ""
            edTxtPreco.setText("")
            edTxtDesconto.setText("")
        }
    }
}