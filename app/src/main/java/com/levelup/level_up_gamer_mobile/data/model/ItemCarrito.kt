package com.levelup.level_up_gamer_mobile.data.model

import androidx.room.Entity

@Entity(tableName = "tabla_carrito", primaryKeys = ["idUsuario", "idProducto"])
data class ItemCarrito(
    val idUsuario: Long,
    val idProducto: Long,
    val precio: Double,
    val cantidad: Int = 1,
)