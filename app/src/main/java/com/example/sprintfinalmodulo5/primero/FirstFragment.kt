package com.example.sprintfinalmodulo5.primero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sprintfinalmodulo5.R
import com.example.sprintfinalmodulo5.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {


    //Instanciamos nuestra clase viewBinding
    private lateinit var binding: FragmentFirstBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCarrito.setOnClickListener{
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        //Llamamos a la funcion que llama al adapatador.
        Inicializador()

    }

    fun Inicializador(){
        val recyclerView = binding.recyclerview1
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        recyclerView.adapter = RecyclerviewAdapter(ZapatosLista.lista)
    }
}