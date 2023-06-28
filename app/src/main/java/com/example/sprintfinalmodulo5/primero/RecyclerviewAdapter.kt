package com.example.sprintfinalmodulo5.primero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sprintfinalmodulo5.R
import com.example.sprintfinalmodulo5.databinding.ItemZapatosListaBinding
import com.google.android.material.textview.MaterialTextView

//Creamos la clase adapter del recyclerview.
class RecyclerviewAdapter(private val arrayLista: List<Zapatos>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    //Funcion que enlaza la vista con el adaptador.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecyclerViewHolder(
            layoutInflater.inflate(
                R.layout.item_zapatos_lista,
                parent,
                false
            )
        )
    }

    //Funcion que pinta los datos en el recyclerview.
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = arrayLista[position]
        holder.Render(item)
    }

    //Metodo que devuelve el tamaño del arraylist.
    override fun getItemCount(): Int {
        return arrayLista.size
    }
}

// Creamos la clase interna RecyclerViewHolder.
class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //Iniciamos la variable de la clase viewBinding.
    private val Binding = ItemZapatosListaBinding.bind(view)

    //Accedemos a los widgets de nuestro layout molde.
    private val imagen: ImageView = Binding.ivZapatos
    private val tvNombre: MaterialTextView = Binding.tvNombre
    private val tvPrecio: MaterialTextView = Binding.tvPrecio

    //Creamos una funcion para que sete los valores del layout molde.
    fun Render(listaFuncion: Zapatos) {
        tvNombre.text = listaFuncion.nombre
        tvPrecio.text = listaFuncion.precio
        Glide.with(imagen.context).load(listaFuncion.imagen).into(imagen)

        //Creamos un evento escuchador para pasar los datos del item seleccionado
        imagen.setOnClickListener {
            //Objeto bundle para poder llevar los datos requeridos.
            val bundle = Bundle()
            bundle.putString("tvNombre", listaFuncion.nombre)
            bundle.putString("tvPrecio", listaFuncion.precio)
            bundle.putString("ivImagen", listaFuncion.imagen)

            //Comando para pasar al siguiente Fragmento.
            Navigation.findNavController(Binding.root)
                .navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }
}

