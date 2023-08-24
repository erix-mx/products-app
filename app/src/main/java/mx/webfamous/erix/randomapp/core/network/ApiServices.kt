package mx.webfamous.erix.randomapp.core.network

import mx.webfamous.erix.randomapp.products.data.dto.ProductDto
import mx.webfamous.erix.randomapp.products.data.dto.ProductsResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("products")
    suspend fun getProducts(): Response<ProductsResponseDto>
}