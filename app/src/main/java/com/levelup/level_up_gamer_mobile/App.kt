package com.levelup.level_up_gamer_mobile

import android.app.Application
// No necesitas 'Room' aquí, porque la BD se encarga
import com.levelup.level_up_gamer_mobile.data.LevelUpDataBase
import com.levelup.level_up_gamer_mobile.data.repository.UsuarioRepository
// No necesitas el DAO aquí, el repositorio se encarga

class App : Application() {

    // 1. Corregido: Obtenemos la BD desde su propio companion object
    private val database: LevelUpDataBase by lazy {
        LevelUpDataBase.getDatabase(this.applicationContext)
    }

    // 2. Esto ya estaba correcto
    //    Crea el repositorio pasándole el DAO de la BD correcta
    val usuarioRepository: UsuarioRepository by lazy {
        UsuarioRepository(database.usuarioDao())
    }

    // (Si quieres agregar tu repositorio de carrito, lo harías aquí)
    // val itemCarritoRepository: ItemCarritoRepository by lazy {
    //     ItemCarritoRepository(database.carritoDao())
    // }

    companion object {
        private lateinit var instance: App

        // Un getter estático para el repositorio de usuario
        val repository: UsuarioRepository
            get() = instance.usuarioRepository

        // (Y aquí podrías exponer el repositorio de carrito)
        // val carritoRepo: ItemCarritoRepository
        //     get() = instance.itemCarritoRepository
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}