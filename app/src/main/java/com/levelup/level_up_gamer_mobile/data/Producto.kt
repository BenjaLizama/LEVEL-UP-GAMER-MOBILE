package com.levelup.level_up_gamer_mobile.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TABLA_PRODUCTOS")
data class Producto(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val description: String,
    val imagePath: String



)