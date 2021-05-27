package com.example.espressouitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnChange = findViewById<Button>(R.id.btnChange)
        var etTextToChange = findViewById<EditText>(R.id.etTextToChange)
        var tvChangedText = findViewById<TextView>(R.id.tvChangedText)
        btnChange!!.setOnClickListener { tvChangedText!!.text = etTextToChange!!.text }
    }
}