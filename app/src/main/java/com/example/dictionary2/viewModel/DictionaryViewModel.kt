package com.example.dictionary2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.dictionary2.dataBase.DictionaryRepository
import com.example.dictionary2.dataBase.Word

class DictionaryViewModel(app: Application): AndroidViewModel(app) {
    val numberWord= MutableLiveData<Int>()
    init {

        DictionaryRepository.initDB(app.applicationContext)
        //addWords(DictionaryRepository.wordList)
    }
    fun addWord(word: Word){
        DictionaryRepository.insert(word)
    }

    fun searchWord(ENGWord:String):Int{
        return DictionaryRepository.searchWord(ENGWord)
    }

    fun getWord(ENG:String): Word{
        return DictionaryRepository.getWord(ENG)
    }

//    fun addWords(words:List<Word>){
//        DictionaryRepository.insertListOfWord(words)
//    }
    fun deleteWord(word: Word){
        DictionaryRepository.deletWord(word)
    }

    fun getall():List<Word>{
        var wordList=listOf<Word>()
        wordList= DictionaryRepository.getAllWord()
        return wordList
    }


    fun returnNumberOfWord():Int{
        var listWord= listOf<Word>()
        listWord= DictionaryRepository.getAllWord()
        return listWord.lastIndex
    }
    fun buildWebSite(string: String) :String{
       val siteAddress="https://fa.wikipedia.org/wiki/$string"
        return siteAddress
    }
}