package com.example.appagendarv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var contact = ArrayList<Contact>()

    //creamos el adapter
    var contactAdapter = com.example.appagendarv.ContactAdapter(contact)

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
        contact.add(Contact("Luisa", "123456"))
        contact.add(Contact("Yovana", "663456"))
        contact.add(Contact("Yadira", "883456"))
        contact.add(Contact("Nayruth", "999456"))
    }
}