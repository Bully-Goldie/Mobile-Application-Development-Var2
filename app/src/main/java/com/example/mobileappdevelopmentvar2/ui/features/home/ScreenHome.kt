package com.example.mobileappdevelopmentvar2.ui.features.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobileappdevelopmentvar2.data.model.product.Product
import com.example.mobileappdevelopmentvar2.ui.components.ProductCard
import androidx.compose.foundation.lazy.grid.items

@Composable
fun ScreenHome(modifier: Modifier = Modifier, products: List<Product>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(products) { product ->
            ProductCard(product = product,clickBasket = {})
        }
    }
}