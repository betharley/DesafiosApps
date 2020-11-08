package com.betharley.myapplication.model

import java.io.Serializable

class Food(imagem:Int, titulo:String, descricao: String): Serializable {
    var imagem: Int = 0
    var titulo: String
    var descricao: String

    init {
        this.imagem = imagem
        this.titulo = titulo
        this.descricao = descricao
    }
}