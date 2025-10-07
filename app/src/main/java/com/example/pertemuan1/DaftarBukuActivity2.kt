package com.example.pertemuan1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan1.data.model.BookDoc
import com.example.pertemuan1.databinding.ActivityDaftarBuku2Binding
import com.example.pertemuan1.ui.adapter.BookAdapter
import com.example.pertemuan1.ui.adapter.OnBookClickListener
import com.example.pertemuan1.ui.fragment.BookDetailFragment
import com.example.pertemuan1.viewmodel.MainViewModel

class DaftarBukuActivity : AppCompatActivity(), OnBookClickListener {
    private lateinit var binding: ActivityDaftarBuku2Binding

    private val viewModel: MainViewModel by viewModels()

    private val adapter = BookAdapter(emptyList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBuku2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter= adapter

        viewModel.books.observe(this){
            adapter.setData(it)
        }

        viewModel.fetchBooks("Kotlin Programming")


    }

    override fun onBookClick(book: BookDoc) {
        book.let { b->
            BookDetailFragment(
                title = b.title ?: "No Title",
                author = b.authorName?.joinToString(separator = ", ") ?: "Unknown Author",
                year = b.firstPublishYear?.toString() ?: "-",
                coverId = b.coverId ?: 0

            ).show(supportFragmentManager, "BookDetailFragment"::class.java.simpleName)
        }
    }
}