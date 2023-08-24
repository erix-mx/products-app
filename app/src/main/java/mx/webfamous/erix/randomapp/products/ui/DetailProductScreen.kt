package mx.webfamous.erix.randomapp.products.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import mx.webfamous.erix.randomapp.R
import mx.webfamous.erix.randomapp.models.products.Product
import mx.webfamous.erix.randomapp.products.ui.components.GeneralProductScreen
import mx.webfamous.erix.randomapp.ui.theme.LocalDimensions

@Composable
fun DetailProductScreen(
    product: Product,
    onBack: () -> Unit = {}
) {
    val dimensions = LocalDimensions.current
    GeneralProductScreen(
        title = product.title ?: "Unknown",
        bottomBar = {
            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, bottom = dimensions.horizontalPadding, start = 35.dp, end = 35.dp),
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(dimensions.generalCorner)),
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    )
                ) {
                    Text(
                        text = stringResource(R.string.tag_button_back),
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensions.horizontalPadding, vertical = dimensions.horizontalPadding),
                model = product.images?.get(0) ?: "",
                contentDescription = "Image product",
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensions.horizontalPadding, vertical = dimensions.horizontalPadding),
                text = product.description ?: "",
                maxLines = 3,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensions.horizontalPadding, vertical = dimensions.horizontalPadding),
                text = stringResource(R.string.product_price, product.price ?: 0),
                maxLines = 1,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Preview
@Composable
fun DetailProductScreenPreview() {
    DetailProductScreen(
        product = Product(
            title = "Title",
            description = "Description",
            price = 100,
            images = listOf("https://picsum.photos/200/300")
        )
    )
}