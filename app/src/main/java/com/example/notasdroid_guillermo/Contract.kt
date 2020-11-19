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
    //Defino los campos de la tabla Modulo
    class Modulo:BaseColumns{
        companion object{
            val ID_MODULO = "id_modulo"
            val CICLO = "ciclo"
            val CURSO = "curso"
            val NOMBRE = "nombre"
            val FOTO_MODULO = "foto_modulo"
        }
    }

    //Defino los campos de la tabla Prueba
    class Prueba:BaseColumns{
        companion object{
            val CORREO = "correo"
            val ID_MODULO = "id_modulo"
            val NOMBRE = "nombre"
            val FECHA = "fecha"
            val NOTA = "nota"
            val REALIZADA = "realizada"
        }
    }

}