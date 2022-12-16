package com.gl4.tpappmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class WelcomeActivity : AppCompatActivity() {
    private lateinit var txtView: TextView
    lateinit var imgView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val email = intent.getStringExtra("email")
        txtView = findViewById(R.id.textView)
        txtView.text = "Bienvenue $email"


        imgView = findViewById(R.id.imageView)
    }
    fun onLoadImage(view: View) {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        pickImage.launch(intent)
        Toast.makeText(this, "Login Success",  Toast.LENGTH_SHORT).show()
    }
    private val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if(result.resultCode == RESULT_OK){
            val uriImage = result.data?.data
            imgView.setImageURI(uriImage)
        }
    }

}