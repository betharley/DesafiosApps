package com.betharley.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.betharley.myapplication.R
import com.betharley.myapplication.model.Food

class DetalheCardapioActivity : AppCompatActivity() {
    lateinit var food_seta: ImageView
    lateinit var food: Food

    lateinit var food_imagem: ImageView
    lateinit var food_titulo: TextView
    lateinit var food_descricao: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_cardapio)

        //PEGA O OBJETO QUE VEIO DA OUTRA ACTIVITY
        food = intent.extras!!.getSerializable(getString(R.string.FOOD)) as Food

        //REFERNCIA OS ELEMENTOS DO LAYOUT
        food_seta = findViewById(R.id.food_seta) as ImageView
        food_imagem = findViewById(R.id.food_imagem_fundo) as ImageView
        food_titulo = findViewById(R.id.food_titulo) as TextView
        food_descricao = findViewById(R.id.food_descricao) as TextView

        food_seta.setOnClickListener {
            finish()
        }

        if( food != null ){
            food_imagem.setImageResource( food.imagem )

            food_titulo.text = food.titulo
            food_descricao.text = food.descricao

        }

    }

}