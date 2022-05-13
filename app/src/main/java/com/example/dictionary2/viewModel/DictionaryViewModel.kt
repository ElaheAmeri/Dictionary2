package com.example.dictionary2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dictionary2.dataBase.DictionaryRepository
import com.example.dictionary2.dataBase.Word
import kotlinx.coroutines.launch

class DictionaryViewModel(app: Application): AndroidViewModel(app) {
    val numberWord= MutableLiveData<Int>()
    init {

        DictionaryRepository.initDB(app.applicationContext)
    }
    fun addWord(word: Word){
        DictionaryRepository.insert(word)
    }

     fun searchWord(ENGWord:String):LiveData<Int>{
         var foundWord=MutableLiveData<Int>()
         viewModelScope.launch {
        val newWord=DictionaryRepository.searchWord(ENGWord)
             foundWord.value=newWord
         }
         return foundWord
    }

    fun getWord(ENG:String): Word{
        return DictionaryRepository.getWord(ENG)
    }

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
    fun buildWebSite(string: Word?) :String{
       val siteAddress="https://fa.wikipedia.org/wiki/$string"
        return siteAddress
    }
}