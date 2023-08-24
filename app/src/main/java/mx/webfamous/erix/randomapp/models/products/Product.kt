package mx.webfamous.erix.randomapp.models.products

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val title: String?,
    val description: String?,
    val price: Int?,
    val images: List<String>?
)