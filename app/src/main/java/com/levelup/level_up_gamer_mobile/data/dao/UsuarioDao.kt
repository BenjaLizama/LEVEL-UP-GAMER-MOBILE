package com.levelup.level_up_gamer_mobile.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.levelup.level_up_gamer_mobile.data.model.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert
        suspend fun insertar(usuario: Usuario)

   @Update
        suspend fun actualizar(usuario: Usuario)

   @Delete
        suspend fun eliminar(usuario: Usuario)

   @Query("SELECT * FROM tabla_usuario ORDER BY id DESC")
        fun obtenerUsuarios(): Flow<List<Usuario>>

   @Query("SELECT * FROM tabla_usuario WHERE name = :name ")
        fun obtenerUsuario(name: String): Flow<Usuario>

    @Query("SELECT * FROM tabla_usuario WHERE email = :email LIMIT 1")
    suspend fun findByEmail(email: String): Usuario?

    @Query("SELECT * FROM tabla_usuario WHERE email = :email LIMIT 1")
    fun obtenerUsuarioPorEmail(email: String): Flow<Usuario>

}