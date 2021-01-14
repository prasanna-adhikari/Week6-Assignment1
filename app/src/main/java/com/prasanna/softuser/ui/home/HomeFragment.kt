package com.prasanna.softuser.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prasanna.softuser.Adapter.StudentAdapter
import com.prasanna.softuser.DataStore
import com.prasanna.softuser.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var rvStudentDetails: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        rvStudentDetails = view.findViewById(R.id.rvStudentDetails)

        rvStudentDetails.layoutManager = LinearLayoutManager(activity)
        rvStudentDetails.adapter = StudentAdapter(DataStore.student, this)

        return view
    }
}