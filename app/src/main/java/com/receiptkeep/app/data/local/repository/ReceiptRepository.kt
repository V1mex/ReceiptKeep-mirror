package com.receiptkeep.app.data.repository

import com.receiptkeep.app.data.local.dao.ReceiptDao
import com.receiptkeep.app.data.local.dao.ReceiptItemDao
import com.receiptkeep.app.model.Receipt
import com.receiptkeep.app.model.ReceiptItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class ReceiptRepository(
    private val receiptDao: ReceiptDao,
    private val receiptItemDao: ReceiptItemDao
){
    fun getAllReceipts(): Flow<List<Receipt>> {
        return receiptDao.getAll().map { entities ->
            entities.map { entity ->
                Receipt(
                    id = entity.id,
                    note = entity.note,
                    totalPrice = entity.totalPrice,
                    currency = entity.currency,
                    date = LocalDate.parse(entity.date),
                    merchantName = entity.merchantName,
                    imageUri = entity.imageUri
                )
            }
        }
    }

    suspend fun getReceiptById(id: Long): Receipt? {
        return receiptDao.getById(id)?.let { entity ->
            Receipt(
                id = entity.id,
                note = entity.note,
                totalPrice = entity.totalPrice,
                currency = entity.currency,
                date = LocalDate.parse(entity.date),
                merchantName = entity.merchantName,
                imageUri = entity.imageUri
            )
        }
    }

    fun getItemsByReceiptId(receiptId: Long): Flow<List<ReceiptItem>> {
        return receiptItemDao.getAllById(receiptId).map { entities ->
            entities.map { entity ->
                ReceiptItem(
                    name = entity.name,
                    price = entity.price,
                    quantity = entity.quantity,
                    quantityMeasure = entity.quantityMeasure
                )
            }
        }
    }
}