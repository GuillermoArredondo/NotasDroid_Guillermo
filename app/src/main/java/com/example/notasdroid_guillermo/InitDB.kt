package com.example.notasdroid_guillermo

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class InitDB: SQLiteOpenHelper(NotasDroid.CONTEXT, NotasDroid.DB_NAME, null, NotasDroid.VERSION) {

    val qryCreaTabla = "CREATE TABLE ${NotasDroid.TB_USUARIOS}(" +
            "${Contract.Usuario.CORREO} TEXT PRIMARY KEY," +
            "${Contract.Usuario.NOMBRE} TEXT NOT NULL," +
            "${Contract.Usuario.PASS} TEXT NOT NULL," +
            "${Contract.Usuario.CICLO} TEXT NOT NULL," +
            "${Contract.Usuario.CURSO} TEXT NOT NULL," +
            "${Contract.Usuario.FOTO} TEXT NOT NULL);"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(qryCreaTabla)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS "+ NotasDroid.TB_USUARIOS)
        db.execSQL(qryCreaTabla)

    }
}