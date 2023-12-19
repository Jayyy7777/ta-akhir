package com.example.taandroid

import com.google.gson.annotations.SerializedName

data class ResponseMateri2(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class DataItem2(

	@field:SerializedName("id_kategori")
	val idKategori: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("isi")
	val isi: String? = null,

	@field:SerializedName("id_pengguna")
	val idPengguna: Int? = null
)
