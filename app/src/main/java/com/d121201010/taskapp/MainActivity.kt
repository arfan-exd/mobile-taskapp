package com.d121201010.taskapp

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvBooks = findViewById<RecyclerView>(R.id.recyclerview)
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAuthor = findViewById<EditText>(R.id.etAuthor)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        val bookList = mutableListOf(
            Book("Kerja Tugas Pemrog. Mobile", "Sangat Mendesak"),
            Book("Tugas Akhir SI", "Mendesak"),

        )

        val adapter = BookAdapter(bookList)
        rvBooks.adapter = adapter
        rvBooks.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val title = etTitle.text.toString()
            val author = etAuthor.text.toString()

            val book = Book(title, author)

            bookList.add(book)
            adapter.notifyItemInserted(bookList.size - 1)
        }

    }
}