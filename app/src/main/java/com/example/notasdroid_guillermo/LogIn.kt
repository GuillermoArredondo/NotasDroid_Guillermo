package com.example.notasdroid_guillermo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_log_in.*

class LogIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        iniciarSesion()

    }
    fun abrirRegistro(view: View){
        val intent = Intent(this,Registro::class.java)
        startActivity(intent)
    }

    //boton para iniciar sesion
    fun iniciarSesion(){
        btnLogin.setOnClickListener(){
            if (Utils.comprobarCredenciales(txtCorreoLogIn.text.toString(),txtPassLogIn.text.toString())){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(NotasDroid.CONTEXT, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}