package com.example.bankingui.data

import androidx.compose.ui.graphics.Brush

data class CardsItem(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val color: Brush


)