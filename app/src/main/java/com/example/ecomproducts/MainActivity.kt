package com.example.ecomproducts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecomproducts.screens.ProductDetailScreen
import com.example.ecomproducts.screens.ProductListScreen
import com.example.ecomproducts.screens.SplashScreen
import com.example.ecomproducts.ui.theme.EcomProductsTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: ProductViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            EcomProductsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    LaunchedEffect(Unit) {
                        delay(3000)
                        navController.navigate("productList")
                    }

                    NavHost(navController = navController, startDestination = "splashScreen") {

                        composable("splashScreen") {
                            SplashScreen()
                        }


                        composable("productList") {
                            ProductListScreen(
                                viewModel = viewModel,
                                onProductClick = { product ->
                                    navController.navigate("productDetail/${product.id}")
                                },
                            )
                        }


                        composable(
                            "productDetail/{productId}",
                            arguments = listOf(navArgument("productId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val productId = backStackEntry.arguments?.getInt("productId")
                            if (productId != null) {
                                val selectedProduct = viewModel.getProductById(productId)
                                if (selectedProduct != null) {
                                    ProductDetailScreen(
                                        product = selectedProduct,
                                        onNavigateUp = {
                                            navController.popBackStack()
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
