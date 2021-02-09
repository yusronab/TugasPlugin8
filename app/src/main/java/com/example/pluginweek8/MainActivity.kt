package com.example.pluginweek8

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pluginweek8.adapter.todoAdapter
import com.example.pluginweek8.databinding.ActivityMainBinding
import com.example.pluginweek8.model.todo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var todoList = mutableListOf(
                todo("Item 1", false),
                todo("Item 2", false),
                todo("Item 3", false),
        )
        val adapter = todoAdapter(todoList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.btnAdd.setOnClickListener {
            val tittle = binding.etAdd.text.toString()
            val todo = todo(tittle, false)
            todoList.add(todo)
            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}