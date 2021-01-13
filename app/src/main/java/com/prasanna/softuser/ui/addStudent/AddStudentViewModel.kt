package com.prasanna.softuser.ui.addStudent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddStudentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is add student Fragment"
    }
    val text: LiveData<String> = _text
}