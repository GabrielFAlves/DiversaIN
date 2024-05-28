package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class formLogin : AppCompatActivity() {

    private lateinit var text_tela_cadastro: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        IniciarComponentes()

        text_tela_cadastro.setOnClickListener {
            val intent = Intent(this, FormCadastroU::class.java)
            startActivity(intent)
        }
    }

    private fun IniciarComponentes() {
        text_tela_cadastro = findViewById(R.id.text_cadastro)
    }
}