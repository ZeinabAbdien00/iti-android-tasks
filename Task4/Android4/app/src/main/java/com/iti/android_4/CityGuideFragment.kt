package com.iti.android_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.iti.android_4.databinding.FragmentCityGuideBinding


class CityGuideFragment : Fragment() {

    private lateinit var binding: FragmentCityGuideBinding
    private var string: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityGuideBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.apply {
            cbGas.setOnCheckedChangeListener { _, _ ->
                string += " " + cbGas.text.toString()
                Toast.makeText(requireContext(), string.toString(), Toast.LENGTH_SHORT).show()
            }
            cbCoffee.setOnCheckedChangeListener { _, _ ->
                string += " " + cbCoffee.text.toString()
                Toast.makeText(requireContext(), string.toString(), Toast.LENGTH_SHORT).show()

            }
            cbPharmacies.setOnCheckedChangeListener { _, _ ->
                string += " " + cbPharmacies.text.toString()
                Toast.makeText(requireContext(), string.toString(), Toast.LENGTH_SHORT).show()

            }
            cbHotel.setOnCheckedChangeListener { _, _ ->
                string += " " + cbHotel.text.toString()
                Toast.makeText(requireContext(), string.toString(), Toast.LENGTH_SHORT).show()

            }
            cbGym.setOnCheckedChangeListener { _, _ ->
                string += " " + cbGym.text.toString()
                Toast.makeText(requireContext(), string.toString(), Toast.LENGTH_SHORT).show()

            }
            cbGroceries.setOnCheckedChangeListener { _, _ ->
                string += " " + cbGroceries.text.toString()
                Toast.makeText(requireContext(), string.toString(), Toast.LENGTH_SHORT).show()

            }
            cbRestaurant.setOnCheckedChangeListener { _, _ ->
                string += " " + cbRestaurant.text.toString()
                Toast.makeText(requireContext(), string.toString(), Toast.LENGTH_SHORT).show()

            }

        }


    }

}