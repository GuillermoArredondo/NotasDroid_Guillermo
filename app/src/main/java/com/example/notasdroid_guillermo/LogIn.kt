package com.example.notasdroid_guillermo

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_log_in.*

class LogIn : AppCompatActivity() {
    val STATE_USER = "user"
    private var mUser: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            mUser = savedInstanceState.getString(STATE_USER);
        } else {
            // Probably initialize members with default values for a new instance
            mUser = "NewUser";
        }


        setContentView(R.layout.activity_log_in)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        iniciarSesion()

    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString(STATE_USER, mUser)
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState)
    }


    fun abrirRegistro(view: View){
        val intent = Intent(this, Registro::class.java)
        startActivity(intent)
    }

    //boton para iniciar sesion
    fun iniciarSesion(){
        btnLogin.setOnClickListener(){
            if (Utils.comprobarCredenciales(txtCorreoLogIn.text.toString(), txtPassLogIn.text.toString())){
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE,txtCorreoLogIn.text.toString())
                }
                startActivity(intent)
            }else{
                Toast.makeText(NotasDroid.CONTEXT, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}