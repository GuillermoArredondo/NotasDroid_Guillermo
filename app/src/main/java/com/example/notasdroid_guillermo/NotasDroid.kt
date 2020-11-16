package com.example.notasdroid_guillermo

import android.app.Application
import android.content.Context

class NotasDroid :Application(){

    companion object{
        lateinit var CONTEXT : Context
        lateinit var DB : InitDB
        val DB_NAME = "NotasDroidDB"
        val VERSION = 5
        val TB_USUARIOS = "tbUsuarios"
    }


    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        DB = InitDB()
    }
}