package com.paulo.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_bolso.*
import kotlinx.android.synthetic.main.activity_bolso.toolbar
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class BolsoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bolso)


        var toll = intent.getStringExtra("Toolbar").toString()

        if (toll == "null") {
            toolbar.setTitle("Calculadora")
        }else {
            (toolbar.setTitle(toll))
        }

        tvZero.setOnClickListener(){
            expressao("0",true)}
        tvUm.setOnClickListener(){
            expressao("1",true)}
        tvDois.setOnClickListener(){
            expressao("2",true)}
        tvTres.setOnClickListener(){
            expressao("3",true)}
        tvQuatro.setOnClickListener(){
            expressao("4",true)}
        tvCinco.setOnClickListener(){
            expressao("5",true)}
        tvSeis.setOnClickListener(){
            expressao("6",true)}
        tvSete.setOnClickListener(){
            expressao("7",true)}
        tvOito.setOnClickListener(){
            expressao("8",true)}
        tvNove.setOnClickListener(){
            expressao("9",true)}
        tvPonto.setOnClickListener(){
            expressao(".",true)}

        tvDivisao.setOnClickListener(){
            expressao("/",true)}
        tvMulti.setOnClickListener(){
            expressao("*",true)}
        tvMenos.setOnClickListener(){
            expressao("-",true)}
        tvMais.setOnClickListener(){
            expressao("+",true)}

        tvApagar.setOnClickListener(){
            expressao("DEL",true)
            tvResultado.text = ""
            tvExpressao.text = ""
        }

        tvIgual.setOnClickListener(){
            try {

                val expressao = ExpressionBuilder(tvExpressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val resultadoLong = resultado.toLong()
                if (resultado == resultadoLong.toDouble())
                    tvResultado.text = resultadoLong.toString()
                else
                    tvResultado.text = resultado.toString()

            }catch (e: Exception){
                Log.d("Exception"," message : "+ e.message)
            }
        }
    }



    fun expressao(String: String, apres : Boolean){

        if (tvResultado.text.isNotEmpty()){
            tvExpressao.text = ""
        }
        if(apres){
            tvResultado.text = ""
            tvExpressao.append(String)
        }else{
            tvExpressao.append(tvResultado.text)
            tvExpressao.append(String)
            tvResultado.text = ""
        }
    }
}