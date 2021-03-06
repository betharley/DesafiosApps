package com.betharley.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.betharley.myapplication._interface.ClickListener
import com.betharley.myapplication.R
import com.betharley.myapplication.model.Anuncio

class AdaptadorAnuncio(lista:ArrayList<Anuncio>, var clickListener: ClickListener):
    RecyclerView.Adapter<AdaptadorAnuncio.ViewHolder>() {

    var lista: ArrayList<Anuncio> = ArrayList<Anuncio>()

    init {
        this.lista = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        var viewHolder = ViewHolder(view, clickListener)
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

    class ViewHolder(view: View, listener: ClickListener): RecyclerView.ViewHolder(view), View.OnClickListener {
        var imagemView: ImageView
        var titulo: TextView
        var endereco: TextView
        var status: TextView

        var listener: ClickListener? = null

        init {
            imagemView = view.findViewById(R.id.item_imagem)
            titulo = view.findViewById(R.id.item_titulo)
            endereco = view.findViewById(R.id.item_endereco)
            status = view.findViewById(R.id.item_status)

            this.listener = listener
            view.setOnClickListener(this)
        }

        fun bind(anuncio: Anuncio){
            this.imagemView.setImageResource( anuncio.imagem)
            this.titulo.setText( anuncio.titulo )
            this.endereco.setText( anuncio.endereco )
            this.status.setText( anuncio.status )
        }

        override fun onClick(view: View?) {

            this.listener?.onClick(view!!, adapterPosition)
        }

    }


}