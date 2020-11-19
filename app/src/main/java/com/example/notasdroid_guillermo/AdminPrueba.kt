package com.example.notasdroid_guillermo

import android.widget.Toast
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

//clase POJO Modulo
data class Prueba(var correo:String, var id_modulo:Int, var nombre:String, var fecha: String,var nota:Double, var realizada:Int)

class AdminPrueba {

    //obtengo pruebas segun sus primary keys
    fun getPruebas(id_modulo: Int, correo: String):ArrayList<Prueba>??{
        try {
            val db = NotasDroid.DB.readableDatabase
            val args = arrayOf(id_modulo.toString(), correo)
            val c = db.rawQuery("SELECT * FROM ${NotasDroid.TB_PRUEBAS} WHERE ${Contract.Prueba.ID_MODULO}=? AND ${Contract.Prueba.CORREO}=?",args)
            val pruebas = ArrayList<Prueba>()

            if (c.count == 0){
                Toast.makeText(NotasDroid.CONTEXT, "No se encontraron pruebas", Toast.LENGTH_SHORT).show()
            }else{
                while(c.moveToNext()){

                    val prueba = Prueba("",0,"","",0.0,0)
                    prueba.correo = c.getString(0)
                    prueba.id_modulo = c.getInt(1)
                    prueba.nombre = c.getString(2)
                    prueba.fecha = c.getString(3)
                    prueba.nota = c.getDouble(4)
                    prueba.realizada = c.getInt(5)
                    pruebas.add(prueba)
                }
            }
            c.close()
            db.close()
            return pruebas
        }catch (ex: Exception) {
            Toast.makeText(NotasDroid.CONTEXT, "No se pudo obtener las pruebas", Toast.LENGTH_SHORT).show()
            return null
        }
    }
}