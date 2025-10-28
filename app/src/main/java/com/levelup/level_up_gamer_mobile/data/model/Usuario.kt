package com.levelup.level_up_gamer_mobile.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_usuario")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val name: String,
    val lastName: String,
    val password: String,
    val email: String



)