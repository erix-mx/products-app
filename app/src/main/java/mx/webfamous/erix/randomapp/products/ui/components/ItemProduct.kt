package mx.webfamous.erix.randomapp.products.ui.components

import android.provider.Settings.Global.getString
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.webfamous.erix.randomapp.R
import mx.webfamous.erix.randomapp.models.products.Product
import mx.webfamous.erix.randomapp.ui.theme.ItemProductColor
import mx.webfamous.erix.randomapp.ui.theme.LocalDimensions

@Composable
fun ItemProduct(
    product: Product,
    colors: ItemProductColor = ItemProductColor(),
    itemClick: (Product) -> Unit = {}
) {
    val dimensions = LocalDimensions.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = colors.border, shape = RoundedCornerShape(dimensions.generalCorner))
            .clip(shape = RoundedCornerShape(dimensions.generalCorner))
            .clickable { itemClick(product) }
            .padding(dimensions.horizontalPadding)
    ) {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = dimensions.generalCorner),
                text = stringResource(R.string.product_title, product.title ?: "Unknown"),
                maxLines = 1,
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = dimensions.generalCorner),
                text = product.description ?: "",
                maxLines = 3,
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = dimensions.generalCorner),
                text = stringResource(R.string.product_price, product.price ?: 0),
                maxLines = 1,
            )
        }
    }
}

@Preview
@Composable
fun ItemProductPreview() {
    ItemProduct(
        product = Product(
            title = "iPhone 9",
            price = 100,
            description = "iPhone 9 description",
            images = emptyList()
        )
    )
}