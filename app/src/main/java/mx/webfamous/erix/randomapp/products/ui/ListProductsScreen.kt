package mx.webfamous.erix.randomapp.products.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import mx.webfamous.erix.randomapp.models.products.Product
import mx.webfamous.erix.randomapp.products.ui.components.GeneralProductScreen
import mx.webfamous.erix.randomapp.products.ui.components.ItemProduct
import mx.webfamous.erix.randomapp.products.ui.events.ProductEvent
import mx.webfamous.erix.randomapp.products.ui.events.UiEvent
import mx.webfamous.erix.randomapp.products.ui.state.ProductState
import mx.webfamous.erix.randomapp.products.ui.viewmodel.ProductViewModel
import mx.webfamous.erix.randomapp.ui.theme.ItemProductColor
import mx.webfamous.erix.randomapp.ui.theme.LocalDimensions

@Composable
fun ProductsScreen(
    viewModel: ProductViewModel = hiltViewModel(),
    navigateTo: (UiEvent) -> Unit = {}
) {

    LaunchedEffect(key1 = true) {
        viewModel.dispatcherEvent(ProductEvent.GetProducts)
    }

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.GoToDetailProduct -> navigateTo(event)
            }
        }
    }

    ProductsScreenContent(
        state = viewModel.state,
        events = viewModel::dispatcherEvent
    )
}

@Composable
fun ProductsScreenContent(
    state: ProductState,
    events: (ProductEvent) -> Unit = {}
) {

    val dimensions = LocalDimensions.current

    GeneralProductScreen(
        title = "Products"
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(dimensions.horizontalPadding)
        ) {
            items(state.products.size) { index ->
                val product = state.products[index]
                ItemProduct(
                    product = product,
                    colors = ItemProductColor(
                        border = MaterialTheme.colorScheme.primary,
                    ),
                    itemClick = { events(ProductEvent.GoToDetailProduct(product)) }
                )
                Spacer(modifier = Modifier.size(dimensions.horizontalPadding))
            }
        }
    }
}

@Preview
@Composable
fun ProductsScreenPreview() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ProductsScreenContent(
            state = ProductState(
                products = listOf(
                    Product(
                        title = "iPhone 9",
                        price = 100,
                        description = "iPhone 9 description",
                        images = emptyList()
                    ),
                    Product(
                        title = "iPhone 10",
                        price = 100,
                        description = "iPhone 10 description",
                        images = emptyList()
                    ),
                    Product(
                        title = "iPhone 11",
                        price = 100,
                        description = "iPhone 11 description",
                        images = emptyList()
                    )
                )
            )
        )
    }
}