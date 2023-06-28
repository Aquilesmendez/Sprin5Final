package com.example.sprintfinalmodulo5.segundo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.sprintfinalmodulo5.R
import com.example.sprintfinalmodulo5.SharePreferences
import com.example.sprintfinalmodulo5.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    //Creamos el objeto de la clase viewBinding.
    private lateinit var Binding: FragmentSecondBinding
    //Creamos un objeto de la clase sharePreferences.
    private lateinit var sharedPreferences: SharePreferences
    //Creamos las variables que vamos a recibir.
    private lateinit var tvNombre: String
    private lateinit var tvPrecio: String
    private lateinit var ivImagen: String


    //Verificamos y recuperamos los datos recibidos ademas de guardarlos en variables.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            tvNombre = bundle.getString("tvNombre").toString()
            tvPrecio = bundle.getString("tvPrecio").toString()
            ivImagen = bundle.getString("ivImagen").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Configuramos el objeto de la clase viewBindind y enlazamos el diseño con el codigo.
        Binding = FragmentSecondBinding.inflate(inflater, container, false)
        return Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Instanciamos el objeto de la clase sharePreferences.
        sharedPreferences = SharePreferences(requireContext())

        //Cargamos los datos recibidos en nuestra vista.
        Glide.with(requireContext())
            .load(ivImagen)
            .into(Binding.ivImagenRecibida)
        Binding.tvNombreRecibido.setText(tvNombre)
        Binding.tvPrecioRecibido.setText((tvPrecio))

        //Creamos un envento escuchador para regresar a la pantalla anterior.
        Binding.btnAtras.setOnClickListener {
            Navigation.findNavController(Binding.root)
                .navigate(R.id.action_secondFragment_to_firstFragment)
        }

        //Creamos un evento escuchador para agregar al carrito y mostrar un mensaje exitoso.
        Binding.btonIrCarrito.setOnClickListener {

            //LLamamos a la funcion para guardar datos en el sharepreferences.
            sharedPreferences.saveShoes( ivImagen,tvNombre, tvPrecio)

            Toast.makeText(context,"EL PRODUCTO FUE AÑADIDO EXITOSAMENTE", Toast.LENGTH_LONG).show()
        }
    }
}