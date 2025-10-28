package com.levelup.level_up_gamer_mobile

import android.app.Application
import com.levelup.level_up_gamer_mobile.data.LevelUpDataBase // <-- Importa tu BD
import com.levelup.level_up_gamer_mobile.data.repository.UsuarioRepository // <-- Importa tu Repo
import com.levelup.level_up_gamer_mobile.data.dao.UsuarioDao
class App: Application() {

    private val database by lazy {
        LevelUpDataBase.getDatabase(this)
    }

    // 2. Creamos el DAO (usando 'lazy')
    private val usuarioDao by lazy {
        database.usuarioDao()
    }

    // 3. Creamos el Repositorio (usando 'lazy')
    //    ¡Aquí le pasamos el DAO que creamos en el paso 2!
    val usuarioRepository by lazy {
        UsuarioRepository(usuarioDao)
    }

    override fun onCreate() {
        super.onCreate()

    }

}