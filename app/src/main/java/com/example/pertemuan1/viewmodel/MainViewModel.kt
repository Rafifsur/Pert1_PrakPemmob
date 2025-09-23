package com.example.pertemuan1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pertemuan1.data.model.BookDoc
import com.example.pertemuan1.data.network.RetrofitInstance
import kotlinx.coroutines.launch


import retrofit2.http.Query

class MainViewModel : ViewModel() {

    private val _books = MutableLiveData<List<BookDoc>>()

    val books: LiveData<List<BookDoc>> = _books

    fun fetchBooks(query: String) {
        viewModelScope.launch {


            try {
                val response = RetrofitInstance.api.searchBooks(query,10)
                if (response.isSuccessful){
                    val result=response.body()?.docs ?: emptyList()
                    _books.value = result
                    Log.d("SUCCES_GET_DATA", "$result")
                } else {
                    Log.e("API_EROR", "$(response.code()} ${response.message()}")
                }
            } catch (e: Exception){
                Log.e("API_EXCEPTION", e.localizedMessage ?: "Unknown error")
            }
        }
    }
}