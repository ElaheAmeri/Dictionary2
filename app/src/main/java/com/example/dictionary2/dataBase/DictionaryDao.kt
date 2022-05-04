package com.example.dictionary2.dataBase

import androidx.room.*

@Dao
interface DictionaryDao {
    @Insert
    fun insertAll(vararg words :List<Word>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)

    @Delete
    fun delet(word: Word)

    @Update
    fun update(word: Word)

    @Query("SELECT * FROM Word WHERE ENGWord IN(:ENGWord) ")
    fun getWord(ENGWord : String): Word

    @Query("SELECT * FROM Word ")
    fun getAllWord():List<Word>
}