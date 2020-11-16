package com.example.notasdroid_guillermo

object Utils {

    fun comprobarCredenciales(correo:String, pass:String): Boolean{
        var ok = false
        val au = AdminUsuario()
        val usuario = au.getUsuario(correo)

        if (usuario != null) {
            if (usuario.pass == pass){
                ok = true
            }
        }
        return ok
    }
}