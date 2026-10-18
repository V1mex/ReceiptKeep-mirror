package com.receiptkeep.app.data.local.entity

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "receipts")
data class ReceiptEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val note: String? = null,
    val totalPrice: Double,
    val currency: String,
    val date: String,
    val merchantName: String? = null,
    val imageUri: String? = null
)