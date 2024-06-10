package com.example.certificacion.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "generic")
data class Generic(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val first_name: String = "",
    val last_name: String = "",
    val email: String = "",
    val password: String = ""
)