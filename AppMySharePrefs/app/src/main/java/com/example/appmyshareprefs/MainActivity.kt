package com.example.appmyshareprefs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference = SharedPreference(this)

        val btSave = findViewById<Button>(R.id.btSave)
        val etUsuario = findViewById<TextInputEditText>(R.id.etUsuario)
        val btRetrieve = findViewById<Button>(R.id.btRetrieve)
        val tvRetrieve = findViewById<TextView>(R.id.tvRetrieve)

        btSave.setOnClickListener {
            val name = etUsuario.text.toString()
            sharedPreference.save("name", name)

            Toast.makeText(this, "Usuario almacenado", Toast.LENGTH_LONG).show()
        }

        btRetrieve.setOnClickListener {
            if (sharedPreference.getValue("name") != null){
                tvRetrieve.setText(sharedPreference.getValue("name"))
            }

            Toast.makeText(this, "Info recuperada", Toast.LENGTH_LONG).show()
        }
    }
}