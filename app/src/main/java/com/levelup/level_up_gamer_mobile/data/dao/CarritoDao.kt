package com.levelup.level_up_gamer_mobile.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.levelup.level_up_gamer_mobile.data.model.ItemCarrito

@Dao
interface CarritoDao {

    @Insert
    suspend fun agregarItem(itemCarrito: ItemCarrito)

    @Delete
    suspend fun eliminarItem(itemCarrito: ItemCarrito)

    @Update
    suspend fun actualizarItem(itemCarrito: ItemCarrito)

    //buscar productos que sean de el usuario en especifico (un producto)
    @Query("SELECT * FROM tabla_carrito where idUsuario=:idUsuario and idProducto =:idProducto")
    suspend fun obtenerItemDeUsuario(idUsuario: Long, idProducto: Long): ItemCarrito?

    //buscar todos los productos que sean de un usuario en especifico
    @Query("SELECT * FROM tabla_carrito where idUsuario=:idUsuario")
    suspend fun obtenerItemsDeUsuario(idUsuario: Long): List<ItemCarrito>


}