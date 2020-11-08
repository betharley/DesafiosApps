package com.betharley.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betharley.myapplication.model.Anuncio

class HomeActivity : AppCompatActivity() {

    lateinit var listaAnuncios: ArrayList<Anuncio>
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        criarLista()

        layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.home_recyclerView)

    }

    fun criarLista(){
        listaAnuncios = ArrayList<Anuncio>();
        listaAnuncios.add( Anuncio(R.drawable.img01_tony_romas, "Titulo 11", "Endereço 11", "Aberto 11" ) )
        listaAnuncios.add( Anuncio(R.drawable.img02_aoyama_moema, "Titulo 12", "Endereço 12", "Aberto 12" ) )
        listaAnuncios.add( Anuncio(R.drawable.img03_outback_moema, "Titulo 13", "Endereço 13", "Aberto 13" ) )
        listaAnuncios.add( Anuncio(R.drawable.img04_si_sinor, "Titulo 14", "Endereço 14", "Aberto 14" ) )
    }

}