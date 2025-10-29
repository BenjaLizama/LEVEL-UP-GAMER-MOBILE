package com.levelup.level_up_gamer_mobile.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.levelup.level_up_gamer_mobile.data.dao.CategoriaDao
import com.levelup.level_up_gamer_mobile.data.dao.ProductoDao
import com.levelup.level_up_gamer_mobile.data.dao.UsuarioDao
import com.levelup.level_up_gamer_mobile.data.model.Categoria
import com.levelup.level_up_gamer_mobile.data.model.Producto
import com.levelup.level_up_gamer_mobile.data.model.Usuario

// 1. Corregida: Sin paréntesis vacíos
@Database(entities = [Producto::class, Usuario::class, Categoria::class] , version = 5, exportSchema = false)
abstract class LevelUpDataBase: RoomDatabase() {

    // Función abstracta para obtener el DAO
    abstract fun productDao(): ProductoDao
    abstract fun usuarioDao(): UsuarioDao
    abstract fun categoriaDao(): CategoriaDao

    // Patrón Singleton para obtener la base de datos


    companion object {

        @Volatile
        private var INSTANCE: LevelUpDataBase? = null

        // 2. Corregida: Uso de 'getDatabase' con d minúscula (camelCase)
        fun getDatabase(context: Context): LevelUpDataBase {
            // Retorna la instancia existente (si no es nula)
            return INSTANCE ?: synchronized(this) {
                // Si es nula, construye la base de datos
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LevelUpDataBase::class.java,
                    "levelup_database" // Nombre del archivo de la BD
                ).build()

                INSTANCE = instance
                instance // Retorna la instancia creada
            }
        }
    }
}
