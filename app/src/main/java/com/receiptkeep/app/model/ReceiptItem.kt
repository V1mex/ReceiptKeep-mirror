package com.receiptkeep.app.model

data class ReceiptItem (
    val name : String,
    val price : Double,
    val currency : String, //we don't need this. TODO: remove!
    val quantity: Double,
    val quantityMeasure: String?, //in case if user is lazy to choose measure for smth obvious
)