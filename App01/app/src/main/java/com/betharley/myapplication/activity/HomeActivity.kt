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
        adaptadorAnuncio = AdaptadorAnuncio(listaAnuncios, object: ClickListener {
            override fun onClick(view: View, position: Int) {
                var anuncio: Anuncio = listaAnuncios.get(position)
                //Toast.makeText(applicationContext, ""+anuncio.titulo, Toast.LENGTH_SHORT).show()
                var intent: Intent = Intent(applicationContext, DetalhesFoodActivity::class.java)
                intent.putExtra("ANUNCIO", anuncio)
                startActivity( intent )
            }

        })

        recyclerView.adapter = adaptadorAnuncio
    }

    fun criarLista(){
        listaAnuncios = ArrayList<Anuncio>();
        listaAnuncios.add( Anuncio(R.drawable.iv_tonyroma, "Tony Roma's", "Av. Lavandisca, 717 - Indianapolis, São Paulo", "Fecha as 22:00" ) )
        listaAnuncios.add( Anuncio(R.drawable.iv_aoyama, "Aoyama - Moema", "Alameda dos Arapaes, 532 - Moema", "Fecha as 00:00" ) )
        listaAnuncios.add( Anuncio(R.drawable.iv_outback, "Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha as 00:00" ) )
        listaAnuncios.add( Anuncio(R.drawable.iv_senor, "Si Senor!", "Alameda Jauaperi, 626 - Moema", "Alameda Jauaperi, 626 - Moema" ) )
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


















