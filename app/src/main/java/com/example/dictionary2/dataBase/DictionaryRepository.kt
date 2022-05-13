package com.example.dictionary2.dataBase

import android.content.Context

object DictionaryRepository {
    lateinit var db: AppDataBase
    lateinit var dao: DictionaryDao

    fun initDB(context: Context):AppDataBase{
        db = AppDataBase.getMyDataBase(context)
        dao = db.DictionaryDao()
        return db
    }

    suspend fun searchWord(ENGWord:String):Int{
        return dao.searchWord(ENGWord)
    }

    fun getWord(ENG:String): Word{
        return dao.getWord(ENG)
    }
    fun deletWord(word: Word){
        dao.delet(word)
    }
    fun updateTable(word: Word){
        dao.update(word)
    }
    fun getAllWord():List<Word>{
        return dao.getAllWord()
    }
    fun insert(word: Word){
        dao.insert(word)
    }

}