package com.example.sprintfinalmodulo5.primero

import com.example.sprintfinalmodulo5.primero.Zapatos

//Creamos una clase que se puede acceder a ella con el metodo companion.
class ZapatosLista {
    companion object{
        //Creamos nuestra lista de la clase creada y ingresamos los objetos deseados.
        val lista = listOf<Zapatos>(
            Zapatos("https://www.dcshoes.cl/media/catalog/product/a/d/adys300744_dcxkcg_1_1.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            "ZAPATILLA HOMBRE KALIS MID WINTERIZE","$74.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/a/d/adys100551_dcwgn_1_1.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:",
            "ZAPATILLA HOMBRE CENTRAL","$44.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/a/d/adys100442_dcbyr_1_2.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=&width=&canvas=:",
            "ZAPATILLA HOMBRE CT GRAFFIK SQ","$69.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/3/0/300529_dcwlk_1_1_1_10.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            "ZAPATILLAS COURT GRAFFIK DE HOMBRE","$69.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/a/d/adbs300378_dcblw_1_1.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            "ZAPATILLA NIÑO MANTECA 4 VELCRO","$34.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/a/d/adbs300376_dcbs5_1_1.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            "ZAPATILLA NIÑO PURE VELCRO","$34.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/a/d/adbs300324_dcwyr_1.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            "ZAPATILLA NIÑO PURE HIGH ELASTIC LACE","$54.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/d/c/dc300678_dcppf_1_1.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            "ZAPATILLA MUJER COURT GRAFFIK","$64.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/a/d/adjs100156_dcgds_1_1.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            "ZAPATILLA MUJER MANTECA PLATAFORMA","$69.990"),
            Zapatos("https://www.dcshoes.cl/media/catalog/product/3/0/300678_dclep_1_1.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560",
            "ZAPATILLA MUJER COURT GRAFFIK","$39.990")
        )


    }
}