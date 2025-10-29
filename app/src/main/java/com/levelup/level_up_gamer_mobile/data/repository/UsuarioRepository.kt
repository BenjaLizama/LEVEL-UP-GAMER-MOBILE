package com.levelup.level_up_gamer_mobile.data.repository

import com.levelup.level_up_gamer_mobile.data.dao.UsuarioDao
import com.levelup.level_up_gamer_mobile.data.model.Usuario
import com.levelup.level_up_gamer_mobile.utils.PasswordHasher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class UsuarioRepository(private val usuarioDao: UsuarioDao) {



    suspend fun agragarUsuario(name: String, lastname: String, email: String, password: String) {
        // ¡CIFRAMOS EL PASSWORD!
        val hashedPassword = PasswordHasher.hashPassword(password)

        // Creamos el usuario con el password YA CIFRADO
        val nuevoUsuario = Usuario(0, name, lastname, hashedPassword, email)

        // Llamamos a nuestra función "insertar"
        insertar(nuevoUsuario)
    }

    suspend fun insertar(usuario: Usuario) {
        withContext(Dispatchers.IO) {
            // Comprobamos si el email ya existe ANTES de insertar
            val existingUser = usuarioDao.findByEmail(usuario.email)
            if (existingUser != null) {
                // Si ya existe, lanzamos un error que el ViewModel atrapará
                throw Exception("El correo electrónico ya está registrado.")
            }
            // Si no existe, insertamos
            usuarioDao.insertar(usuario)
        }
    }


    suspend fun validarLogin(email: String, password: String): Usuario {
        return withContext(Dispatchers.IO) {
            // 1. Buscamos al usuario SOLO por email
            val usuario = usuarioDao.findByEmail(email)

            // 2. Verificamos si el usuario existe
            if (usuario == null) {
                // Si no existe, lanzamos un error
                throw Exception("El correo electrónico no está registrado.")
            }

            // 3. Si existe, comparamos la contraseña (texto plano)
            //    con el hash guardado en la BD.
            val isPasswordCorrect = PasswordHasher.checkPassword(password, usuario.password)

            if (!isPasswordCorrect) {
                // Si la contraseña no coincide, lanzamos un error
                throw Exception("Contraseña incorrecta.")
            }

            // 4. Si todo está bien, devolvemos el usuario
            usuario
        }
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