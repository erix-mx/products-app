package mx.webfamous.erix.randomapp.products.ui.events

import mx.webfamous.erix.randomapp.models.products.Product

sealed class UiEvent {
    data class GoToDetailProduct(val product: Product) : UiEvent()
}