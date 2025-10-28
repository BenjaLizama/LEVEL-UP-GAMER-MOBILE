package com.levelup.level_up_gamer_mobile.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Dao
interface ProductoDao {

    @Insert
     suspend fun insertar(producto: Producto)

    @Update
     suspend fun actualizar(producto: Producto)

    @Delete
     suspend fun eliminar(producto: Producto)

    @Query("SELECT * FROM TABLA_PRODUCTOS ORDER BY id DESC")
    fun obtenerProductos(): Flow<List<Producto>>

    @Query("SELECT * FROM TABLA_PRODUCTOS WHERE id = :id")
    suspend fun obtenerProductoPorId(id: Int): Producto?

}