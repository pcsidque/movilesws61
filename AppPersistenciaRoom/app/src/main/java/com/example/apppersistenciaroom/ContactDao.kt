package com.example.apppersistenciaroom

import androidx.room.*

//Aqui hago el CRUD
@Dao
interface ContactDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Insert
    fun insertContact(vararg contacts: User)

    @Delete
    fun deleteContact(vararg contacts: User)

    @Update
    fun updateContact(vararg contacts: User)
}