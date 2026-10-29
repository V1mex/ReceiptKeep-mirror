package com.receiptkeep.app.data.local

import androidx.room3.ColumnTypeConverters
import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.receiptkeep.app.data.local.dao.ReceiptDao
import com.receiptkeep.app.data.local.dao.ReceiptItemDao
import com.receiptkeep.app.data.local.entity.ReceiptEntity
import com.receiptkeep.app.data.local.entity.ReceiptItemEntity

@Database(
    entities = [
        ReceiptEntity::class,
        ReceiptItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
@ColumnTypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun receiptDao(): ReceiptDao
    abstract fun receiptItemDao(): ReceiptItemDao
}