package com.receiptkeep.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.receiptkeep.app.model.Receipt
import com.receiptkeep.app.ui.ReceiptCardList
import com.receiptkeep.app.ui.theme.ReceiptKeepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Planning single activity architecture
            //TODO: make MainActivity switch content from ReceiptCardList to ReceiptDetails (and back)
            ReceiptKeepTheme {
                // dummy data
                val dummyReceipts = listOf(
                    Receipt(
                        id = 1L,
                        merchantName = "Сільпо",
                        totalPrice = 450.50,
                        note = "Продукти",
                        currency = "$"
                    ),
                    Receipt(
                        id = 2L,
                        merchantName = "АТБ",
                        totalPrice = 120.00,
                        currency = "UAH")
                )
                ReceiptCardList(receipts = dummyReceipts, {})
            }
        }
    }
}