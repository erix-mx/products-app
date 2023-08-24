package mx.webfamous.erix.randomapp.products.data.dto

import com.google.gson.annotations.SerializedName

data class ProductsResponseDto (

    @SerializedName("products" ) var products : ArrayList<ProductDto> = arrayListOf(),
    @SerializedName("total"    ) var total    : Int?                = null,
    @SerializedName("skip"     ) var skip     : Int?                = null,
    @SerializedName("limit"    ) var limit    : Int?                = null

)