package com.levelup.level_up_gamer_mobile.data.repository

import android.annotation.SuppressLint
import com.levelup.level_up_gamer_mobile.data.dao.CarritoDao
import com.levelup.level_up_gamer_mobile.data.model.ItemCarrito
import com.levelup.level_up_gamer_mobile.data.model.Producto

class ItemCarritoRepository(private val carritoDao: CarritoDao) {


    suspend fun agregarAlCarrito(producto: Producto, idUsuario: Long) {

        val itemEnBd = carritoDao.obtenerItemDeUsuario(idUsuario, producto.id)
        //si no existe el item, lo agregamos
        if (itemEnBd == null) {
            val nuevoItem = ItemCarrito(
                idUsuario = idUsuario,
                idProducto = producto.id,
                precio = producto.price,
                cantidad = 1
            )
            carritoDao.agregarItem(nuevoItem)
        } else { //si existe, lo actualizamos
            val itemActualizado = itemEnBd.copy(cantidad = itemEnBd.cantidad + 1)
            carritoDao.actualizarItem(itemActualizado)
        }
    }

    suspend fun restarDelCarrito(producto: Producto, idUsuario: Long) {

        val itemEnBd = carritoDao.obtenerItemDeUsuario(idUsuario, producto.id)
        if (itemEnBd != null) {

            if (itemEnBd.cantidad > 1) {
                val itemActualizado = itemEnBd.copy(cantidad = itemEnBd.cantidad - 1)
                carritoDao.actualizarItem(itemActualizado)
            } else {
                carritoDao.eliminarItem(itemEnBd)
            }
        }

    }

    suspend fun eliminarItem(item: ItemCarrito) {
        carritoDao.eliminarItem(item)
    }

    suspend fun obtenerItemsDeUsuario(idUsuario: Long): List<ItemCarrito> {
        return carritoDao.obtenerItemsDeUsuario(idUsuario)

    }

}

