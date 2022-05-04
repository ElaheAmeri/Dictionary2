package com.example.dictionary2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.dictionary2.R
import com.example.dictionary2.dataBase.Word
import com.example.dictionary2.databinding.FragmentAddWordBinding
import com.example.dictionary2.viewModel.DictionaryViewModel


class AddWordFragment : Fragment() {


    var binding : FragmentAddWordBinding?=null
    val viewModel: DictionaryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddWordBinding.inflate(inflater,container,false)
        val view = binding!!.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.btnRegister.setOnClickListener {
            addWord(
                Word(4,
                    binding!!.editTextWord.toString()
                    ,binding!!.editTextTextWordMeans.toString()
                    ,binding!!.editTextExample.toString(),
                    binding!!.editTextSynonym.toString())
            )
            Toast.makeText(activity,"Word added", Toast.LENGTH_LONG).show()
        }


    }
    fun addWord(word: Word){
        viewModel.addWord(word)
    }


}