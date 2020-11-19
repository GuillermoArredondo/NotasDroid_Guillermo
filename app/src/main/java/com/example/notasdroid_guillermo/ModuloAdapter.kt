package com.example.notasdroid_guillermo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lo_modulo.view.*


class ModuloAdapter(ctx: Context, val modulos: ArrayList<Modulo>): RecyclerView.Adapter<ModuloAdapter.ViewHolder>(), View.OnClickListener {

    val ctx = ctx
    private lateinit var listener : View.OnClickListener
    private val listener2 : (Modulo) -> Unit
        get() {
            TODO()
        }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtNom = itemView.txtNom
        val txtNot = itemView.txtNot
        val txtNotaMedia = itemView.txtNotaMedia
        val imaMod = itemView.imaMod




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuloAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lo_modulo, parent, false)
        v.setOnClickListener(this)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ModuloAdapter.ViewHolder, position: Int) {

        val modulo : Modulo = modulos[position]
        holder.txtNom.text  = modulo.nombre
        holder.txtNot.text = "Nota media"
        holder.txtNotaMedia.text = "10"
        holder.imaMod.setImageDrawable(ctx.getResources().getDrawable(modulo.foto_modeulo))

        //escucha el clic de cada fila
        holder.txtNom.setOnClickListener {
                // Devolvemos el modulo
                listener2(modulos[position])
            }

    }

    override fun getItemCount(): Int {
        return modulos.size
    }

    public fun setOnClickListener(listener: View.OnClickListener){
        this.listener = listener
    }

    override fun onClick(v: View?) {
        if (listener != null){
            listener.onClick(v)
        }
    }

}