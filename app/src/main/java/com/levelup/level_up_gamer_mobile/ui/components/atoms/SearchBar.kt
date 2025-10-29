package com.levelup.level_up_gamer_mobile.ui.components.molecules // O donde lo quieras poner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Un componente de barra de búsqueda reutilizable.
 *
 * @param query El texto actual de la búsqueda.
 * @param onQueryChange Callback que se dispara cuando el texto cambia.
 * @param onSearch Callback que se dispara cuando el usuario presiona 'Enter' o 'Buscar'.
 * @param active El estado de la barra (expandida o no).
 * @param onActiveChange Callback que se dispara cuando el estado 'active' cambia.
 * @param modifier Modificador para aplicar al DockedSearchBar.
 * @param suggestions Lista de strings para mostrar como sugerencias cuando está activo.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    suggestions: List<String> = listOf() // Lista de sugerencias
) {
    DockedSearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = onQueryChange, // Notifica el cambio de texto
        onSearch = {
            onSearch(it) // Notifica la búsqueda finalizada
            onActiveChange(false) // Cierra la barra después de buscar
        },
        active = active,
        onActiveChange = onActiveChange, // Notifica el cambio de estado activo
        placeholder = { Text("Buscar productos...") },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Icono de búsqueda")
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { onQueryChange("") }) { // Limpia el texto
                    Icon(Icons.Default.Close, contentDescription = "Limpiar búsqueda")
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(suggestions) { historyItem ->
                Text(
                    text = historyItem,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            onQueryChange(historyItem)
                            onActiveChange(false)
                        }
                )
            }
        }
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    ProductSearchBar("", {}, {}, false, {})
}
