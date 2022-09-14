package com.example.appagendarv

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var contacts = ArrayList<Contact>()
    val REQUEST_CODE = 1

    //creamos el adapter
    var contactAdapter = com.example.appagendarv.ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()
    }

    private fun initView() {
        val rvContact = findViewById<RecyclerView>(R.id.rvContact)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)

    }

    private fun loadContacts() {
        contacts.add(Contact("Luisa", "123456"))
        contacts.add(Contact("Yovana", "663456"))
        contacts.add(Contact("Yadira", "883456"))
        contacts.add(Contact("Nayruth", "999456"))
    }

    //"infla" el menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true
    }

    //dar la accion
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, ContactActivity::class.java)
        //startActivity(intent)
        startActivityForResult(intent, REQUEST_CODE)

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                val name = data!!.getStringExtra("keyName")
                val telephone = data!!.getStringExtra("keyTelephone")
                val contact = Contact(name, telephone)

                contacts.add(contact)
            }
        }
    }
}