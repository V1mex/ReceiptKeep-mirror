package com.receiptkeep.app.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import com.receiptkeep.app.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import com.receiptkeep.app.model.Receipt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReceiptCard(receipt: Receipt, onClick: (Receipt) -> Unit){
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick(receipt) }
        .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
        .padding(all = 10.dp)){
        Text(
            text = stringResource(R.string.date, receipt.date.toString()),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)
        if(receipt.merchantName != null){
            Text(
                text = stringResource(
                R.string.merchant_name,
                receipt.merchantName),
                fontSize = 22.sp
            )
        }
        Text(
            text = stringResource(R.string.total_price, receipt.totalPrice.toString(), receipt.currency),
            fontSize = 22.sp
        )
        if(receipt.note != null){
            Text(
                text = stringResource(
                    R.string.note,
                    receipt.note),
                fontSize = 22.sp
            )
        }

    }
}