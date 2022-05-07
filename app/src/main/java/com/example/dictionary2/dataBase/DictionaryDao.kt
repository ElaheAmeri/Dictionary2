package com.example.dictionary2.dataBase

import androidx.room.*

@Dao
interface DictionaryDao {
//    @Insert
//    fun insertAll(vararg words :List<Word>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)


    @Query("SELECT id FROM Word WHERE ENGWord IN (:ENG)")
    fun searchWord(ENG:String):Int

    @Query("SELECT * FROM Word WHERE ENGWord IN(:ENGWord) ")
    fun getWord(ENGWord : String): Word


    @Delete
    fun delet(word: Word)

    @Update
    fun update(word: Word)




    @Query("SELECT * FROM Word ")
    fun getAllWord():List<Word>
}