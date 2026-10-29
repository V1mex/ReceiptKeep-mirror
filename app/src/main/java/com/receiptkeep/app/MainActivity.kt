package com.receiptkeep.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.receiptkeep.app.model.Receipt
import com.receiptkeep.app.model.ReceiptItem
import com.receiptkeep.app.ui.screens.ReceiptCardList
import com.receiptkeep.app.ui.screens.ReceiptDetailsScreen
import com.receiptkeep.app.ui.screens.Screen
import com.receiptkeep.app.ui.theme.ReceiptKeepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Planning single activity architecture
            ReceiptKeepTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "receipt_card_list"
                    ) {
                        composable("receipt_card_list") {
                            ReceiptCardList(
                                receipts = listOf( //dummy data
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
                                ),
                                onReceiptClick = { receipt ->
                                    navController.navigate(Screen.ReceiptDetails(receipt.id))
                                }
                            )
                        }

                        composable<Screen.ReceiptDetails> { backStackEntry ->
                            val receiptId = backStackEntry.toRoute<Screen.ReceiptDetails>().receiptId
                            val dummyDetails = listOf( //same dummy data
                                ReceiptItem("item1", 123.2,321.3, "liters or very long item name?"),
                                ReceiptItem("very very very very very very very very very very very very very very very very very long item2 name", 123.2, 321.3, "kilograms"),
                                ReceiptItem("item3", 146346723.2, 321.3, null),
                                ReceiptItem("item4", 123.2, 321564.3, "items")
                            )
                            val dummyReceipt = Receipt(//same dummy data
                                id = 1L,
                                merchantName = "Сільпо",
                                totalPrice = 450.50,
                                note = "Продукти",
                                currency = "$",
                                items = dummyDetails
                                )

                            ReceiptDetailsScreen(dummyReceipt) //temporarily passing receipt to ReceiptDetailsScreen
                            //TODO: get receipt with receiptId from db IN ReceiptDetailsScreen VIEW MODEL
                            //ReceiptDetailsScreen(backStackEntry.toRoute<Screen.ReceiptDetails>().receiptId)
                        }
                    }
                }
            }
        }
    }
}