package com.gl4.pizzadeliveryapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    var list_of_sizes = arrayOf("s", "m", "l")
    var spinner:Spinner? = null
    lateinit var txtFirstname:EditText
    lateinit var txtLastname:EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner_id)
        spinner!!.onItemSelectedListener = this
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_sizes)

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter = aa


        txtFirstname = findViewById(R.id.editTextTextFirstName)
        txtLastname = findViewById(R.id.editTextTextLastName)
    }
    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        // use position to know the selected item
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }

    private fun validateInput(): Boolean{


        return true
    }


    public fun onClick(view: View)  {
        if (validateInput()) {
            val firstname = txtFirstname!!.text.toString()
            val lastname = txtLastname!!.text.toString()

            val intent = Intent(view.context, CommandActivity::class.java)
            intent.putExtra("firstname", firstname)
            intent.putExtra("lastname", lastname)
        }
    }
}