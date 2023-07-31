package com.iti.android_6

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.iti.android_6.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentFirstBinding
    private var background: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.getBackgroundColor()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observation()
    }

    private fun observation() {

        viewModel.backgroundColor.observe(viewLifecycleOwner, Observer {
            viewModel.getBackgroundColor()

            if (it != null) {
                Log.d("suz", "1")
                binding.root.setBackgroundResource(it)
            }

        })
    }

}