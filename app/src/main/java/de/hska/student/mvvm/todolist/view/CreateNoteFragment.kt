package de.hska.student.mvvm.todolist.view

import android.os.Bundle
import android.view.*
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import de.hska.student.mvvm.todolist.R
import de.hska.student.mvvm.todolist.databinding.FragmentCreateNoteBinding
import de.hska.student.mvvm.todolist.viewmodel.CreateNoteViewModel

private const val LOG_TAG = "CreateNoteFragment"

@AndroidEntryPoint
class CreateNoteFragment : Fragment() {
    private lateinit var binding: FragmentCreateNoteBinding
    private val viewModel: CreateNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            editTextCreateNoteHeader.setText(viewModel.noteHeader)
            editTextCreateNoteBody.setText(viewModel.noteBody)

            editTextCreateNoteHeader.addTextChangedListener { viewModel.noteHeader = it.toString() }
            editTextCreateNoteBody.addTextChangedListener { viewModel.noteBody = it.toString() }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save_note -> {
                val dest = CreateNoteFragmentDirections.actionCreateNoteFragmentToListNoteFragment()
                viewModel.onClickSave()
                findNavController().navigate(dest)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_create_note, menu)
    }
}