package com.betharley.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betharley.myapplication.R
import com.betharley.myapplication._interface.ClickListener
import com.betharley.myapplication.adapter.AdaptadorAnuncio
import com.betharley.myapplication.model.Anuncio

class HomeActivity : AppCompatActivity() {

    lateinit var listaAnuncios: ArrayList<Anuncio>
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adaptadorAnuncio: AdaptadorAnuncio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        criarLista()

        layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.home_recyclerView)
        recyclerView.layoutManager = layoutManager

        //CLIQUE NO ITEM DO RECYCLER VIEW PARA ABRIR UMA NOVA TELA
        adaptadorAnuncio = AdaptadorAnuncio(listaAnuncios, object: ClickListener {
            override fun onClick(view: View, position: Int) {
                var anuncio: Anuncio = listaAnuncios.get(position)
                var intent: Intent = Intent(applicationContext, DetalhesFoodActivity::class.java)
                intent.putExtra(getString(R.string.ANUNCIO), anuncio)
                startActivity( intent )
            }
        })

        recyclerView.adapter = adaptadorAnuncio
    }

    //ADICIONA ELEMENTOS NA LISTA
    fun criarLista(){
        listaAnuncios = ArrayList<Anuncio>();
        listaAnuncios.add( Anuncio(R.drawable.iv_tonyroma, getString(R.string.TonyRomas), getString(R.string.TonyRomasEndereco), getString(R.string.Fecha22) ) )
        listaAnuncios.add( Anuncio(R.drawable.iv_aoyama, getString(R.string.AoyamaMoema), getString(R.string.AoyamaMoemaEndereco), getString(R.string.Fecha00) ) )
        listaAnuncios.add( Anuncio(R.drawable.iv_outback, getString(R.string.OutbackMoema), getString(R.string.OutbackMoemaEndereco), getString(R.string.Fecha00 )) )
        listaAnuncios.add( Anuncio(R.drawable.iv_senor, getString(R.string.SiSenor), getString(R.string.SiSenorEndereco), getString(R.string.Fecha01) ) )
    }

}

/*
Tony Roma's
Av. Lavandisca, 717 - Indianapolis, São Paulo
Fecha as 22:00

Aoyama - Moema
Alameda dos Arapaes, 532 - Moema
Fecha as 00:00

Outback - Moema
Av. Moaci, 187, 187 - Moema, São Paulo
Fecha as 00:00

Si Senor!
Alameda Jauaperi, 626 - Moema
Fecha as 01:00
 */


















