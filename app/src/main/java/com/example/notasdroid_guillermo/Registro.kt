package com.example.notasdroid_guillermo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner


class Registro : AppCompatActivity() {

    lateinit var ciclo : Spinner
    lateinit var curso : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        cargarSpinnerCiclos()
        cargarSpinnerCursos()
    }


    fun cargarSpinnerCiclos(){

        ciclo = findViewById(R.id.spinner) as Spinner
        val ciclos = arrayOf("DAM", "DAW", "ASIR")
        ciclo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ciclos)
    }

    fun cargarSpinnerCursos(){

        curso = findViewById(R.id.spinner2) as Spinner
        val cursos = arrayOf("1º", "2º")
        curso.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cursos)
    }

}