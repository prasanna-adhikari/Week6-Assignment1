package com.prasanna.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Binding()
        validate()

        btnLogin.setOnClickListener {
            if (validate()){
                Intent(this,MainActivity::class.java).also{
                    startActivity(it)
                }
                return@setOnClickListener
            }
            clear()

        }


    }
    private fun Binding(){
        etUsername=findViewById(R.id.etUsername)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
    }
    private fun validate() : Boolean {
        when {
            TextUtils.isEmpty(etUsername.text) -> {
                etUsername.error = "Enter Your Username"
                etUsername.requestFocus()
                return false
            }
            TextUtils.isEmpty(etPassword.text) -> {
                etPassword.error = "Enter Your Password"
                etPassword.requestFocus()
                return false
            }
        }
        return true
    }
    private fun clear() {
        etUsername.setText("")
        etPassword.setText("")
    }
}