package com.receiptkeep.app.model

data class ReceiptItem (
    val name : String,
    val price : Double,
    val currency : String, //do we need to save/pass currency value to each item separately?
    val quantity: Double,
    val quantityMeasure: String?, //in case if user is lazy to choose measure for smth obvious
)