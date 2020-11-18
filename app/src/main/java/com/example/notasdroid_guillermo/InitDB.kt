package com.example.notasdroid_guillermo

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class InitDB: SQLiteOpenHelper(NotasDroid.CONTEXT, NotasDroid.DB_NAME, null, NotasDroid.VERSION) {



    val qryCreaTabla = "CREATE TABLE ${NotasDroid.TB_USUARIOS}(" +
            "${Contract.Usuario.CORREO} TEXT PRIMARY KEY," +
            "${Contract.Usuario.NOMBRE} TEXT NOT NULL," +
            "${Contract.Usuario.PASS} TEXT NOT NULL," +
            "${Contract.Usuario.CICLO} INTEGER NOT NULL," +
            "${Contract.Usuario.CURSO} INTEGER NOT NULL," +
            "${Contract.Usuario.FOTO} TEXT NOT NULL);" +
            "CREATE TABLE ${NotasDroid.TB_MODULOS}(" +
            "${Contract.Modulo.ID_MODULO} INTEGER PRIMARY KEY," +
            "${Contract.Modulo.CICLO} INTEGER NOT NULL, " +
            "${Contract.Modulo.CURSO} INTEGER NOT NULL, " +
            "${Contract.Modulo.NOMBRE} TEXT NOT NULL, " +
            "${Contract.Modulo.FOTO_MODULO} INTEGER NOT NULL); " +
            "CREATE TABLE ${NotasDroid.TB_PRUEBAS}( " +
            "${Contract.Prueba.CORREO} TEXT, " +
            "${Contract.Prueba.ID_MODULO} INTEGER, " +
            "${Contract.Prueba.NOMBRE} TEXT, " +
            "${Contract.Prueba.FECHA} DATE, " +
            "${Contract.Prueba.NOTA} REAL, " +
            "${Contract.Prueba.REALIZADA} INTEGER," +
            "PRIMARY KEY(${Contract.Prueba.CORREO},${Contract.Prueba.ID_MODULO}), " +
            "FOREIGN KEY(${Contract.Prueba.CORREO}) REFERENCES ${NotasDroid.TB_USUARIOS}(${Contract.Usuario.CORREO}), " +
            "FOREIGN KEY(${Contract.Modulo.ID_MODULO}) REFERENCES ${NotasDroid.TB_MODULOS}(${Contract.Modulo.ID_MODULO})); " +
            "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(1,0,0,'Implantación de sistemas operativos',1); " +
            "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(2,0,0,'Planificación y administración de redes',2);"

    val query2 = "CREATE TABLE ${NotasDroid.TB_MODULOS}(" +
            "${Contract.Modulo.ID_MODULO} INTEGER PRIMARY KEY," +
            "${Contract.Modulo.CICLO} INTEGER NOT NULL, " +
            "${Contract.Modulo.CURSO} INTEGER NOT NULL, " +
            "${Contract.Modulo.NOMBRE} TEXT NOT NULL, " +
            "${Contract.Modulo.FOTO_MODULO} INTEGER NOT NULL); "

    val query3 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(1,0,0,'Implantación de sistemas operativos',1); " +
            "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(2,0,0,'Planificación y administración de redes',2);"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(qryCreaTabla)
        db!!.execSQL(query2)
        db!!.execSQL(query3)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS "+ NotasDroid.TB_USUARIOS)
        db!!.execSQL("DROP TABLE IF EXISTS "+ NotasDroid.TB_MODULOS)
        db!!.execSQL("DROP TABLE IF EXISTS "+ NotasDroid.TB_PRUEBAS)
        db.execSQL(qryCreaTabla)
        db!!.execSQL(query2)
        db!!.execSQL(query3)

    }
}