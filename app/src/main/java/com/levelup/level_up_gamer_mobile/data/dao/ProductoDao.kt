package com.levelup.level_up_gamer_mobile.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.levelup.level_up_gamer_mobile.data.model.Producto

import kotlinx.coroutines.flow.Flow

@Dao
interface ProductoDao {

    @Insert
     suspend fun insertar(producto: Producto)

    @Update
     suspend fun actualizar(producto: Producto)

    @Delete
     suspend fun eliminar(producto: Producto)

    @Query("SELECT * FROM tabla_producto ORDER BY id DESC")
    fun obtenerProductos(): Flow<List<Producto>>

    @Query("SELECT * FROM tabla_producto WHERE id = :id")
    suspend fun obtenerProductoPorId(id: Int): Producto?

}