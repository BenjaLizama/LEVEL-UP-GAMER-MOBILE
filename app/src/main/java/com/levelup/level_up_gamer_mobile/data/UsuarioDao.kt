package com.levelup.level_up_gamer_mobile.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert
   suspend fun insertar(usuario: Usuario)

   @Update
   suspend fun actualizar(usuario: Usuario)

   @Delete
   suspend fun eliminar(usuario: Usuario)

   @Query("SELECT * FROM TABLA_USUARIO ORDER BY id DESC")
   fun obtenerUsuarios(): Flow<List<Usuario>>

   @Query("SELECT * FROM TABLA_USUARIO WHERE id=:id")
  suspend fun obtenerUsuario(id: Int): Usuario?



}