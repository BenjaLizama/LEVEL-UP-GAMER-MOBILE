package com.levelup.level_up_gamer_mobile.data

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class UsuarioRepository(context: Context) {

    private val usuarioDao = LevelUpDataBase.getDatabase(context).usuarioDao()

    suspend fun insertar (usuario: Usuario) {
        withContext(Dispatchers.IO)
        { usuarioDao.insertar(usuario) }
    }
    suspend fun  eliminar (usuario: Usuario) {
        withContext(Dispatchers.IO)
        { usuarioDao.eliminar(usuario) }
    }
    fun obtenerUsuarios() : Flow<List<Usuario>> {
        return usuarioDao.obtenerUsuarios()
    }

}