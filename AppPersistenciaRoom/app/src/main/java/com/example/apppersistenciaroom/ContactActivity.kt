package com.example.apppersistenciaroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson

class ContactActivity : AppCompatActivity() {

    lateinit var contact: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        loadContact()
    }

    private fun loadContact() {
        val gson = Gson()
        val stringObj = intent.getStringExtra("contact")

        contact = gson.fromJson(stringObj, User::class.java)
            ?: User(null, "", "")

        if (contact.id != null){
            val valor_name = findViewById<TextInputEditText>(R.id.etName)
            val valor_telephone = findViewById<TextInputEditText>(R.id.etTelephone)

            valor_name.setText(contact.name)
            valor_telephone.setText(contact.telephone)
        }
    }

    fun saveContact(){
        val valor_name = findViewById<TextInputEditText>(R.id.etName)
        val valor_telephone = findViewById<TextInputEditText>(R.id.etTelephone)

        var name = valor_name.text.toString()
        var telephone = valor_telephone.text.toString()

        contact.name = name
        contact.telephone = telephone

        //ojo
        //contact = User(null, name, telephone)

        if (contact.id == null){
            //q es un registro NUEVO
            AppDatabase.getInstance(this).getDao().insertContact(contact)
        }
        else{
            AppDatabase.getInstance(this).getDao().updateContact(contact)
        }

        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.contact_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemSave ->{
                saveContact()
                true
            }

            R.id.itemDelete ->{
                deleteContact()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteContact() {
        AppDatabase.getInstance(this).getDao().deleteContact(contact)
        finish()
    }
}