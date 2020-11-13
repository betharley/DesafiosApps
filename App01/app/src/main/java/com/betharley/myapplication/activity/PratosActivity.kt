package com.betharley.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betharley.myapplication.R
import com.betharley.myapplication._interface.ClickListener
import com.betharley.myapplication.adapter.AdaptadorDetalhe
import com.betharley.myapplication.model.Anuncio
import com.betharley.myapplication.model.Food

class PratosActivity : AppCompatActivity() {
    lateinit var detalhe_seta: ImageView
    lateinit var anuncio: Anuncio
    lateinit var detalhe_imagem_fundo: ImageView
    lateinit var detalhe_titulo: TextView

    lateinit var listaFood: ArrayList<Food>
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adaptadorFood: AdaptadorDetalhe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pratos)

        //REFERNCIA OS ELEMENTOS DO LAYOUT
        detalhe_imagem_fundo = findViewById(R.id.detalhe_imagem_fundo) as ImageView
        detalhe_titulo = findViewById(R.id.detalhe_titulo) as TextView
        detalhe_seta = findViewById(R.id.detalhe_seta) as ImageView
        anuncio = intent.extras!!.getSerializable(getString(R.string.ANUNCIO)) as Anuncio
        //var danuncio = intent.extras!!.getString("Key")

        criarLista()

        layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.detalhe_recyclerView)
        recyclerView.layoutManager = layoutManager

        //CLIQUE NO ITEM DO RECYCLER VIEW PARA ABRIR UMA NOVA TELA
        adaptadorFood = AdaptadorDetalhe(listaFood, object: ClickListener {
            override fun onClick(view: View, position: Int) {
                var food: Food = listaFood.get(position)
                //Toast.makeText(applicationContext, ""+anuncio.titulo, Toast.LENGTH_SHORT).show()
                var intent: Intent = Intent(applicationContext, DetalheCardapioActivity::class.java)
                intent.putExtra(getString(R.string.FOOD), food)
                startActivity( intent )
            }

        }, applicationContext)

        recyclerView.adapter = adaptadorFood



        if( anuncio != null ){
            detalhe_imagem_fundo.setImageResource( anuncio.imagem )
            detalhe_titulo.text = anuncio.titulo
        }

        detalhe_seta.setOnClickListener {
            finish()
        }
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//    }

    //ADICIONA ELEMENTOS NA LISTA
    fun criarLista(){
        listaFood = ArrayList<Food>();
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))
        listaFood.add( Food(R.drawable.iv_aoyama, getString(R.string.salada), getString(R.string.food_descricao) ))

    }
}