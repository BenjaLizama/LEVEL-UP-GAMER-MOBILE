package com.levelup.level_up_gamer_mobile.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_categoria")
data class Categoria(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombreCategoria: String
)