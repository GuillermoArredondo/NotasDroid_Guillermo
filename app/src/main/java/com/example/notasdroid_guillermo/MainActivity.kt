package com.example.notasdroid_guillermo

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    public var isClicEventoFila = true

    companion object{
        lateinit var adminMod: AdminModulo
    }

    var usuario = Usuario("","","",0,0,"")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.hide()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        val navView: NavigationView = findViewById(R.id.nav_view)
        val navHeader: View = navView.getHeaderView(0)
        var imaUsuarioNav = navHeader.findViewById<ImageView>(R.id.imaUsuarioNav)
        var txtNombreNav = navHeader.findViewById<TextView>(R.id.txtNombreNav)
        var txtCorreoNav = navHeader.findViewById<TextView>(R.id.txtCorreoNav)

        //asigno los datos del usuario al navHeader.
        val usuario : Usuario
        val correo = intent.getStringExtra(EXTRA_MESSAGE)
        Log.i("El correo seria este:", correo.toString())
        usuario = Utils.obtenerUsuario(correo.toString())!!
        txtNombreNav.setText(usuario.nombre)
        txtCorreoNav.setText(usuario.correo)
        imaUsuarioNav.setImageBitmap(Utils.base64ToBitmap(usuario.foto))

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        adminMod = AdminModulo()

        verModulos(rvMod2)
    }

    //funcion para cargar los modulos del usuario en el recyclerView
    private fun verModulos(view: RecyclerView){
        val correo = intent.getStringExtra(EXTRA_MESSAGE)
        usuario = Utils.obtenerUsuario(correo.toString())!!
        val listaModulos = adminMod.getModulos(usuario.ciclo, usuario.curso)
        Log.i("Cuenta de modulos:",listaModulos?.size.toString())
        val adapter = ModuloAdapter(this, listaModulos!!)
        val rvMod2: RecyclerView = findViewById(R.id.rvMod2)
        rvMod2.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager
        rvMod2.adapter = adapter

        adapter.setOnClickListener(listener = {
            abrirModulo(listaModulos[rvMod2.getChildAdapterPosition(view)])
        })
    }


    //funcion para abrir el fragment de las tareas de cada modulo
    private fun abrirModulo(modulo: Modulo){
        val transaccion = supportFragmentManager.beginTransaction().replace(R.id.container, PruebasFragment(usuario,modulo))
        transaccion.add(R.id.content,PruebasFragment(usuario,modulo),"Tal")
        transaccion.addToBackStack(null)
        transaccion.commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}