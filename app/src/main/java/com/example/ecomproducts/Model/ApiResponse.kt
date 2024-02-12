package com.example.ecomproducts.Model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("products") val data: T?
)

