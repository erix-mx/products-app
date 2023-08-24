package mx.webfamous.erix.randomapp.products.ui.state

import mx.webfamous.erix.randomapp.models.products.Product

data class ProductState(
    val products: List<Product> = emptyList(),
    val error: String = ""
)
