package com.prasanna.softuser.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prasanna.softuser.DataStore
import com.prasanna.softuser.Model.StudentPost
import com.prasanna.softuser.R
import com.prasanna.softuser.ui.home.HomeFragment

class StudentAdapter(
        private val postList: MutableList<StudentPost>,
        private val context: HomeFragment
        ): RecyclerView.Adapter<StudentAdapter.PostViewHolder>(){
    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProfile : ImageView
        val tvName :TextView
        val tvAge : TextView
        val tvAddress:TextView
        val tvGender:TextView
        val ivDelete:ImageView
        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            ivDelete = view.findViewById(R.id.ivDelete)
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.PostViewHolder {
        // adapter ko data lai kun laout ma dhekaune jasto ho you chaii
        val view = LayoutInflater.from(parent.context).inflate(R.layout.students, parent, false)
        return PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: StudentAdapter.PostViewHolder, position: Int) {
        // data lai view ma dhekaidine
        val student = postList[position]

        holder.tvName.text = student.name
        holder.tvAge.text = student.age.toString()
        holder.tvGender.text = student.gender
        holder.tvAddress.text = student.address
        Glide.with(context).load(student.ImageLink).into(holder.imgProfile)
        holder.ivDelete.setOnClickListener {
            DataStore.student.removeAt(position)
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = postList.size


}

