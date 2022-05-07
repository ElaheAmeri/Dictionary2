package com.example.dictionary2.dataBase


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class],version = 1)
abstract class AppDataBase() : RoomDatabase(){
    abstract fun DictionaryDao(): DictionaryDao

        companion object {
            @Volatile
            private var INSTANCE: AppDataBase? = null

            fun getMyDataBase(context: Context): AppDataBase {
                val tempInstance = INSTANCE
                if (tempInstance != null)
                    return tempInstance

                synchronized(AppDataBase::class) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java, "MyDb232"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                    return instance
                }
            }


            fun destroyDataBase() {
                INSTANCE = null
            }

        }
    }