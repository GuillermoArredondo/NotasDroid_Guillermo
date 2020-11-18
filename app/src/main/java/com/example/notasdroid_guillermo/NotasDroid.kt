package com.example.notasdroid_guillermo

import android.app.Application
import android.content.Context

class NotasDroid :Application(){

    companion object{
        lateinit var CONTEXT : Context
        lateinit var DB : InitDB
        val DB_NAME = "NotasDroidDB"
        val VERSION = 9
        val TB_USUARIOS = "tbUsuarios"
        val TB_MODULOS = "tbModulos"
        val TB_PRUEBAS = "tbPruebas"
    }


    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        DB = InitDB()
    }
}