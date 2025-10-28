package com.levelup.level_up_gamer_mobile.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.levelup.level_up_gamer_mobile.data.Producto
import com.levelup.level_up_gamer_mobile.data.ProductoRepository

// Helper para obtener el ViewModel con la Factory
@Composable
fun productosViewModel(repository: ProductoRepository): ProductoViewModel {
    return viewModel(
        factory = ProductoViewModel.ProductoViewModelFactory(repository)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductosScreen() {
    val context = LocalContext.current
    // 1. Inicialización del Repositorio y ViewModel
    val repository = remember { ProductoRepository(context) }
    val viewModel = productosViewModel(repository = repository)

    // 2. Observación del LiveData
    // 'productos' se convierte en un State de Compose.
    // CADA VEZ que cambia la base de datos, esta variable se actualiza.
    val productos by viewModel.productos.observeAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Inventario Gamer") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Ejemplo de inserción de un producto con los nuevos campos
                viewModel.agregarProducto(
                    name = "Mouse RGB Pro",
                    price = 29.99,
                    description = "Mouse óptico de alta precisión para gaming competitivo.",
                    imagePath = "path/to/mouse.jpg" // Placeholder
                )
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Agregar Producto")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(8.dp))

            // 3. Muestra la lista reactiva
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(productos) { producto ->
                    ProductoCard(
                        producto = producto,
                        onDelete = { viewModel.eliminarProducto(it) }
                    )
                }
            }

            if (productos.isEmpty()) {
                Text(
                    text = "No hay productos. Toca '+' para agregar.",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 32.dp)
                )
            }
        }
    }
}

@Composable
fun ProductoCard(producto: Producto, onDelete: (Producto) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                // Muestra el nuevo campo 'name'
                Text(
                    text = producto.name,
                    style = MaterialTheme.typography.titleMedium
                )
                // Muestra el nuevo campo 'description'
                Text(
                    text = producto.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                // Muestra el campo 'price' (cambiado de 'precio')
                Text(
                    text = "ID: ${producto.id} | Precio: $${String.format("%.2f", producto.price)}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // Botón de Eliminación
            Button(
                onClick = { onDelete(producto) },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Eliminar")
            }
        }
    }
}