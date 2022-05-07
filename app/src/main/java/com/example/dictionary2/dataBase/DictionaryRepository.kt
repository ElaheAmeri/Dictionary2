package com.example.dictionary2.dataBase

import android.content.Context

object DictionaryRepository {
    lateinit var db: AppDataBase
    lateinit var dao: DictionaryDao
//    var wordList= listOf<Word>(
//        Word( 1,"Hello","سلام","Hello My friend","Hi"),
//        Word(2,"Success","موفقیت","Success awaits you","Smash"),
//        Word(3,"Dream","رویا","Don't Let Your Dream Be Dream","Growing")
//    )
    fun initDB(context: Context):AppDataBase{
        db = AppDataBase.getMyDataBase(context)
        dao = db.DictionaryDao()
        return db
    }

    fun searchWord(ENGWord:String):Int{
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


//    fun insertListOfWord(words:List<Word>){
//        dao.insertAll(words)
//    }
}