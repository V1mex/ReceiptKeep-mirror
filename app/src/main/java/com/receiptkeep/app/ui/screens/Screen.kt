package com.receiptkeep.app.ui.screens

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable
    data object ReceiptList : Screen

    @Serializable
    data class ReceiptDetails(val receiptId: Long) : Screen
}