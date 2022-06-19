package com.istecstudent.pl.studentsreg_pl.repo

import com.istecstudent.pl.studentsreg_pl.model.Student
import org.springframework.stereotype.Repository

@Repository

class StudentsRepo {

    private var allStudents = mutableListOf<Student>()

    init {
        val aluno1 = Student(1001, "Ze das Tortas", true)
        val aluno2 = Student(1002, "Ana Sopas", false)

        allStudents.add(aluno1)
        allStudents.add(aluno2)

    }

    // Data Base operations

    //CREATE
    //READ
    //UPDATE
    //DELETE

    // CREATE:
    fun addStudent(std:Student): String {
        allStudents.add(std)
        return "Foi adicionado o estudante ${std.name}"
    }

    // READ:return all students
    // ALL
    fun retrieveAllStudents(): List<Student> {
        return allStudents
    }

    // Unique - Filtered
    fun retrieveStudentById(id: Int) : Student? {
        return allStudents.find { std ->
            std.id == id // связываем созданый нами id с id студента чтобы найти нужного студента
        }
    }

    //DELETE:
    fun deleteStudentById(id: Int) : List<Student> {
        var std: Student? = retrieveStudentById(id)
        allStudents.remove(std)
        return allStudents
    }

    // TPC: Fazer funcao de UPDATE
    // Que pode alterar o nome OU o active OU ambos

    // Unique - Filtered ByNameOrActive:
    fun retrieveStudentByNameOrActive(name: String, active: Boolean) : Student? {
        return allStudents.find { std ->
            std.name == name // связываем созданый нами name с name студента чтобы найти нужного студента
            std.active == active // связываем созданый нами active с active студента чтобы найти нужного студента
        }
    }

    // UPDATE:
    fun updateStudent(id: Int?, name: String?, active: Boolean?): List<Student>{
        var std: Student? = retrieveStudentById(id!!)
        // nullable assertion calls !!
        if (std != null) {
            std.name = name!!
            std.active = active!!
        }
        return allStudents
    }

    
}