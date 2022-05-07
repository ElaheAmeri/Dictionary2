package com.example.dictionary2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dictionary2.R
import com.example.dictionary2.databinding.FragmentHomeBinding
import com.example.dictionary2.viewModel.DictionaryViewModel


class HomeFragment : Fragment() {


    val vmodel: DictionaryViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding
   // lateinit var wordSearched: Word
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//      go to add Fragment when btnAdd Clicked
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addWordFragment)
        }


//        search in word when btnSerch Clicked
        binding.btnSearch.setOnClickListener {
        if (vmodel.searchWord(binding.editTextSearch.text.toString()) != 0) {
            var wordSearched=vmodel.getWord(binding.editTextSearch.text.toString())
            binding.linearLayoutShowResult.visibility=View.VISIBLE
            binding.tvWordShow.text = wordSearched.ENGWord
            binding.tvWordMeanShow.text = wordSearched.persianWord
            binding.tvWordExampleShow.setText(wordSearched.example)
            binding.tvWordSinonynShow.setText(wordSearched.synonyms)
        }

           // checkExistWord()


        }
    }
    fun checkExistWord(){
      //  if (wordSearched==null){
//            activity?.let { dialog.show(it.supportFragmentManager, "NoticeDialogFragment")}
        //}
    }


}