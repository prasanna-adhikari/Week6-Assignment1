package com.prasanna.softuser

import com.prasanna.softuser.Model.StudentPost

object DataStore {
    val student = mutableListOf<StudentPost>(
            StudentPost(
                    "Ram",
                    30, "male", "Dillibazar"
            )
    )
//    val posts = mutableListOf<Post>()
}