package com.levelup.level_up_gamer_mobile

import android.app.Application
import androidx.room.Room
import com.levelup.level_up_gamer_mobile.data.LevelUpDataBase // <-- Importa tu BD
import com.levelup.level_up_gamer_mobile.data.repository.UsuarioRepository // <-- Importa tu Repo
import com.levelup.level_up_gamer_mobile.data.dao.UsuarioDao
class App: Application() {

    private val database: LevelUpDataBase by lazy {
        Room.databaseBuilder(
            this.applicationContext,
            LevelUpDataBase::class.java,
            "levelup_database"
        ).build()
    }

    // 3. Creamos el Repositorio (usando 'lazy')
    //    ¡Aquí le pasamos el DAO que creamos en el paso 2!
     val usuarioRepository : UsuarioRepository by lazy {
        UsuarioRepository(database.usuarioDao())
    }

    companion object {
        // 'lateinit' porque la inicializaremos en onCreate
        private lateinit var instance: App

        // Creamos un getter estático para el repositorio
        val repository: UsuarioRepository
            get() = instance.usuarioRepository
    }

    override fun onCreate() {
        super.onCreate()
        // 4. Asignamos la instancia estática cuando la app se crea
        instance = this
    }


}