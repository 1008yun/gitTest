package com.example.fragment_example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import com.example.hw2.R
import com.example.hw2.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.previous.setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
        //SecondFragment.arguments = bundle
        binding.show1.setText(arguments?.getString("DATA"))
        val temp ="com.example.hw2"+":drawable/"+arguments?.getString("DATA")+"_photo"
        //val tt = "@drawable/"
        //binding.show1.setText()
        val res = getResources().getIdentifier(temp, null,null)
        //binding.show1.setText(res.toString())
        //val tt = R.
        binding.img.setImageResource(res)
        return binding.root
    }
}