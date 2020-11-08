package com.betharley.myapplication.model

import java.io.Serializable

class Anuncio(imagem:Int, titulo:String, endereco:String, status:String): Serializable {
    var imagem: Int = 0
    var titulo: String
    var endereco: String
    var status: String


    init {
        this.imagem = imagem
        this.titulo = titulo
        this.endereco = endereco
        this.status = status
    }

}