package com.example.apppersistenciaroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText

class ContactActivity : AppCompatActivity() {

    lateinit var contact: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }

    fun saveContact(){
        val valor_name = findViewById<TextInputEditText>(R.id.etName)
        val valor_telephone = findViewById<TextInputEditText>(R.id.etTelephone)

        val name = valor_name.text.toString()
        val telephone = valor_telephone.text.toString()

        contact = User(null, name, telephone)
    }
}