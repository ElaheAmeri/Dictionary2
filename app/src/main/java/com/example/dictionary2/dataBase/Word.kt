package com.example.dictionary2.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(@PrimaryKey(autoGenerate=true) var id :Int,
                var ENGWord :String,
                var persianWord :String,
                var example:String,
                var synonyms :String)
