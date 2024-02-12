package com.example.ecomproducts.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.ecomproducts.Model.Product
import com.example.ecomproducts.ProductViewModel
import com.example.ecomproducts.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    viewModel: ProductViewModel,
    onProductClick: (Product) -> Unit
) {
    val products by viewModel.products.observeAsState(emptyList())
    val isRefreshing by viewModel.isRefreshing.observeAsState(false)
    val lastRefreshTime by viewModel.lastRefreshTime.observeAsState("")

    Log.d("ProductListScreen", "Products observed: ${products.size}")

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Products",style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary) },
                actions = {
                    LastRefreshTime(
                        lastRefreshTime = lastRefreshTime ?: "",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                viewModel.refreshProducts()
                            }
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing),
                onRefresh = {
                    viewModel.refreshProducts()
                }
            ) {
                LazyColumn {
                    items(products) { product ->
                        ProductListItem(product = product, onProductClick = onProductClick)
                    }
                }
            }
        }
    }
}

@OptIn(coil.annotation.ExperimentalCoilApi::class)
@Composable
fun ProductListItem(product: Product, onProductClick: (Product) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onProductClick(product) }
            .padding(16.dp)
    ) {


        Image(
            painter = rememberImagePainter(
                data = product.thumbnail,
                builder = {
                    placeholder(R.drawable.ic_launcher_foreground)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.background),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

    }
}
@Composable
fun LastRefreshTime(lastRefreshTime: String, modifier: Modifier = Modifier) {
    Text(
        text = "Last Refresh: $lastRefreshTime",
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary

    )
}

