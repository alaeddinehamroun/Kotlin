package com.gl4.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var txtEmail: EditText
    lateinit var txtPassword: EditText
    val MIN_PASSWORD_LENGTH = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun viewInitialization() {
        txtEmail = findViewById(R.id.editTextTextEmailAddress)
        txtPassword = findViewById(R.id.editTextTextPassword)
    }
    fun onLogin(view: View){
        //val textView: TextView = findViewById(R.id.textView)
        //textView.setText("clicked")
        print("rrrrrrrrrrrrrrrrrrrrrrrrrr")
        var email = txtEmail.text.toString()
        var password = txtPassword.text.toString()
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
    }

}