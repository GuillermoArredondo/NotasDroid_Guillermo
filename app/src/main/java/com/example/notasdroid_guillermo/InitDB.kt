package com.example.notasdroid_guillermo

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class InitDB: SQLiteOpenHelper(NotasDroid.CONTEXT, NotasDroid.DB_NAME, null, NotasDroid.VERSION) {

    val q1 = "CREATE TABLE ${NotasDroid.TB_USUARIOS}(" +
            "${Contract.Usuario.CORREO} TEXT PRIMARY KEY," +
            "${Contract.Usuario.NOMBRE} TEXT NOT NULL," +
            "${Contract.Usuario.PASS} TEXT NOT NULL," +
            "${Contract.Usuario.CICLO} INTEGER NOT NULL," +
            "${Contract.Usuario.CURSO} INTEGER NOT NULL," +
            "${Contract.Usuario.FOTO} TEXT NOT NULL);"

    val q2 = "CREATE TABLE ${NotasDroid.TB_MODULOS}(" +
            "${Contract.Modulo.ID_MODULO} INTEGER PRIMARY KEY," +
            "${Contract.Modulo.CICLO} INTEGER NOT NULL, " +
            "${Contract.Modulo.CURSO} INTEGER NOT NULL, " +
            "${Contract.Modulo.NOMBRE} TEXT NOT NULL, " +
            "${Contract.Modulo.FOTO_MODULO} INTEGER NOT NULL);"

    val q3 = "CREATE TABLE ${NotasDroid.TB_PRUEBAS}( " +
            "${Contract.Prueba.CORREO} TEXT, " +
            "${Contract.Prueba.ID_MODULO} INTEGER, " +
            "${Contract.Prueba.NOMBRE} TEXT, " +
            "${Contract.Prueba.FECHA} TEXT, " +
            "${Contract.Prueba.NOTA} REAL, " +
            "${Contract.Prueba.REALIZADA} INTEGER," +
            "PRIMARY KEY(${Contract.Prueba.CORREO},${Contract.Prueba.ID_MODULO}), " +
            "FOREIGN KEY(${Contract.Prueba.CORREO}) REFERENCES ${NotasDroid.TB_USUARIOS}(${Contract.Usuario.CORREO}), " +
            "FOREIGN KEY(${Contract.Modulo.ID_MODULO}) REFERENCES ${NotasDroid.TB_MODULOS}(${Contract.Modulo.ID_MODULO}));"

    //ASIR 1
    val q4 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(1,0,0,'Implantación de sistemas operativos',2131165277);"
    val q5 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(2,0,0,'Planificación y administración de redes',2131165278);"
    val q6 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(3,0,0,'Fundamentos de hardware',2131165279);"
    val q7 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(4,0,0,'Gestión de bases de datos',2131165280);"
    val q8 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(5,0,0,'Lenguajes de marcas y sistemas de gestión de información',2131165281);"
    val q9 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(6,0,0,'Inglés técnico',2131165282);"
    val q10 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(7,0,0,'Formación y orientación laboral',2131165283);"
    //ASIR 2
    val q11 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(8,0,1,'Administración de sistemas operativos',2131165284);"
    val q12 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(9,0,1,'Servicios de red e Internet',2131165285);"
    val q13 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(10,0,1,'Implantación de aplicaciones web',2131165286);"
    val q14 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(11,0,1,'Administración de sistemas gestores de bases de datos',2131165287);"
    val q15 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(12,0,1,'Seguridad y alta disponibilidad',2131165288);"
    val q16 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(13,0,1,'Empresa e iniciativa emprendedora',2131165289);"
    val q17 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(14,0,1,'Proyecto de administracion de sistemas en red',2131165290);"
    val q18 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(15,0,1,'Formación en Centros de Trabajo',2131165291);"
    //DAM 1
    val q19 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(16,1,0,'Sistemas informáticos',2131165302);"
    val q20 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(17,1,0,'Bases de datos',2131165303);"
    val q21 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(18,1,0,'Programación',2131165304);"
    val q22 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(19,1,0,'Lenguajes de marcas y sistemas de información',2131165305);"
    val q23 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(20,1,0,'Entornos de desarrollo',2131165306);"
    val q24 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(21,1,0,'Inglés técnico',2131165307);"
    val q25 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(22,1,0,'Formación y orientación laboral',2131165308);"
    //DAM 2
    val q26 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(23,1,1,'Acceso a datos',2131165309);"
    val q27 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(24,1,1,'Desarrollo de interfaces',2131165310);"
    val q28 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(25,1,1,'Programación multimedia y dispositivos móviles',2131165311);"
    val q29 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(26,1,1,'Programación de servicios y procesos',2131165312);"
    val q30 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(27,1,1,'Sistemas de gestión empresarial',2131165313);"
    val q31 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(28,1,1,'Empresa e iniciativa emprendedora',2131165314);"
    val q32 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(29,1,1,'Proyecto de desarrollo de aplicaciones multiplataforma',2131165315);"
    val q33 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(30,1,1,'Formación en centros de trabajo',2131165316);"
    //DAW 1
    val q34 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(31,2,0,'Sistemas informáticos',2131165317);"
    val q35 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(32,2,0,'Bases de datos',2131165318);"
    val q36 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(33,2,0,'Programación',2131165319);"
    val q37 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(34,2,0,'Lenguajes de marcas y sistemas de información',2131165320);"
    val q38 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(35,2,0,'Entornos de desarrollo',2131165321);"
    val q39 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(36,2,0,'Inglés técnico',2131165322);"
    val q40 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(37,2,0,'Formación y orientación laboral',2131165323);"
    //DAW 2
    val q41 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(38,2,1,'Desarrollo web en entorno cliente',2131165324);"
    val q42 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(39,2,1,'Desarrollo web en entorno servidor',2131165325);"
    val q43 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(40,2,1,'Despliegue de aplicaciones web',2131165326);"
    val q44 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(41,2,1,'Diseño de interfaces web',2131165327);"
    val q45 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(42,2,1,'Proyecto de desarrollo de aplicaciones web',2131165328);"
    val q46 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(43,2,1,'Empresa e iniciativa emprendedora',2131165329);"
    val q47 = "INSERT INTO ${NotasDroid.TB_MODULOS} (${Contract.Modulo.ID_MODULO},${Contract.Modulo.CICLO},${Contract.Modulo.CURSO},${Contract.Modulo.NOMBRE},${Contract.Modulo.FOTO_MODULO}) VALUES(44,2,1,'Formación en Centros de Trabajo',2131165330);"

    val crearBBDD = arrayOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20,
                            q21, q22, q23, q24, q25, q26, q27, q28, q29, q30, q31, q32, q33, q34, q35, q36, q37, q38,
                            q39, q40, q41, q42, q43, q44, q45, q46, q47)

    override fun onCreate(db: SQLiteDatabase?) {
        for (query in crearBBDD) {
            db!!.execSQL(query)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS "+ NotasDroid.TB_USUARIOS)
        db!!.execSQL("DROP TABLE IF EXISTS "+ NotasDroid.TB_MODULOS)
        db!!.execSQL("DROP TABLE IF EXISTS "+ NotasDroid.TB_PRUEBAS)
        for (query in crearBBDD) {
            db!!.execSQL(query)
        }

    }
}