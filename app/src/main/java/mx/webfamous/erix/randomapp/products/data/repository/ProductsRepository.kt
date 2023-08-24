package mx.webfamous.erix.randomapp.products.data.repository

import mx.webfamous.erix.randomapp.core.di.NetworkModule
import mx.webfamous.erix.randomapp.core.network.NetworkResult
import mx.webfamous.erix.randomapp.models.products.Product

interface ProductsRepository {
    suspend fun getProducts(): NetworkResult<List<Product>>
}