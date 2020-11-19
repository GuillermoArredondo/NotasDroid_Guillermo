package com.example.notasdroid_guillermo

import android.widget.Toast
import java.lang.Exception

//clase POJO Modulo
data class Modulo(var id_modulo:Int, var ciclo:Int, var curso:Int, var nombre:String, var foto_modeulo:Int)

class AdminModulo {

    //Obtengo los modulos segun ciclo y curso
    fun getModulos(ciclo: Int, curso:Int):ArrayList<Modulo>??{
        try {
            val db = NotasDroid.DB.readableDatabase
            val args = arrayOf(ciclo.toString(), curso.toString())
            val c = db.rawQuery("SELECT * FROM ${NotasDroid.TB_MODULOS} WHERE ${Contract.Modulo.CICLO}=? AND ${Contract.Modulo.CURSO}=?",args)
            val modulos = ArrayList<Modulo>()

            if (c.count == 0){
                Toast.makeText(NotasDroid.CONTEXT, "No se encontraron modulos", Toast.LENGTH_SHORT).show()
            }else{
                while(c.moveToNext()){
                    val modulo = Modulo(0,0,0,"",0)
                    modulo.id_modulo = c.getInt(0)
                    modulo.ciclo = c.getInt(1)
                    modulo.curso = c.getInt(2)
                    modulo.nombre = c.getString(3)
                    modulo.foto_modeulo = c.getInt(4)
                    modulos.add(modulo)
                }
            }
            c.close()
            db.close()
            return modulos
        }catch (ex: Exception) {
            Toast.makeText(NotasDroid.CONTEXT, "No se pudo obtener los modulos", Toast.LENGTH_SHORT).show()
            return null
        }
    }


}