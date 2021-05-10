package com.example.hw2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val ballList = ArrayList<Balls>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private fun initBallList(){
        ballList.add(Balls("Baseball", R.drawable.baseball))
        ballList.add(Balls("Basketball", R.drawable.basketball))
        ballList.add(Balls("Football", R.drawable.football))
        ballList.add(Balls("Other", R.drawable.other))
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        //return binding.root
        initBallList()
        val layoutManager = LinearLayoutManager(getContext())
        binding.recycleView.layoutManager = layoutManager
        val adapter = BallAdapter(ballList)
        binding.recycleView.adapter = adapter
        binding.recycleView.addItemDecoration(DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL))
        //binding.text1.setText(layoutManager.toString())
        //val bun = Bundle()
        //bun.getArguments()
        //val data = getArguments().getString("DATA")
        //binding.text1.setText(arguments?.getString("DATA"))
        return binding.root
    }


}