package com.example.dictionary2.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dictionary2.R
import com.example.dictionary2.databinding.FragmentDetailsBinding
import com.example.dictionary2.viewModel.DictionaryViewModel


class DetailsFragment : Fragment() {
   lateinit var binding :FragmentDetailsBinding
    val vmodel: DictionaryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val passedWord=arguments?.getString("word")
        var wordSearched= passedWord?.let { vmodel.getWord(it) }
        binding.tvWordShow.setText("word : ${wordSearched?.ENGWord}")
        binding.tvWordMeanShow.setText("word Mean : ${wordSearched?.persianWord}")
        binding.tvWordExampleShow.setText("word example : ${wordSearched?.example}")
        binding.tvWordSinonynShow.setText("word Sinonyn : ${wordSearched?.synonyms}")
        binding.btnLink.setOnClickListener(){
                binding.webView.loadUrl(vmodel.buildWebSite(wordSearched))}
        binding.btnDelete.setOnClickListener(){
            if (wordSearched != null) {
                vmodel.deleteWord(wordSearched)
                findNavController().navigate(R.id.action_detailsFragment_to_homeFragment)
            }
            else{
                Toast.makeText(activity,"Enter the desired word", Toast.LENGTH_LONG).show()
            }
        }
    }

}