package com.receiptkeep.app.data.local.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import com.receiptkeep.app.data.local.entity.ReceiptEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReceiptDao {
    @Query("SELECT * FROM receipts ORDER BY date DESC")
    fun getAll(): Flow<List<ReceiptEntity>>

    @Query("Select * FROM receipts WHERE id = :id")
    suspend fun getById(id: Long): ReceiptEntity?

    @Insert
    suspend fun insert(receipt: ReceiptEntity)

    @Delete
    suspend fun delete(receipt: ReceiptEntity)
}