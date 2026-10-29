package com.receiptkeep.app.model

data class ReceiptItem (
    val name : String,
    val price : Double,
    val quantity: Double,
    val quantityMeasure: String?,
)