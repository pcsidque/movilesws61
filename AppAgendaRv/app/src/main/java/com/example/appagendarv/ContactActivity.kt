package com.example.appagendarv

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.textfield.TextInputEditText

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.contact_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        saveContact()
        return super.onOptionsItemSelected(item)
    }

    private fun saveContact() {
        val name = findViewById<TextInputEditText>(R.id.etName)
        val telephone = findViewById<TextInputEditText>(R.id.etTelephone)

        val namefin = name.text.toString()
        val telephonefin = telephone.text.toString()

        val intent = Intent()

        intent.putExtra("keyName", namefin)
        intent.putExtra("keyTelephone", telephonefin)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}