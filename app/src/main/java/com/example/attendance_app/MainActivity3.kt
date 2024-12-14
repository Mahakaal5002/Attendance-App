package com.example.attendance_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val btn:Button=findViewById(R.id.attendanceButton)
        val btn2:Button=findViewById(R.id.timetableButton)

        btn.setOnClickListener {
            startActivity(Intent(this,MainActivity4::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(this,MainActivity6::class.java))
        }
    }
}