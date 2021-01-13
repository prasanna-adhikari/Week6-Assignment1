package com.prasanna.softuser.ui.addStudent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prasanna.softuser.R

class AddStudentFragment : Fragment() {

    private lateinit var addStudentViewModel: AddStudentViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addStudentViewModel =
                ViewModelProvider(this).get(AddStudentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_student, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        addStudentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}