package com.levelup.level_up_gamer_mobile.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 1. Corregida: Sin paréntesis vacíos
@Database(entities = [Producto::class,Usuario::class] , version = 2, exportSchema = false)
abstract class LevelUpDataBase: RoomDatabase() {

    // Función abstracta para obtener el DAO
    abstract fun productDao(): ProductoDao
    abstract fun usuarioDao(): UsuarioDao


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
