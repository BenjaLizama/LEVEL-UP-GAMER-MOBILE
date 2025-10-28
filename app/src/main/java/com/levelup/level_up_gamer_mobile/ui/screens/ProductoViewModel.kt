package com.levelup.level_up_gamer_mobile.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.levelup.level_up_gamer_mobile.data.Producto
import com.levelup.level_up_gamer_mobile.data.ProductoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductoViewModel(private val repository: ProductoRepository) : ViewModel() {

    val productos: LiveData<List<Producto>> = repository.obtenerTodosLosProductos().asLiveData()

    fun agregarProducto(name: String, description: String, price: Double, imagePath: String) {
        if (name.isBlank()|| description.isBlank()|| price<=0.0|| imagePath.isBlank()) {
            return
        }

        val nuevoProducto = Producto(id = 0,name,price, description,  imagePath)
    viewModelScope.launch{repository.insertar(nuevoProducto)}
    }
    fun eliminarProducto(producto: Producto) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.eliminar(producto)
        }
    }
    class ProductoViewModelFactory(private val repository: ProductoRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProductoViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ProductoViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}