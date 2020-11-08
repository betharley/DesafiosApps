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
import com.betharley.myapplication.model.Food

class AdaptadorDetalhe(lista:ArrayList<Food>, var clickListener: ClickListener):
    RecyclerView.Adapter<AdaptadorDetalhe.ViewHolder>() {

    var lista: ArrayList<Food> = ArrayList<Food>()

    init {
        this.lista = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_detalhe, parent, false)
        var viewHolder = ViewHolder(view, clickListener)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var food: Food = lista.get(position)

        holder.bind( food )
        //holder.imagemView.setImageResource( anuncio.imagem )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(view: View, listener: ClickListener): RecyclerView.ViewHolder(view), View.OnClickListener {
        var imagemView: ImageView
        var titulo: TextView

        var listener: ClickListener? = null

        init {
            imagemView = view.findViewById(R.id.item_detalhe_imagem)
            titulo = view.findViewById(R.id.item_detalhe_titulo)

            this.listener = listener
            view.setOnClickListener(this)
        }

        fun bind(food: Food){
            this.imagemView.setImageResource( food.imagem)
            this.titulo.setText( food.titulo )
        }

        override fun onClick(view: View?) {

            this.listener?.onClick(view!!, adapterPosition)
        }

    }


}