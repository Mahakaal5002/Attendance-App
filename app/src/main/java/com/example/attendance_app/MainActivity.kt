package com.example.attendance_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtxt:EditText=findViewById(R.id.idEditText)
        val pass:EditText=findViewById(R.id.passwordEditText)
        val logbtn:Button=findViewById(R.id.loginButton)

        logbtn.setOnClickListener {

            startActivity(Intent(this,MainActivity3::class.java))
            Toast.makeText(this,"Successfully logged in",Toast.LENGTH_SHORT).show()


        }

    }
}