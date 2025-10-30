package com.levelup.level_up_gamer_mobile.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.levelup.level_up_gamer_mobile.data.Pojo.CategoriaWithProducto
import com.levelup.level_up_gamer_mobile.data.model.Categoria
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriaDao {

    @Insert
    suspend fun insertar(categoria: Categoria)

    @Delete
    suspend fun eliminar(categoria: Categoria)

    @Query("SELECT * FROM tabla_categoria")
    fun obtenerTodas(): Flow<List<Categoria>>

    @Transaction
    @Query("SELECT * FROM tabla_categoria WHERE id = :id")
    fun obtenerCategoriaConProducto(id: Long): CategoriaWithProducto


}