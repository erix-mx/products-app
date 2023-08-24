package mx.webfamous.erix.randomapp.products.ui.events

import mx.webfamous.erix.randomapp.models.products.Product

sealed class ProductEvent {
    object GetProducts: ProductEvent()
    data class GoToDetailProduct(val product: Product): ProductEvent()
}
