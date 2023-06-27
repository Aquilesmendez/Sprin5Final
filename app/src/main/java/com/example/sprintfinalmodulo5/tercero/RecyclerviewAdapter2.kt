package com.example.sprintfinalmodulo5.tercero

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sprintfinalmodulo5.R
import com.example.sprintfinalmodulo5.databinding.ItemCarritoListaBinding
import com.example.sprintfinalmodulo5.primero.Zapatos
import com.google.android.material.textview.MaterialTextView

class RecyclerviewAdapter2(
    private val Arraylista: List<Zapatos>
) : RecyclerView.Adapter<RecyclerViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder2 {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecyclerViewHolder2(
            layoutInflater.inflate(
                R.layout.item_carrito_lista,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder2, position: Int) {
        val item = Arraylista[position]
        holder.Render(item)
    }


    override fun getItemCount(): Int {
        return Arraylista.size
    }
}

class RecyclerViewHolder2(view: View) : RecyclerView.ViewHolder(view) {
    private var Binding = ItemCarritoListaBinding.bind(view)

    private val tvNombreCarrito: MaterialTextView = Binding.tvNombreCarrito
    private val tvPrecioCarrito: MaterialTextView = Binding.tvPrecioCarrito
    private val ivImagenCarrito: ImageView = Binding.ivImagenCarrito

    fun Render(listaFuncion: Zapatos) {
        tvNombreCarrito.text = listaFuncion.nombre
        tvPrecioCarrito.text = listaFuncion.precio
        Glide.with(ivImagenCarrito.context).load(listaFuncion.imagen).into(ivImagenCarrito)
    }
}