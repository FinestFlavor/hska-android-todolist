package de.hska.student.mvvm.todolist.view

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import de.hska.student.mvvm.todolist.R
import de.hska.student.mvvm.todolist.adapter.ListNoteAdapter
import de.hska.student.mvvm.todolist.databinding.FragmentListNoteBinding
import de.hska.student.mvvm.todolist.model.Note
import de.hska.student.mvvm.todolist.viewmodel.ListNoteViewModel
import java.util.*

private const val LOG_TAG = "ListNoteFragment"

@AndroidEntryPoint
class ListNoteFragment : Fragment() {

    private lateinit var binding: FragmentListNoteBinding
    private val viewModel: ListNoteViewModel by viewModels()
    private val listAdapter = ListNoteAdapter(::onItemClick)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(LOG_TAG, "onCreateView")
        binding = FragmentListNoteBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LOG_TAG, "onViewCreated")
        binding.apply {
            recyclerViewListNote.apply {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
            }
        }
        viewModel.notes.observe(
            viewLifecycleOwner,
            { listAdapter.submitList(it.sortedByDescending(Note::timestamp)) })
    }

    private fun onItemClick(note: Note) {
        Log.d(LOG_TAG, "Clicked note ${note.id}")
        val dest = ListNoteFragmentDirections.actionDestListNoteFragmentToDetailNoteFragment(note)
        findNavController().navigate(dest)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(LOG_TAG, "onOptionsItemSelected")
        val dest = ListNoteFragmentDirections.actionListNoteFragmentToCreateNoteFragment()
        findNavController().navigate(dest)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_list_note, menu)
    }
}