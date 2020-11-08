package com.betharley.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.betharley.myapplication.R
import com.betharley.myapplication.model.Anuncio

class AdaptadorAnuncio(lista:ArrayList<Anuncio>):
    RecyclerView.Adapter<AdaptadorAnuncio.ViewHolder>() {

    var lista: ArrayList<Anuncio> = ArrayList<Anuncio>()

    init {
        this.lista = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        var viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var anuncio: Anuncio = lista.get(position)

        holder.bind( anuncio )
        //holder.imagemView.setImageResource( anuncio.imagem )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imagemView: ImageView
        var titulo: TextView
        var endereco: TextView
        var status: TextView

        init {
            imagemView = view.findViewById(R.id.item_imagem)
            titulo = view.findViewById(R.id.item_titulo)
            endereco = view.findViewById(R.id.item_endereco)
            status = view.findViewById(R.id.item_status)
        }

        fun bind(anuncio: Anuncio){
            this.imagemView.setImageResource( anuncio.imagem)
            this.titulo.setText( anuncio.titulo )
            this.endereco.setText( anuncio.endereco )
            this.status.setText( anuncio.status )
        }

    }


}