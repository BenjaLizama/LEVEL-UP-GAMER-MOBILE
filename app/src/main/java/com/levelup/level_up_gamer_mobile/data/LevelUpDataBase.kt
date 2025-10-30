package com.levelup.level_up_gamer_mobile.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.levelup.level_up_gamer_mobile.data.dao.CarritoDao
import com.levelup.level_up_gamer_mobile.data.dao.CategoriaDao
import com.levelup.level_up_gamer_mobile.data.dao.ProductoDao
import com.levelup.level_up_gamer_mobile.data.dao.UsuarioDao
import com.levelup.level_up_gamer_mobile.data.model.Categoria
import com.levelup.level_up_gamer_mobile.data.model.ItemCarrito
import com.levelup.level_up_gamer_mobile.data.model.Producto
import com.levelup.level_up_gamer_mobile.data.model.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// 1. Corregida: Sin paréntesis vacíos
@Database(
    entities = [Producto::class, Usuario::class, Categoria::class, ItemCarrito::class],
    version = 11,
    exportSchema = false
)
abstract class LevelUpDataBase : RoomDatabase() {

    // Función abstracta para obtener el DAO
    abstract fun productDao(): ProductoDao
    abstract fun usuarioDao(): UsuarioDao
    abstract fun categoriaDao(): CategoriaDao

    abstract fun carritoDao(): CarritoDao

    companion object {

        @Volatile
        private var INSTANCE: LevelUpDataBase? = null

        private class LevelUpDatabaseCallback(private val scope: CoroutineScope) :
            RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                // NO compruebes INSTANCE aquí

                scope.launch(Dispatchers.IO) {
                    // Comprueba INSTANCE DENTRO de la corutina
                    val database = INSTANCE
                    if (database != null) {
                        poblarDatabase(
                            database.productDao(),
                            database.categoriaDao(),
                            database.usuarioDao()
                        )
                    }
                }
            }

            suspend fun poblarDatabase(
                productDao: ProductoDao,
                categoriaDao: CategoriaDao,
                usuarioDao: UsuarioDao
            ) {
                //inserta categorias pre definidas
                categoriaDao.insertar(Categoria(0, "Consolas"))
                categoriaDao.insertar(Categoria(0, "sillas"))
                categoriaDao.insertar(Categoria(0, "juedos de mesa"))
                categoriaDao.insertar(Categoria(0, "PC"))
                //inserta productos pre definidos
                productDao.insertar(Producto(0,"Play Station",10000.0,"la meao consola pe tiene el pesiman","nosepo",1))
                productDao.insertar(Producto(0,"PC gamer",150000.0,"ta de pana oe","no tiene",4))
                productDao.insertar(Producto(0,"sillas gamer",1000000.0,"entera mala te duele el potito","nosepo",2))
                productDao.insertar(Producto(0,"Catan",103000.0,"entero fome no se quien lo compraria","nosepo",3))
                productDao.insertar(Producto(0,"monopoli",20000.0,"juego god","nosepo",3))
                //insertar usuarios pre definidos
                usuarioDao.insertar(Usuario(0,"admin","admin","admin","admin"))
            }
        }

        fun getDatabase(context: Context): LevelUpDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LevelUpDataBase::class.java,
                    "levelup_database"
                )
                    .addCallback(LevelUpDatabaseCallback(CoroutineScope(Dispatchers.IO)))
                    .fallbackToDestructiveMigration()

                    // V-- AÑADE ESTA LÍNEA --V
                    .allowMainThreadQueries()
                    // ^-- AÑADE ESTA LÍNEA --^

                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
