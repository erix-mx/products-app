package mx.webfamous.erix.randomapp.products.data.dto

import com.google.gson.annotations.SerializedName
import mx.webfamous.erix.randomapp.models.products.Product

data class ProductDto(
    @SerializedName("id"                 ) var id                 : Int?              = null,
    @SerializedName("title"              ) var title              : String?           = null,
    @SerializedName("description"        ) var description        : String?           = null,
    @SerializedName("price"              ) var price              : Int?              = null,
    @SerializedName("discountPercentage" ) var discountPercentage : Double?           = null,
    @SerializedName("rating"             ) var rating             : Double?           = null,
    @SerializedName("stock"              ) var stock              : Int?              = null,
    @SerializedName("brand"              ) var brand              : String?           = null,
    @SerializedName("category"           ) var category           : String?           = null,
    @SerializedName("thumbnail"          ) var thumbnail          : String?           = null,
    @SerializedName("images"             ) var images             : ArrayList<String> = arrayListOf()
) {
    fun toProduct() = Product(
        title = title,
        description = description,
        price = price,
        images = images
    )
}