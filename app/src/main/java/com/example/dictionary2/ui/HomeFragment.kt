package com.example.dictionary2.ui

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dictionary2.R
import com.example.dictionary2.databinding.FragmentHomeBinding
import com.example.dictionary2.viewModel.DictionaryViewModel


class HomeFragment : Fragment() {


    val vmodel: DictionaryViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding
    lateinit var myWebView:WebView
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
            val bundle = bundleOf("word" to binding.editTextSearch.text.toString() )
            findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,bundle)

        }
        else{
                Toast.makeText(activity,"There is no searched word in the database",Toast.LENGTH_LONG)
                    .show()
        }
        }

    }

}