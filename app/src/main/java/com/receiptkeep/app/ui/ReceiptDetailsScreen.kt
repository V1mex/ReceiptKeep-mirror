package com.receiptkeep.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.innerShadow
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
    LazyColumn(modifier = Modifier.fillMaxWidth().padding(all = 16.dp)){
        item(){
            Column(){
                if (receipt.merchantName!=null)
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        text= stringResource(R.string.merchant_name, receipt.merchantName))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.date, receipt.date.toString()))
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.total_price, receipt.totalPrice.toString(), receipt.currency))
                if (receipt.note!=null)
                    Text(stringResource(R.string.note, receipt.note))
            }
            Spacer(modifier = Modifier.padding(6.dp))
        }
        items(items = receipt.items!!){ item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Text(
                    modifier = Modifier.weight(4f),
                    text = item.name)
                Spacer(modifier = Modifier.weight(0.1f))
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.price.toString())
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.currency)
                Spacer(modifier = Modifier.weight(0.1f))
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.quantity.toString())
                Text(
                    text = item.quantityMeasure.toString(),
                    modifier = Modifier.weight(1f))
            }
        }
        //TODO: fix - list looks bad with large names
        //TODO: add sticky header with column names
        //TODO: add optional photo link
        //TODO: add items editing feature
    }

}

@Preview(showBackground = true)
@Composable
fun ReceiptCardListPreview(){
    ReceiptDetailsScreen(receipt = Receipt(0L, "note",123.toDouble(),"UAH", merchantName = "name",
        items = listOf(
            ReceiptItem("item1", 123.2, "UAH", 321.3, "liters or very long item name?"),
            ReceiptItem("very very very very very very very very very very very very very very very very very long item2 name", 123.2, "UAH", 321.3, "kilograms"),
            ReceiptItem("item3", 146346723.2, "UAH", 321.3, null),
            ReceiptItem("item4", 123.2, "UAH", 321564.3, "items")
        )
    ))
}