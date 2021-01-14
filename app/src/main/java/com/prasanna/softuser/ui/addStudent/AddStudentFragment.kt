package com.prasanna.softuser.ui.addStudent

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.prasanna.softuser.DataStore
import com.prasanna.softuser.Model.StudentPost
import com.prasanna.softuser.R

class AddStudentFragment : Fragment() {

    private lateinit var addStudentViewModel: AddStudentViewModel
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var etAddress: EditText
    private lateinit var etImageLink: EditText
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
        rgGender = view.findViewById(R.id.rgGender)
        etAddress = view.findViewById(R.id.etAddress)
        etImageLink = view.findViewById(R.id.etImageLink)
        btnAddStudent = view.findViewById(R.id.btnAddStudent)

        btnAddStudent.setOnClickListener {
            if (validate()) {
                val sexId = rgGender.checkedRadioButtonId
                val rbGen: RadioButton = view.findViewById(sexId)

                DataStore.student.add(
                    StudentPost(
                        etName.text.toString(),
                        etAge.text.toString().toInt(),
                        rbGen.text.toString(),
                        etAddress.text.toString(),
                        etImageLink.text.toString()
                    )
                )

                Toast.makeText(context, "Successfully added student", Toast.LENGTH_SHORT).show()

            }
        }

        return view
    }

    private fun validate(): Boolean {
        when {
            TextUtils.isEmpty(etName.text) -> {
                etName.error = "Please Enter Your Student ID"
                etName.requestFocus()
                return false
            }
            TextUtils.isEmpty(etAge.text) -> {
                etAge.error = "Please Enter the Age"
                etAge.requestFocus()
                return false
            }

            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "Please Enter the Address"
                etAddress.requestFocus()
                return false
            }
        }
        return true
    }
}