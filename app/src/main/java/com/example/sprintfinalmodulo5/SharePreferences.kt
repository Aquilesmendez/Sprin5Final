package com.example.sprintfinalmodulo5

import android.content.Context
import android.content.SharedPreferences
import com.example.sprintfinalmodulo5.primero.Zapatos
import com.google.gson.Gson

class SharePreferences(val context: Context) {

    private val SHARED_COMPARTIDO = "MiDatBase"

    private val storage = context.getSharedPreferences(SHARED_COMPARTIDO, 0)
    private val zapatosList2 = ArrayList<Zapatos>()

    init {
        // Cargar los datos de SharedPreferences al inicializar la clase
        loadShoesFromPreferences()
    }

    fun saveShoes(imagen: String,nombre: String, precio: String ) {
        // Crear un nuevo objeto Zapatos con los valores proporcionados
        val zapatos = Zapatos(imagen,nombre, precio)

        // Agregar el objeto Zapatos a la lista
        zapatosList2.add(zapatos)

        // Guardar la lista actualizada en SharedPreferences
        saveShoesToPreferences()

        // Alternativamente, si solo deseas mantener el último objeto Zapatos en lugar de una lista
        // puedes reemplazar el ArrayList por una variable individual y guardarla directamente en SharedPreferences.

    }

    fun getShoes(): ArrayList<Zapatos> {
        return zapatosList2
    }

    private fun saveShoesToPreferences() {
        val gson = Gson()
        val json = gson.toJson(zapatosList2)

        storage.edit().putString(SHARED_COMPARTIDO, json).apply()
    }

    private fun loadShoesFromPreferences() {
        val json = storage.getString(SHARED_COMPARTIDO, "") ?: ""
        if (json.isNotEmpty()) {
            val gson = Gson()
            val array = gson.fromJson(json, Array<Zapatos>::class.java)
            zapatosList2.addAll(array)
        }
    }

    fun borrarSharePreferences() {
        storage.edit().clear().apply()
        zapatosList2.clear()
    }

}
