package com.levelup.level_up_gamer_mobile.ui.components.molecules

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.levelup.level_up_gamer_mobile.R
import com.levelup.level_up_gamer_mobile.ui.theme.ColorAcento
import com.levelup.level_up_gamer_mobile.ui.theme.ColorBarraNavegacion
import com.levelup.level_up_gamer_mobile.ui.theme.ColorTextoPrincipal

// Interface para los productos
interface ProductData {
    val id: Long
    val productName: String
    val productPrice: Double
    val productDescription: String
    val productImagePath: String
}

// Clase que implementa la interface ProductData
data class ProductItem(
    override val id: Long,
    override val productName: String,
    override val productPrice: Double,
    override val productDescription: String,
    override val productImagePath: String
): ProductData

// Este es nuestro componente
@Composable
fun Product(data: ProductData) { // <== Recibe el ProductData como parámetro
    val productName = data.productName
    val productPrice = data.productPrice
    val productDescription = data.productDescription
    val productImagePath = data.productImagePath

    // Accedemos al contexto de la App (necesario para
    // obtener recursos fuera del componente)
    val context = LocalContext.current

    // Cuando utilizamos getIdentifier() dentro de un componente Lint
    // detecta un posible problema y nos advierte de este mismo.
    // El problema es que un componente se puede recomponer muchas veces
    // por segundo y el metodo getIdentifier() es una lectura de recursos,
    // se considera una operacion pesada, pero como lo tenemos controlado
    // gracias a que le decimos que se ejecuta solo cuando cambia el recurso
    @SuppressLint("LocalContextResourcesRead")
    val resourceId = remember(productImagePath) {
        context.resources.getIdentifier(
            productImagePath,
            "drawable",
            context.packageName
        )
    }

    val painter = if (resourceId != 0) {
        painterResource(id = resourceId)
    } else {
        painterResource(id = R.drawable.noimage)
    }


    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorAcento)
            .height(125.dp)
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxHeight(),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Image(
                    painter = painter,
                    contentDescription = "Imagen de $productName",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(120.dp)
                        .width(80.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                )
            }

            Column {
                Text("Nombre del producto")
                Text("Categoria del producto")
                Text("Precio del producto")
            }

            Box {
                Button({}) {
                    Text("Agregar al carrito")
                }
            }
        }
    }

}

@Preview
@Composable
fun ProductPreview() {
    Product(ProductItem(1, "Producto 1", 10.0, "Descripción del producto 1", ""))
}
