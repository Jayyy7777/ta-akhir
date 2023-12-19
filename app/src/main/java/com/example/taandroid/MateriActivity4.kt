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

class MateriActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi4)

        val morty = findViewById<RecyclerView>(R.id.materi)

        val home = findViewById<ImageView>(R.id.home)
        home.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        ApiConfig.getService().getMateri4().enqueue(object : Callback<ResponseMateri4> {
            override fun onResponse(
                call: Call<ResponseMateri4>,
                response: Response<ResponseMateri4>
            ) {
                if (response.isSuccessful){
                    val responseMateri = response.body()
                    val dataMateri = responseMateri?.data
                    val materiAdapter = MateriAdapter(dataMateri)
                    morty.apply {
                        layoutManager = LinearLayoutManager(this@MateriActivity4)
                        setHasFixedSize(true)
                        materiAdapter.notifyDataSetChanged()
                        adapter = materiAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseMateri4>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

    }
}