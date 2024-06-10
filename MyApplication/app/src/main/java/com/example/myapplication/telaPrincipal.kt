package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class telaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        val imageButton: ImageButton = findViewById(R.id.imageButton)

        // Configure o OnClickListener
        imageButton.setOnClickListener {
            // Crie um Intent para iniciar a TelaUser
            val intent = Intent(this, TelaUser::class.java)
            startActivity(intent)
        }
    }
}