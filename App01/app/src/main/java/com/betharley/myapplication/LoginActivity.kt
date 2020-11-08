package com.betharley.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    lateinit var login_register: Button
    lateinit var login_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        login_register = findViewById<Button>(R.id.login_register) as Button
        login_login = findViewById<Button>(R.id.login_login) as Button


        login_register.setOnClickListener {
            var intent: Intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity( intent )
        }

        login_login.setOnClickListener {
            var intent: Intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity( intent )
        }
    }



}