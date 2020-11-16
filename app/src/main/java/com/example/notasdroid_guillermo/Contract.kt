package com.example.notasdroid_guillermo

import android.provider.BaseColumns

class Contract {

    //Defino los campos de la tabla Usuario
    class Usuario:BaseColumns{
        companion object{
            val CORREO = "correo"
            val NOMBRE = "nombre"
            val PASS = "pass"
            val CICLO = "ciclo"
            val CURSO = "curso"
            val FOTO = "foto"
        }

    }

}