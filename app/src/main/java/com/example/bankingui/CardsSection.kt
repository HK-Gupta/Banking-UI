package com.example.bankingui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingui.data.CardsItem
import com.example.bankingui.ui.theme.BlueEnd
import com.example.bankingui.ui.theme.BlueStart
import com.example.bankingui.ui.theme.GreenEnd
import com.example.bankingui.ui.theme.GreenStart
import com.example.bankingui.ui.theme.OrangeEnd
import com.example.bankingui.ui.theme.OrangeStart
import com.example.bankingui.ui.theme.PurpleEnd
import com.example.bankingui.ui.theme.PurpleStart

val items = listOf(
    CardsItem(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Business",
        balance = 440.56,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    CardsItem(
        cardType = "MASTER",
        cardNumber = "3456 1234 5678 9012",
        cardName = "Savings",
        balance = 94.56,
        color = getGradient(BlueStart, BlueEnd)
    ),
    CardsItem(
        cardType = "VISA",
        cardNumber = "9012 3456 1234 5678",
        cardName = "School",
        balance = 20.56,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    CardsItem(
        cardType = "MASTER",
        cardNumber = "5678 9012 3456 1234",
        cardName = "Child",
        balance = 10.56,
        color = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardsSection() {
    LazyRow {
        items(items.size) {index->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = items[index]
    var lastItemPaddingEnd = 0.dp
    if(index == items.size-1) {
        lastItemPaddingEnd = 15.dp
    }
    var image = painterResource(id = R.drawable.visa)
    if(card.cardType == "MASTER") {
        image = painterResource(id = R.drawable.card)
    }

    Box(
        modifier = Modifier
            .padding(start=15.dp, end=lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(card.color)
                .width(250.dp)
                .height(150.dp)
                .clickable { }
                .padding(start = 15.dp, bottom = 5.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }

}