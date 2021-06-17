package com.example.qrcodescanner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var scanbtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scantext = findViewById<View>(R.id.scantext) as TextView
        scanbtn = findViewById<View>(R.id.scanbtn) as Button
        scanbtn!!.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    scannerView::class.java
                )
            )
        }
    }

    companion object {
        var scantext: TextView? = null
    }
}