package com.prasanna.softuser

import com.prasanna.softuser.Model.StudentPost

object DataStore {
    val student = mutableListOf<StudentPost>(
            StudentPost(
                    "Ram",
                    30,
                "Male",
                "Dillibazar",
                "https://bulletinhours.com/wp-content/uploads/2020/04/Chris-Hemsworth.jpg"
            )
    )
//    val posts = mutableListOf<Post>()
}