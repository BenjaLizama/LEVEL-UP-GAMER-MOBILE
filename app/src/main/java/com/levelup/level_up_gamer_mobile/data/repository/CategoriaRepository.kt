package com.levelup.level_up_gamer_mobile.data.repository

import android.content.Context
import com.levelup.level_up_gamer_mobile.data.LevelUpDataBase
import com.levelup.level_up_gamer_mobile.data.model.Categoria
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CategoriaRepository(context: Context) {
    private val categoriaDao = LevelUpDataBase.Companion.getDatabase(context).categoriaDao()

    suspend fun insertar(categoria: Categoria) {
        withContext(Dispatchers.IO)
        { categoriaDao.insertar(categoria) }
    }

    suspend fun eliminar(categoria: Categoria) {
        withContext(Dispatchers.IO)
        { categoriaDao.eliminar(categoria) }
    }

    suspend fun obtenerTodas(): Flow<List<Categoria>> {
        return categoriaDao.obtenerTodas()


    }

}