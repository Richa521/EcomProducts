package com.example.ecomproducts

import com.example.ecomproducts.Model.ApiResponse
import com.example.ecomproducts.Model.Product
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("products")
    suspend fun getProducts(@Query("limit") limit: Int = 100): ApiResponse<List<Product>>
}


