package mx.webfamous.erix.randomapp.products.data.repository

import mx.webfamous.erix.randomapp.core.network.ApiServices
import mx.webfamous.erix.randomapp.core.network.NetworkResult
import mx.webfamous.erix.randomapp.core.network.getRemote
import mx.webfamous.erix.randomapp.models.products.Product

class ProductsRepositoryImpl(
    private val services: ApiServices
): ProductsRepository {
    override suspend fun getProducts(): NetworkResult<List<Product>> {
        return getRemote(
            call = { services.getProducts() },
            mapper = {
                it.products.map { item -> item.toProduct() }
            }
        )
    }
}