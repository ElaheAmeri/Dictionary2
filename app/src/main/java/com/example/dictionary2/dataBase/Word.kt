package com.example.dictionary2.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(@PrimaryKey val id :Int,
                val ENGWord :String,
                val persianWord :String,
                val example:String,
                val synonyms :String){
}