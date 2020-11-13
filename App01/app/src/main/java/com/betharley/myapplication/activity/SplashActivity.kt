package com.betharley.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.betharley.myapplication.R

class SplashActivity : AppCompatActivity() {
    private val TEMPO_ESPERA:Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //CHAMA A TELA DE LOGIN APOS 2 SEGUNDOS
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        },TEMPO_ESPERA)

    }
}