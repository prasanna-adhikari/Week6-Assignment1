package com.prasanna.softuser.ui.addStudent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prasanna.softuser.R

class AddStudentFragment : Fragment() {

    private lateinit var addStudentViewModel: AddStudentViewModel
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var rdMale: RadioGroup
    private lateinit var rdFemale: RadioGroup
    private lateinit var rdOther: RadioGroup
    private lateinit var etAddress: EditText
    private lateinit var btnAddStudent: Button
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addStudentViewModel =
                ViewModelProvider(this).get(AddStudentViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        etName = view.findViewById(R.id.etName)
        etAge = view.findViewById(R.id.etAge)
        rdMale = view.findViewById(R.id.rdMale)
        rdFemale = view.findViewById(R.id.rdFemale)
        rdOther = view.findViewById(R.id.rdOther)
        etAddress = view.findViewById(R.id.etAddress)
        btnAddStudent = view.findViewById(R.id.btnAddStudent)


        return view
    }
}