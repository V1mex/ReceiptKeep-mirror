package com.receiptkeep.app.model

import java.time.LocalDate

data class Receipt (
    val id : Long = 0L,
    val note : String? = null,
    val totalPrice : Double,
    val currency : String,
    val date : LocalDate = LocalDate.now(),
    val merchantName : String? = null,
    val imageUri : String? = null //TODO: cant be null, but for temp preview testing
)