package com.receiptkeep.app.data.local

import androidx.room3.ColumnTypeConverter
import java.time.LocalDate

class Converters {
    @ColumnTypeConverter
    fun fromLocalDate(date: LocalDate): String = date.toString()

    @ColumnTypeConverter
    fun toLocalDate(value: String): LocalDate = LocalDate.parse(value)
}