package com.receiptkeep.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.receiptkeep.app.model.Receipt

@Composable
fun ReceiptCardList(
    receipts: List<Receipt>,
    onReceiptClick: (Receipt) -> Unit
){
    LazyColumn(
        contentPadding = PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(receipts, key = { it.id }) { receipt ->
            ReceiptCard(receipt = receipt, onClick = onReceiptClick)
        }
    }
}
