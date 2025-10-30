package com.levelup.level_up_gamer_mobile.data.Pojo

import androidx.room.Embedded
import androidx.room.Relation
import com.levelup.level_up_gamer_mobile.data.model.Categoria
import com.levelup.level_up_gamer_mobile.data.model.Producto

data class CategoriaWithProducto(
    @Embedded val categoria: Categoria,
    @Relation(
        parentColumn = "id",
        entityColumn = "idCategory"
    ) val productos: List<Producto>
)


