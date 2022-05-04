package com.example.dictionary2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dictionary2.R
import com.example.dictionary2.dataBase.Word
import com.example.dictionary2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    val vmodel: DictionaryViewModel by viewModels()
    var binding: FragmentHomeBinding? = null
    var wordSearched: Word?=null
    val dialog = FirstDialogFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//      go to add Fragment when btnAdd Clicked
        binding!!.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addWordFragment)
        }


//        search in word when btnSerch Clicked
        binding!!.btnSearch.setOnClickListener {
            var wordSearched: Word
            wordSearched = vmodel.search(binding!!.editTextSearch.toString())
            checkExistWord()
            binding!!.linearLayoutShowResult.isVisible=true
            binding!!.tvWordShow.setText(wordSearched.ENGWord)
            binding!!.tvWordMeanShow.setText(wordSearched.persianWord)
            binding!!.tvWordExampleShow.setText(wordSearched.example)
            binding!!.tvWordSinonynShow.setText(wordSearched.synonyms)

        }
    }
    fun checkExistWord(){
        if (wordSearched==null){
            activity?.let { dialog.show(it.supportFragmentManager, "NoticeDialogFragment")}
        }
    }


}