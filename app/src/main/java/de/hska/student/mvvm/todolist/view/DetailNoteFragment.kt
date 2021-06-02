package de.hska.student.mvvm.todolist.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import de.hska.student.mvvm.todolist.R
import de.hska.student.mvvm.todolist.databinding.FragmentDetailNoteBinding
import de.hska.student.mvvm.todolist.viewmodel.DetailNoteViewModel

private const val LOG_TAG = "DetailNoteFragment"

@AndroidEntryPoint
class DetailNoteFragment : Fragment() {

    private lateinit var binding: FragmentDetailNoteBinding
    private val viewModel: DetailNoteViewModel by viewModels()
    private val navArgs: DetailNoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailNoteBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            textViewDetailNoteHeader.text = navArgs.note.header
            textViewDetailNoteBody.text = navArgs.note.body
            textViewDetailNoteTimestamp.text = navArgs.note.timestampFormatted
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_delete_note -> {
                val note = navArgs.note
                viewModel.onclickDelete(note)
                val dest =
                    DetailNoteFragmentDirections.actionDestDetailNoteFragmentToDestListNoteFragment()
                findNavController().navigate(dest)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_detail_note, menu)
    }
}