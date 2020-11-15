package com.example.notasdroid_guillermo

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*


class Registro : AppCompatActivity() {

    lateinit var ciclo : Spinner
    lateinit var curso : Spinner
    private val req_galeria = 0
    private val req_camara = 1
    var foto: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        cargarSpinnerCiclos()
        cargarSpinnerCursos()
        abrirGaleria()
        abrirCamara()
    }


    //pido los permisos para abrir la galeria
    private fun abrirGaleria(){
        btnGaleria.setOnClickListener(){
            val permiso = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            requestPermissions(permiso, req_galeria)
        }
    }

    //obtengo el resultado de pedir los permisos
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            req_galeria -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    mostrarGaleria()
                else
                    Toast.makeText(applicationContext, "No tienes permiso para acceder a la galería", Toast.LENGTH_SHORT).show()
            }
            req_camara -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    abrirCamara()
                else
                    Toast.makeText(applicationContext, "No tienes permiso para acceder a la cámara", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //muetsro la galeria
    private fun mostrarGaleria(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent,req_galeria)
    }



    //muestro la camara
    private fun abrirCamara(){
        btnCamara.setOnClickListener(){
            if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
                checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permisosCamara =
                    arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permisosCamara, req_camara)
            }else{
                mostrarCamara()
            }
        }

    }

    //abre la camara y hace la foto
    private fun mostrarCamara(){
        val value = ContentValues()
        value.put(MediaStore.Images.Media.TITLE, "Nueva Imagen")
        foto = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, value)
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, foto)
        startActivityForResult(intent, req_camara)
    }

    //si el usuario selecciona una imagen, la pongo en el imagenView
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode==req_galeria) {
            imaUsuario.setImageURI(data?.data)
        }
        if (resultCode == Activity.RESULT_OK && requestCode == req_camara) {
            imaUsuario.setImageURI(foto)
        }
    }

    //le doy las opciones al spinner de ciclos
    fun cargarSpinnerCiclos(){

        ciclo = findViewById(R.id.spinner) as Spinner
        val ciclos = arrayOf("DAM", "DAW", "ASIR")
        ciclo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ciclos)
    }

    //le doy las opciones al spinner de cursos
    fun cargarSpinnerCursos(){

        curso = findViewById(R.id.spinner2) as Spinner
        val cursos = arrayOf("1º", "2º")
        curso.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cursos)
    }


}