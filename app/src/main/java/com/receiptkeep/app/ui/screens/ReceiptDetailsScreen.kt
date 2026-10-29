package com.receiptkeep.app.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.receiptkeep.app.R
import com.receiptkeep.app.model.Receipt
import com.receiptkeep.app.model.ReceiptItem

@Composable
//fun ReceiptDetailsScreen(receiptId : Double){
//TODO: get receipt with receiptId from db IN ReceiptDetailsScreen VIEW MODEL
fun ReceiptDetailsScreen(receipt : Receipt){ //temporarily passing receipt to ReceiptDetailsScree
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 16.dp)
    ){
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
        items(items = receipt.items!!) { item ->
            var isExpanded by remember { mutableStateOf(false) }
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, color = Color.Black)
                    .padding(all = 3.dp)
                    .animateContentSize()
                    .clickable(onClick = { isExpanded = !isExpanded }),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                AnimatedVisibility(
                    visible = !isExpanded,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    @Composable
                    fun styledText(text: String, weight: Float, spacer: Boolean = true) {
                        Text(
                            text = text,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(weight)
                        )
                        if (spacer)
                            Spacer(modifier = Modifier.weight(0.2f))
                    }
                    Row() {
                        styledText(text = item.name, 2f)
                        styledText(item.price.toString(), 1.5f)
                        styledText(text = item.quantity.toString(), 1.7f)
                        styledText(item.quantityMeasure ?: "N/A", 1.5f, false) //hardcode
                        //TODO: create a list of possible measures,
                        // give ability to choose with dropdown and search,
                        // add to strings.xml (remove the hardcodes)
                        //TODO: same with currency
                    }
                }
                AnimatedVisibility(
                    visible = isExpanded,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    Column() {
                        Text(stringResource(R.string.item_name, item.name))
                        Text(
                            stringResource(
                                R.string.item_price,
                                item.price.toString(),
                                receipt.currency
                            )
                        )
                        Text(
                            stringResource(
                                R.string.item_quantity,
                                item.quantity.toString(),
                                item.quantityMeasure ?: "" //hardcode?
                            )
                        )
                    }
                }
            }
        }
        //TODO: add optional photo link
        //TODO: add items editing feature
        //TODO: define a numbers format (global settings option?)
        //TODO: ? global settings feature to always Expand?
    }

}

@Preview(showBackground = true)
@Composable
fun ReceiptCardListPreview(){
    ReceiptDetailsScreen(receipt = Receipt(0L, "note",123.toDouble(),"UAH", merchantName = "name",
        items = listOf(
            ReceiptItem("item1", 123.2, 321.3, "liters or very long item name?"),
            ReceiptItem("very very very very very very very very very very very very very very very very very long item2 name", 123.2, 321.3, "kilograms"),
            ReceiptItem("item3", 146346723.2, 321.3, null),
            ReceiptItem("item4", 123.2, 321564.3, "items")
        )
    ))
}