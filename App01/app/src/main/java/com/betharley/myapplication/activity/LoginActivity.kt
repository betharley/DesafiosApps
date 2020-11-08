package com.betharley.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.betharley.myapplication.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    lateinit var login_register: Button
    lateinit var login_login: Button

    lateinit var login_email_edit: TextInputEditText
    lateinit var login_password_edit: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_register = findViewById<Button>(R.id.login_register) as Button
        login_login = findViewById<Button>(R.id.login_login) as Button
        login_email_edit = findViewById(R.id.login_email_edit) as TextInputEditText
        login_password_edit = findViewById(R.id.login_password_edit) as TextInputEditText

        login_register.setOnClickListener {
            var intent: Intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity( intent )
        }

        login_login.setOnClickListener {
            logarUsuario()
        }
    }


    fun logarUsuario(){
        var email = login_email_edit.text.toString()
        var password = login_password_edit.text.toString()

        if( email.isEmpty() || email.equals("")){
            login_email_edit.error = "Preencha o email"
        }else
        if( password.isEmpty() || password.equals("")){
            login_password_edit.error = "Preencha a senha"
        }else{
            var intent: Intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity( intent )
            finish()
        }
    }

}