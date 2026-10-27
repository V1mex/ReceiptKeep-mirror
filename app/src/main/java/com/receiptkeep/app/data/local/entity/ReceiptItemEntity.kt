package com.receiptkeep.app.data.local.entity

import androidx.room3.Entity
import androidx.room3.ForeignKey
import androidx.room3.PrimaryKey

@Entity(
    tableName = "items",
    foreignKeys = [
        ForeignKey(
            entity = ReceiptEntity::class,
            parentColumns = ["id"],
            childColumns = ["receiptId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ReceiptItemEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val name : String,
    val price : Double,
    val quantity: Double,
    val quantityMeasure: String?,
    val receiptId: Long
)