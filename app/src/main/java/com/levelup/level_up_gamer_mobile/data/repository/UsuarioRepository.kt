package com.levelup.level_up_gamer_mobile.data.repository

import com.levelup.level_up_gamer_mobile.data.dao.UsuarioDao
import com.levelup.level_up_gamer_mobile.data.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class UsuarioRepository(private val usuarioDao: UsuarioDao) {




    suspend fun agragarUsuario(name: String,lastname: String, email: String, password: String){
        val nuevoUsuario = Usuario(0, name, lastname, password, email)
        usuarioDao.insertar(nuevoUsuario)
    }
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
    suspend fun obtenerUsuario(name: String) : Flow<Usuario> {
        return usuarioDao.obtenerUsuario(name)
    }

}