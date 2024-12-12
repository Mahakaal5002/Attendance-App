package com.example.attendance_app
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity2 : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private lateinit var editText: EditText
    private var stringDateSelected: String? = null
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn:Button=findViewById(R.id.button)

        btn.setOnClickListener {
            Toast.makeText(this,"Event Saved",Toast.LENGTH_SHORT).show()
        }

        calendarView = findViewById(R.id.calendarView)
        editText = findViewById(R.id.editText)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            stringDateSelected = "$year${month + 1}$dayOfMonth"
            calendarClicked()
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Calendar")
    }

    private fun calendarClicked() {
        stringDateSelected?.let { date ->
            databaseReference.child(date)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        editText.setText(snapshot.getValue(String::class.java) ?: "null")
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Log or handle error if necessary
                    }
                })
        }
    }

    fun buttonSaveEvent(view: View?) {
        stringDateSelected?.let { date ->
            databaseReference.child(date).setValue(editText.text.toString())
        }
    }
}
