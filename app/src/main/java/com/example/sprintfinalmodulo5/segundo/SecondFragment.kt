package com.example.sprintfinalmodulo5.segundo

import android.os.Bundle
import android.util.Log
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

    private lateinit var Binding: FragmentSecondBinding
    private lateinit var tvNombre: String
    private lateinit var tvPrecio: String
    private lateinit var ivImagen: String


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
        Binding = FragmentSecondBinding.inflate(inflater, container, false)
        return Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = SharePreferences(requireContext())

        Glide.with(requireContext())
            .load(ivImagen)
            .into(Binding.ivImagenRecibida)
        Binding.tvNombreRecibido.setText(tvNombre)
        Binding.tvPrecioRecibido.setText((tvPrecio))


        Binding.btnAtras.setOnClickListener {
            Navigation.findNavController(Binding.root)
                .navigate(R.id.action_secondFragment_to_firstFragment)
        }

        Binding.btonIrCarrito.setOnClickListener {

            sharedPreferences.saveShoes( ivImagen,tvNombre, tvPrecio)

            Toast.makeText(context,"EL PRODUCTO FUE AÑADIDO EXITOSAMENTE", Toast.LENGTH_LONG).show()
        }
    }
}