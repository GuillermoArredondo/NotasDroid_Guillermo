package com.example.notasdroid_guillermo

import android.util.Log
import android.widget.Toast
import java.lang.Exception

data class Usuario(var correo:String, var nombre:String, var pass:String, var ciclo:Int, var curso:Int, var foto:String)

class AdminUsuario {

    //Obtengo un usuario con filtro correo
    fun getUsuario(correo: String):Usuario?{
        try {
            var usuario = Usuario("","","",0,0,"")
            val db = NotasDroid.DB.readableDatabase
            val args = arrayOf(correo)
            val c = db.rawQuery("SELECT * FROM ${NotasDroid.TB_USUARIOS} WHERE ${Contract.Usuario.CORREO} = ?",args)
            if (c.moveToFirst()){
               do {
                   usuario = Usuario(c.getString(0), c.getString(1), c.getString(2), c.getInt(3),
                       c.getInt(4), c.getString(5))
               }while(c.moveToNext())
            }
            db.close()
            return usuario

        }catch (ex:Exception) {
            Toast.makeText(NotasDroid.CONTEXT, "No se pudo obtener el ususario", Toast.LENGTH_SHORT).show()
            return null
        }
    }


    //Insertar un usuario nuevo a la DB
    fun addUsuario(usuario: Usuario){
        try {
            val db = NotasDroid.DB.writableDatabase
            var qry = "INSERT INTO ${NotasDroid.TB_USUARIOS} (${Contract.Usuario.CORREO},${Contract.Usuario.NOMBRE}," +
                    "${Contract.Usuario.PASS},${Contract.Usuario.CICLO},${Contract.Usuario.CURSO},${Contract.Usuario.FOTO}) " +
                    "VALUES('${usuario.correo}','${usuario.nombre}','${usuario.pass}','${usuario.ciclo}','${usuario.curso}','${usuario.foto}');"
            db.execSQL(qry)
            Toast.makeText(NotasDroid.CONTEXT, "Usuario registrado", Toast.LENGTH_SHORT).show()
            db.close()
        }catch (ex:Exception){
            Toast.makeText(NotasDroid.CONTEXT, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show()
        }
    }
}