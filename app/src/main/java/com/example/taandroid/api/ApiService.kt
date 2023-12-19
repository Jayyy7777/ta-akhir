package com.example.taandroid.api

import com.example.taandroid.ResponseMateri1
import com.example.taandroid.ResponseMateri2
import com.example.taandroid.ResponseMateri3
import com.example.taandroid.ResponseMateri4
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
        @GET("materi/1")
        fun getMateri1 () : Call<ResponseMateri1>

        @GET("materi/2")
        fun getMateri2 () : Call<ResponseMateri2>

        @GET("materi/4")
        fun getMateri3 () : Call<ResponseMateri3>

        @GET("materi/5")
        fun getMateri4 () : Call<ResponseMateri4>
    }