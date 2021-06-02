package de.hska.student.mvvm.todolist.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.hska.student.mvvm.todolist.databinding.FragmentListNoteBinding
import de.hska.student.mvvm.todolist.databinding.ItemNoteBinding
import de.hska.student.mvvm.todolist.model.Note

class ListNoteAdapter(private val onClickListener: (Note) -> Unit) :
    ListAdapter<Note, ListNoteAdapter.NoteViewHolder>(DiffNoteCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        private lateinit var currentNote: Note

        init {
            binding.apply { root.setOnClickListener(::onClick) }
        }

        fun bind(item: Note) {
            binding.apply {
                currentNote = item
                textViewHeader.text = item.header
                textViewBody.text = item.body
            }
        }

        override fun onClick(v: View?) = onClickListener(currentNote)
    }
}

object DiffNoteCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.header == newItem.header && oldItem.body == newItem.body
    }

}
