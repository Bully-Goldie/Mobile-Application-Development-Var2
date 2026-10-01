package com.example.mobileappdevelopmentvar2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileappdevelopmentvar2.R
import com.example.mobileappdevelopmentvar2.ui.theme.nameProductColor
import com.example.mobileappdevelopmentvar2.ui.theme.priceProductColor
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobileappdevelopmentvar2.data.model.product.Product


@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    clickBasket: (Int) -> Unit,
    product: Product
) {
    Box(
        modifier = modifier
            .width(157.dp)
            .height(253.dp)
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .size(157.dp, 200.dp)
                .align(Alignment.TopStart)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mask_group),
                contentDescription = null,
                modifier = Modifier.matchParentSize()
            )

            Image(
                painter = painterResource(id = R.drawable.basket),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp, 30.dp)
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 5.dp, end = 5.dp)
                    .clickable { clickBasket(product.id) }

            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(start = 4.dp, bottom = 8.dp, end = 4.dp)
        ) {
            Text(
                text = product.title,
                fontSize = 14.sp,
                color = nameProductColor,
                fontWeight = FontWeight.W400,
                lineHeight = 14.sp,
                letterSpacing = 0.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$ ${String.format("%.2f", product.price)}",
                fontSize = 14.sp,
                color = priceProductColor,
                fontWeight = FontWeight.W700,
                lineHeight = 14.sp,
                letterSpacing = 0.sp
            )
        }
    }
}

@Preview
@Composable
private fun PrevProductCard() {
    val products = Product(
        id = 1,
        title = "title",
        price = 12.00
    )
    ProductCard(clickBasket = {}, product = products)
}