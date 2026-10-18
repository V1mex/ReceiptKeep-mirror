package com.receiptkeep.app

import android.app.Application
import androidx.room3.Room
import com.receiptkeep.app.data.local.AppDatabase
import kotlin.getValue

class App : Application() {
    val database by lazy{
        Room.databaseBuilder(this, AppDatabase::class.java, "receiptkeep.db").build()
    }
}