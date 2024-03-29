package com.example.ecomproducts

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomproducts.Model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Timer
import java.util.TimerTask

class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    private val _isRefreshing = MutableLiveData(false)
    val isRefreshing: LiveData<Boolean> get() = _isRefreshing

    private val _loadedProductCount = MutableLiveData(10)
    val loadedProductCount: LiveData<Int> get() = _loadedProductCount

    private val _lastRefreshTime = MutableLiveData<String>()
    val lastRefreshTime: LiveData<String> get() = _lastRefreshTime

    init {
        fetchProducts()

        viewModelScope.launch {
            while (true) {
                delay(3*60*1000)
                refreshProducts()
            }
        }
    }

    fun refreshProducts() {
        _isRefreshing.value = true
        _loadedProductCount.value = (loadedProductCount.value ?: 0) + 10
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val allProducts = RetrofitInstance.productService.getProducts().data ?: emptyList()

                val startIndex = (loadedProductCount.value ?: 0) - 10
                val endIndex = loadedProductCount.value ?: 0

                _products.value = allProducts.subList(startIndex.coerceAtLeast(0), endIndex.coerceAtMost(allProducts.size))

                _lastRefreshTime.value = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(
                    Date()
                )
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isRefreshing.value = false
            }
        }
    }

    fun getProductById(productId: Int): Product? {
        return products.value?.find { it.id == productId }
    }
}