package com.example.pluginweek8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pluginweek8.databinding.TodoItemBinding
import com.example.pluginweek8.model.todo

class todoAdapter (var todos: List<todo>): RecyclerView.Adapter<todoAdapter.TodoViewHolder>(){
    inner class TodoViewHolder(val binding:TodoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(TodoItemBinding.inflate(LayoutInflater.from(parent. context), parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            tvItem.text = todos[position].tittle
            checkBox.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}