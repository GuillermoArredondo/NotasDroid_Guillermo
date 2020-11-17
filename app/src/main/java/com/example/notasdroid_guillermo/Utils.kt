package com.example.notasdroid_guillermo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream

object Utils {

    /**
     * Comprueba si las crendenciales del usuario son correctas
     * @param correo, pass (Strings)
     * @return Boolean
     */
    fun comprobarCredenciales(correo: String, pass: String): Boolean{
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

    fun obtenerUsuario(correo: String): Usuario?{
        val au = AdminUsuario()
        val usuario = au.getUsuario(correo)
        return usuario
    }

    /**
     * Convierte un Bitmap a una cadena Base64
     *
     * @param bitmap Bitmap
     * @return Cadena Base64
     */
    fun bitmapToBase64(bitmap: Bitmap): String? {
        // Comrimimos al 60 % la imagen
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream)
        val byteArray = stream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }


    /**
     * Convierte una cadena Base64 a Bitmap
     *
     * @param b64String cadena Base 64
     * @return Bitmap
     */
    fun base64ToBitmap(b64String: String): Bitmap? {
        val imageAsBytes: ByteArray = Base64.decode(b64String, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
    }

}