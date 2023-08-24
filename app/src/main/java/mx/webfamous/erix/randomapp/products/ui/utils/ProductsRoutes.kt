package mx.webfamous.erix.randomapp.products.ui.utils

import android.net.Uri
import androidx.core.net.toUri
import kotlinx.serialization.json.Json
import mx.webfamous.erix.randomapp.models.products.Product

sealed class ProductsRoutes(val route: String) {
    object Products : ProductsRoutes("products")
    object DetailProduct : ProductsRoutes("detailProduct/{title}/{image}/{description}/{price}/") {
        fun createRoute(product: Product): String {
            val encodedTitle = Uri.encode(product.title)
            val encodedImage = Uri.encode(product.images?.get(0) ?: "")
            val encodedDescription = Uri.encode(product.description)
            val encodedPrice = Uri.encode(product.price.toString())
            return "detailProduct/$encodedTitle/$encodedImage/$encodedDescription/$encodedPrice/"
        }
    }
}