package com.betharley.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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

        //REFERNCIA OS ELEMENTOS DO LAYOUT
        login_register = findViewById<Button>(R.id.login_register) as Button
        login_login = findViewById<Button>(R.id.login_login) as Button
        login_email_edit = findViewById(R.id.login_email_edit) as TextInputEditText
        login_password_edit = findViewById(R.id.login_password_edit) as TextInputEditText

        login_register.setOnClickListener {
            var intent: Intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

        login_login.setOnClickListener {
            logarUsuario()
        }


    }

    //LOGA O USUARIO PARA ENTRAR NO APLICATIVO
    fun logarUsuario(){
        var email = login_email_edit.text.toString().trim()
        var password = login_password_edit.text.toString().trim()

        if( email.isEmpty() || email.equals("")){
            login_email_edit.error = getString(R.string.preenchaEmail)
        }else
        if( password.isEmpty() || password.equals("")){
            login_password_edit.error = getString(R.string.preenchaSenha)
        }else{
            var intent: Intent = Intent(applicationContext, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

}



//    //TESTES PARA SER REALIZADOS DEPOIS
//    login_email_edit.addTextChangedListener(object : TextWatcher {
//        override fun afterTextChanged(s: Editable) {}
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//            //validarDados()
//        }
//    })
//    login_password_edit.addTextChangedListener(object : TextWatcher {
//        override fun afterTextChanged(s: Editable) {}
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//            //validarDados()
//        }
//    })
//    fun validarDados(){
//        val email = login_email_edit.text.toString().trim()
//        val password = login_password_edit.text.toString().trim()
//
//        if( !email.isEmpty() && !password.isEmpty() ){
//            login_login.isEnabled = true
//        }else{
//            login_register.isEnabled = false
//        }
//    }
