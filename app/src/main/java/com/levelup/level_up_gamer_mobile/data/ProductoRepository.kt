package com.levelup.level_up_gamer_mobile.data

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ProductoRepository(context: Context) {

    // Obtenemos la referencia al DAO desde el Singleton de la BD
    // CORRECCIÓN 1: getDatabase (d minúscula)
    // CORRECCIÓN 2: .productoDao() (p minúscula)
    private val productoDao = LevelUpDataBase.getDatabase(context).productDao()

    // FUNCIÓN PARA INSERTAR (INSERT)
    suspend fun insertar(producto: Producto) {
        withContext(Dispatchers.IO) {
            productoDao.insertar(producto)
        }
    }
    suspend fun eliminar(producto: Producto) {
        withContext(Dispatchers.IO) {
            productoDao.eliminar(producto)
        }}


    // FUNCIÓN PARA OBTENER TODOS (SELECT)
    fun obtenerTodosLosProductos(): Flow<List<Producto>> {
        return productoDao.obtenerProductos()
    }
}
