package com.example.notasdroid_guillermo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_tareas.rvPrueba

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TareasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PruebasFragment(private val usuario:Usuario, private val modulo:Modulo) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Usuario = usuario
    private var param2: Modulo = modulo




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)

            verPruebas(rvPrueba)
        }
        context
        adminPrueba = AdminPrueba()
    }

    private fun verPruebas(view: RecyclerView){
        val listaPruebas = adminPrueba.getPruebas(modulo.id_modulo,usuario.correo)
        val adapter = PruebaAdapter(requireContext(),listaPruebas!!)
        rvPrueba.layoutManager = LinearLayoutManager(requireContext()) as RecyclerView.LayoutManager
        rvPrueba.adapter = adapter


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tareas, container, false)
    }

    companion object {

        lateinit var adminPrueba: AdminPrueba

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TareasFragment.
         */
        // TODO: Rename and change types and number of parameters
        //@JvmStatic
        //fun newInstance(param1: String, param2: String) =
        //    PruebasFragment().apply {
        //        arguments = Bundle().apply {
        //            putString(ARG_PARAM1, param1)
        //            putString(ARG_PARAM2, param2)
        //        }
        //    }
    }
}