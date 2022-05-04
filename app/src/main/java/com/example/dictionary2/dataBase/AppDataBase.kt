package com.example.dictionary2.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class],version = 1)
abstract class AppDataBase() : RoomDatabase(){
    abstract fun DictionaryDao(): DictionaryDao
    companion object {
        lateinit var INCTANCE : AppDataBase
        fun getAppDatabase(context: Context): AppDataBase {
            synchronized(AppDataBase::class) {
                INCTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java, "DictionaryDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INCTANCE
        }

    }
}