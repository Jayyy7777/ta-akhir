package com.example.taandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taandroid.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MateriActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi2)

        val morty = findViewById<RecyclerView>(R.id.materi)

        val home = findViewById<ImageView>(R.id.home)
        home.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        ApiConfig.getService().getMateri2().enqueue(object : Callback<ResponseMateri2> {
            override fun onResponse(
                call: Call<ResponseMateri2>,
                response: Response<ResponseMateri2>
            ) {
                if (response.isSuccessful){
                    val responseMateri = response.body()
                    val dataMateri = responseMateri?.data
                    val materiAdapter = MateriAdapter(dataMateri)
                    morty.apply {
                        layoutManager = LinearLayoutManager(this@MateriActivity2)
                        setHasFixedSize(true)
                        materiAdapter.notifyDataSetChanged()
                        adapter = materiAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseMateri2>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

    }
}