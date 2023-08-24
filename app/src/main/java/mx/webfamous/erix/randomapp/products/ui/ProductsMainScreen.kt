package mx.webfamous.erix.randomapp.products.ui

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.webfamous.erix.randomapp.core.utils.loge
import mx.webfamous.erix.randomapp.models.products.Product
import mx.webfamous.erix.randomapp.products.ui.events.UiEvent
import mx.webfamous.erix.randomapp.products.ui.utils.ProductsRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsMainScreen() {
    Scaffold {paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = ProductsRoutes.Products.route
            ) {
                composable(ProductsRoutes.Products.route) {
                    ProductsScreen() {
                        when(it) {
                            is UiEvent.GoToDetailProduct -> {
                                navController.navigate(ProductsRoutes.DetailProduct.createRoute(it.product))
                            }
                        }
                    }
                }
                composable(ProductsRoutes.DetailProduct.route) {backStackEntry ->
                    val title = Uri.decode(backStackEntry.arguments?.getString("title"))
                    val image = Uri.decode(backStackEntry.arguments?.getString("image"))
                    val description = Uri.decode(backStackEntry.arguments?.getString("description"))
                    val price = Uri.decode(backStackEntry.arguments?.getString("price")).toIntOrNull() ?: 0
                    DetailProductScreen(
                        product = Product(
                            title = title,
                            description = description,
                            price = price,
                            images = listOf(image)
                        ),
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}