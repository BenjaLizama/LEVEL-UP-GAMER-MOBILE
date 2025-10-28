package com.levelup.level_up_gamer_mobile.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TABLA_USUARIO")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val name: String,
    val lastName: String,
    val password: String,
    val email: String



)