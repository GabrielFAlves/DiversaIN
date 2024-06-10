package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class telaPrincipal : AppCompatActivity() {

    private lateinit var nomeUser: TextView
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        IniciarComponentes()

        val imageButton: ImageButton = findViewById(R.id.imageButton)

        // Configure o OnClickListener
        imageButton.setOnClickListener {
            // Crie um Intent para iniciar a TelaUser
            val intent = Intent(this, TelaUser::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        // Obtém o email do usuário atual logado
        val email = FirebaseAuth.getInstance().currentUser?.email
        // Obtém o ID do usuário atual logado
        val usuarioID = FirebaseAuth.getInstance().currentUser?.uid ?: return

        // Referência ao documento do usuário no Firestore
        val documentReference = FirebaseFirestore.getInstance().collection("Usuarios").document(usuarioID)
        documentReference.addSnapshotListener { snapshot, e ->
            if (e != null) {
                // Trate o erro caso ocorra
                Log.w("FirestoreError", "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                // Atualiza os campos de texto com os dados do snapshot
                nomeUser.setText(snapshot.getString("nome"))
            } else {
                Log.d("Firestore", "Current data: null")
            }
        }
    }

    private fun IniciarComponentes(){
        nomeUser = findViewById(R.id.textView)
    }
}