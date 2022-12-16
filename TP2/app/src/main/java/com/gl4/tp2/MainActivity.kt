package com.gl4.tp2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView

import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    var studentListAdapter: StudentListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var studentList = arrayListOf<Etudiant>()
        for (i in 1..10){
            studentList.add(Etudiant("Nom $i", "prenom $i", Genre.MALE, present = true))
            studentList.add(Etudiant("Nom $i", "prenom $i", Genre.FEMALE, present = false))

        }
        var status = listOf<String>("All", "Présent","Absent")


        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        val spinner : Spinner by lazy { findViewById(R.id.spinner) }

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, status)

        studentListAdapter = StudentListAdapter(studentList)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = studentListAdapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                println(position)
                when (position) {
                    1 -> {
                        val resultList = ArrayList<Etudiant>()
                        for (student in studentList) {
                            if (student.present)
                                resultList.add(student)
                        }
                        recyclerView.adapter = StudentListAdapter(resultList)

                    }
                    2 -> {
                        val resultList = ArrayList<Etudiant>()
                        for (student in studentList) {
                            if (!student.present)
                                resultList.add(student)
                        }
                        recyclerView.adapter = StudentListAdapter(resultList)
                    }
                    else -> recyclerView.adapter = StudentListAdapter(studentList)

                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                showToast(message = "Nothing selected")
            }
            private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
                Toast.makeText(context, message, duration).show()
            }
        }



    }



}