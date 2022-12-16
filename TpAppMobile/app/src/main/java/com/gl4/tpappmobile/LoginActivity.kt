package com.gl4.tpappmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var txtEmail: EditText
    lateinit var txtPassword:EditText
    private val MIN_PASSWORD_LENGTH = 6
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewInitialization()
    }

    private fun viewInitialization() {
        txtEmail = findViewById(R.id.editTextTextEmailAddress)
        txtPassword = findViewById(R.id.editTextTextPassword)
    }

    private fun isEmailValid(email: String?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun validateInput():  Boolean {
        // Checking if the input in form is valid
        if (txtEmail.text.toString() == "") {
            txtEmail.error ="Please Enter Email"
            return false
        }
        if (txtPassword.text.toString() == "") {
            txtPassword.error =  "Please Enter Password"
            return false
        }
        // Checking the proper email format
        if (!isEmailValid(txtEmail.text.toString())) {
            txtEmail.error = "Please Enter a Valid Email"
            return false
        }
        // Checking minimum password length
        if (txtPassword.text.length < MIN_PASSWORD_LENGTH) {
            txtPassword.error = "Password length must be more than " + MIN_PASSWORD_LENGTH + " characters"
            return false
        }
        return true
    }
    public fun onLogin(view: View) {
        if (validateInput()) {
            val email = txtEmail!!.text.toString()
            val password =  txtPassword!!.text.toString()
            if (password=="insat2022" && email=="gl4@gmail.com"){
                //Toast.makeText(this, "Login Success",  Toast.LENGTH_SHORT).show()
                val intent = Intent(view.context, WelcomeActivity::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }

    }
}