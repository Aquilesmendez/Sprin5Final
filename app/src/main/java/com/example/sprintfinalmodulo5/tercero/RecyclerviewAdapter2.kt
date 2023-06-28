package com.example.sprintfinalmodulo5.tercero

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
//Creamos la clase adapter del recyclerview.
class RecyclerviewAdapter2(
    private val Arraylista: List<Zapatos>
) : RecyclerView.Adapter<RecyclerViewHolder2>() {

    //Funcion que enlaza la vista con el adaptador.
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
    //Funcion que pinta los datos en el recyclerview.
    override fun onBindViewHolder(holder: RecyclerViewHolder2, position: Int) {
        val item = Arraylista[position]
        holder.Render(item)
    }

    //Metodo que devuelve el tamaño del arraylist.
    override fun getItemCount(): Int {
        return Arraylista.size
    }
}
// Creamos la clase interna RecyclerViewHolder.
class RecyclerViewHolder2(view: View) : RecyclerView.ViewHolder(view) {
    //Iniciamos la variable de la clase viewBinding.
    private var Binding = ItemCarritoListaBinding.bind(view)

    //Accedemos a los widgets de nuestro layout molde.
    private val tvNombreCarrito: MaterialTextView = Binding.tvNombreCarrito
    private val tvPrecioCarrito: MaterialTextView = Binding.tvPrecioCarrito
    private val ivImagenCarrito: ImageView = Binding.ivImagenCarrito

    //Creamos una funcion para que sete los valores del layout molde.
    fun Render(listaFuncion: Zapatos) {
        tvNombreCarrito.text = listaFuncion.nombre
        tvPrecioCarrito.text = listaFuncion.precio
        Glide.with(ivImagenCarrito.context).load(listaFuncion.imagen).into(ivImagenCarrito)
    }
}