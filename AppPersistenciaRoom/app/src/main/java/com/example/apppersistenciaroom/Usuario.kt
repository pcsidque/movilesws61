package com.example.apppersistenciaroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val telephone: String
    )