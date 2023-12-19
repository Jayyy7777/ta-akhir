package com.example.taandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginbtn = findViewById<Button>(R.id.btnLogin)
            loginbtn.setOnClickListener{
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
        }

        val contactus = findViewById<ImageView>(R.id.help)
        contactus.setOnClickListener{
            val intent = Intent(this, ContactUsActivity::class.java)
            startActivity(intent)
        }
    }
}