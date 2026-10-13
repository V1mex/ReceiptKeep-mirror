package com.receiptkeep.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.receiptkeep.app.R
import com.receiptkeep.app.model.Receipt
import com.receiptkeep.app.model.ReceiptItem

@Composable
fun ReceiptDetailsScreen(receipt : Receipt){
    Column(modifier = Modifier.padding(all=16.dp).fillMaxWidth()){
        if (receipt.merchantName!=null)
            Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, text= stringResource(R.string.merchant_name, receipt.merchantName))
        Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, text = stringResource(R.string.date, receipt.date.toString()))
        Text(textAlign = TextAlign.Center, text = stringResource(R.string.total_price, receipt.totalPrice.toString(), receipt.currency))
        if (receipt.note!=null)
            Text(stringResource(R.string.note, receipt.note))

        //TODO: add optional photo link
        //TODO: add items list
        //TODO: add items editing feature
    }
}

@Preview(showBackground = true)
@Composable
fun ReceiptCardListPreview(){
    ReceiptDetailsScreen(receipt = Receipt(0L, "note",123.toDouble(),"UAH", merchantName = "name",
        items = listOf(
            ReceiptItem("item1", 123.2, 321.3, "liters"),
            ReceiptItem("item2", 123.2, 321.3, "kilograms"),
            ReceiptItem("item3", 123.2, 321.3, null),
            ReceiptItem("item4", 123.2, 321.3, "items")
        )
    ))
}