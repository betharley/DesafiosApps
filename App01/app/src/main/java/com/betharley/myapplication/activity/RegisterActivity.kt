package com.betharley.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.betharley.myapplication.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*

class RegisterActivity : AppCompatActivity() {
    lateinit var register_register: Button

    lateinit var register_name: TextInputEditText
    lateinit var register_email: TextInputEditText
    lateinit var register_password: TextInputEditText
    lateinit var register_password_repeat: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_register = findViewById<Button>(R.id.register_register) as Button

        register_name = findViewById(R.id.register_name_edit)
        register_email = findViewById(R.id.register_email_edit)
        register_password = findViewById(R.id.register_password_edit)
        register_password_repeat = findViewById(R.id.register_password_repeat_edit)


        register_register.setOnClickListener {
            val intent: Intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity( intent )
        }
    }

    fun registrarUsuario(){
        //var usuario: Usuario = Usuario("", "", "")

        var nome = register_name_edit.text.toString()
        var email = register_email_edit.text.toString()
        var password = register_password.text.toString()
        var password_repeat = register_password_repeat_edit.text.toString()

        if( nome.isEmpty() || email.equals("")){
            register_name_edit.error = "Preencha o nome"
        }else
        if( email.isEmpty() || email.equals("")){
            register_email_edit.error = "Preencha o email"
        }else
        if( password.isEmpty() || password.equals("")){
            register_password.error = "Preencha o password"
        }else
        if( password_repeat.isEmpty() || password.equals("")){
            register_password_repeat_edit.error = "Preencha o password"
        }
        else{

            if( password.equals(password_repeat) ){
                val intent: Intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity( intent )
                finish()
            }else{
                register_password_repeat_edit.error = "As senhas estão diferentes"
            }

        }
    }
}