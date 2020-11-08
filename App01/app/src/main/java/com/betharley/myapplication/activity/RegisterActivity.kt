package com.betharley.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.betharley.myapplication.R

class RegisterActivity : AppCompatActivity() {
    lateinit var register_register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_register = findViewById<Button>(R.id.register_register) as Button


        register_register.setOnClickListener {
            val intent: Intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity( intent )
        }
    }
}