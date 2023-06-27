package com.example.sprintfinalmodulo5.tercero

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprintfinalmodulo5.R
import com.example.sprintfinalmodulo5.SharePreferences
import com.example.sprintfinalmodulo5.databinding.FragmentThirdBinding
import com.example.sprintfinalmodulo5.primero.Zapatos
import com.example.sprintfinalmodulo5.primero.ZapatosLista

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private lateinit var sharedPreferences: SharePreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        sharedPreferences = SharePreferences(requireContext())

        val zapatosList = sharedPreferences.getShoes()

        Log.d("SharedPreferences", "Número de Zapatos: ${zapatosList.size}")

        initializeRecyclerView(zapatosList)

        binding.btnAtras2.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        binding.btonBorrar.setOnClickListener{
            sharedPreferences.borrarSharePreferences()

            Toast.makeText(context,"EL CARRITO FUE ELIMINADO", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

    private fun initializeRecyclerView(zapatosList: ArrayList<Zapatos>) {
        val recyclerView = binding.recyclerview2
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecyclerviewAdapter2(zapatosList)
    }
}
