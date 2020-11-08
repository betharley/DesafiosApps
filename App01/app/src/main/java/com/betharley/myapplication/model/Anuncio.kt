package com.betharley.myapplication.model

class Anuncio(imagem:Int, titulo:String, endereco:String, status:String) {
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