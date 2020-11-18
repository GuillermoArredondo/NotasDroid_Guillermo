package com.example.notasdroid_guillermo

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lo_modulo.view.*


class ModuloAdapter(ctx: Context, val modulo: ArrayList<Modulo>): RecyclerView.Adapter<ModuloAdapter.ViewHolder>(){

    val ctx = ctx

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtNom = itemView.txtNom
        val txtNot = itemView.txtNot
        val txtNotaMedia = itemView.txtNotaMedia
        val imaMod = itemView.imaMod
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuloAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lo_modulo, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ModuloAdapter.ViewHolder, position: Int) {

        val modulo : Modulo = modulo[position]
        holder.txtNom.text  = modulo.nombre
        holder.txtNot.text = "Nota media"
        holder.txtNotaMedia.text = "10"
        //holder.imaMod.setImageDrawable(ctx.getResources().getDrawable(modulo.foto_modeulo))
        holder.imaMod.setImageDrawable(ctx.getResources().getDrawable(R.drawable.asir_1_1))

    }

    override fun getItemCount(): Int {
        return modulo.size
    }

}