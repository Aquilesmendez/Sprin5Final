package com.example.sprintfinalmodulo5

import android.content.Context
import com.example.sprintfinalmodulo5.primero.Zapatos
import com.google.gson.Gson

//Creamos la clase sharepreferences para la persistencia de datos.
class SharePreferences(val context: Context) {

    //Creamos una variable que guardara el nombre de nuestro sharepreference
    private val SHARED_COMPARTIDO = "MiDatBase"

    //Instanciamos las sharepreferences con el nombre storage.
    private val storage = context.getSharedPreferences(SHARED_COMPARTIDO, 0)
    //Creamos un arraylist para guardar las sharepreferences.
    private val zapatosList2 = ArrayList<Zapatos>()

    init {
        // Cargar los datos de SharedPreferences al inicializar la clase
        loadShoesFromPreferences()
    }

    //Creamos una funcion para guardar los datos.
    fun saveShoes(imagen: String,nombre: String, precio: String ) {
        //Creamos un nuevo objeto con los datos que recojemos de la eleccion del usuario.
        val zapatos = Zapatos(imagen,nombre, precio)

        zapatosList2.add(zapatos)

        // Guardar la lista actualizada en SharedPreferences
        saveShoesToPreferences()
    }

    //Funcion que devuelve el arraylist con los objetos guardados en las sharepreferences.
    fun getShoes(): ArrayList<Zapatos> {
        return zapatosList2
    }

    // Funcion que guarda el ArrayList como JSON en SharedPreferences.
    private fun saveShoesToPreferences() {
        val gson = Gson()
        val json = gson.toJson(zapatosList2)

        storage.edit().putString(SHARED_COMPARTIDO, json).apply()
    }

    // Funcion que carga los datos de SharedPreferences.
    private fun loadShoesFromPreferences() {
        val json = storage.getString(SHARED_COMPARTIDO, "") ?: ""
        if (json.isNotEmpty()) {
            val gson = Gson()
            val array = gson.fromJson(json, Array<Zapatos>::class.java)
            zapatosList2.addAll(array)
        }
    }

    //Funcion que borra todas las sharepreferences.
    fun borrarSharePreferences() {
        storage.edit().clear().apply()
        zapatosList2.clear()
    }

}
