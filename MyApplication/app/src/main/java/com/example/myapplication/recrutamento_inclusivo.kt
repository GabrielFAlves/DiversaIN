package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class recrutamento_inclusivo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recrutamento_inclusivo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageView3: ImageView = findViewById(R.id.imageView3)
        imageView3.setOnClickListener {
            val intent = Intent(this, TelaUser::class.java)
            startActivity(intent)
        }
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2.setOnClickListener {
            val intent = Intent(this, servicosDiversain::class.java)
            startActivity(intent)
        }
    }
}