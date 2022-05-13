package com.example.dictionary2.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.dictionary2.dataBase.DictionaryRepository
import com.example.dictionary2.dataBase.Word
import java.lang.Exception

class DictionaryViewModel(  app: Application): AndroidViewModel(app) {
    val numberWord= MutableLiveData<Int>()
    init {

        DictionaryRepository.initDB(app.applicationContext)
        //addWords(DictionaryRepository.wordList)
    }
    fun addWord(word: Word){
        var addFlag=false
        for (thisword in DictionaryRepository.getAllWord()){
            if (thisword ==word.ENGWord){
               addFlag=true

            }
        }
        if (!addFlag){
            DictionaryRepository.insert(word)
        }

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

    fun getall():List<String>{
        return DictionaryRepository.getAllWord()
    }



    fun buildWebSite(string: Word?) :String{
       val siteAddress="https://www.wikipedia.org/$string"
        return siteAddress
    }
}