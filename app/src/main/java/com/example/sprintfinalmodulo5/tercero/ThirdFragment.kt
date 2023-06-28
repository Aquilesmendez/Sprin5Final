package com.example.sprintfinalmodulo5.tercero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprintfinalmodulo5.R
import com.example.sprintfinalmodulo5.SharePreferences
import com.example.sprintfinalmodulo5.databinding.FragmentThirdBinding
import com.example.sprintfinalmodulo5.primero.Zapatos

class ThirdFragment : Fragment() {

    //Creamos  el objeto de la clase viewBinding.
    private lateinit var binding: FragmentThirdBinding
    //Creamos un objeto de la clase sharePreferences.
    private lateinit var sharedPreferences: SharePreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Configuramos el objeto viewBinding y enlazamos la vista al codigo.
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Instanciamos el valor de la sharepreferences.
        sharedPreferences = SharePreferences(requireContext())

        //LLamamos al metodo para mostrar los zapatos que devuelve un array y lo guardamos en una variable.
        val zapatosList = sharedPreferences.getShoes()

        //LLamamos a la funcion del recyclerview.
        initializeRecyclerView(zapatosList)

        //Creamos el evento esuchador para el boton de retroceder.
        binding.btnAtras2.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        //Creamos el evento escuchador para el boton de borrar las sharepreferences.
        binding.btonBorrar.setOnClickListener{
            sharedPreferences.borrarSharePreferences()
            Toast.makeText(context,"EL CARRITO FUE ELIMINADO", Toast.LENGTH_LONG).show()
        }
    }
    //Funcion que inicia y configura el recyclerview.
    private fun initializeRecyclerView(zapatosList: ArrayList<Zapatos>) {
        val recyclerView = binding.recyclerview2
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerviewAdapter2(zapatosList)
    }
}
