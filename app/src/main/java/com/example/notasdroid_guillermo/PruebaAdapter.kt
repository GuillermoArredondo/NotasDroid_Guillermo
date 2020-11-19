package com.example.notasdroid_guillermo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lo_prueba.view.*

class PruebaAdapter(ctx: Context, val pruebas: ArrayList<Prueba>): RecyclerView.Adapter<PruebaAdapter.ViewHolder>(){

    val ctx = ctx

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtNomPrueba = itemView.txtNomPrueba
        val txtFecha = itemView.txtFecha
        val txtRealizada = itemView.txtRealizada
        val txtNota = itemView.txtNota
        val btnEditar = itemView.btnEditar
        val btnBorrar = itemView.btnBorrar

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PruebaAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lo_prueba,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pruebas.size
    }

    override fun onBindViewHolder(holder: PruebaAdapter.ViewHolder, position: Int) {
        val prueba : Prueba = pruebas[position]
        holder.txtNomPrueba.text = prueba.nombre
        holder.txtFecha.text = prueba.fecha
        holder.txtNota.text = prueba.nota.toString()
        if (prueba.realizada == 0){
            holder.txtRealizada.text = "No realizada"
        }else{
            holder.txtRealizada.text = "Realizada"
        }

    }


}