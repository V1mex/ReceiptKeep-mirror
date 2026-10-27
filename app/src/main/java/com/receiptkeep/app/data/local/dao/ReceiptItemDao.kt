package com.receiptkeep.app.data.local.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import com.receiptkeep.app.data.local.entity.ReceiptItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReceiptItemDao {
    @Query("SELECT * FROM items WHERE receiptId = :id")
    fun getAllById(id: Long): Flow<List<ReceiptItemEntity>>

    @Insert
    suspend fun insert(receipt: ReceiptItemEntity)

    @Delete
    suspend fun delete(receipt: ReceiptItemEntity)
}