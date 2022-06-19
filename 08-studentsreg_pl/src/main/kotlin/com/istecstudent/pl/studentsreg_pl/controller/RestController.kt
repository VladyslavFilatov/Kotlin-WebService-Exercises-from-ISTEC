package com.istecstudent.pl.studentsreg_pl.controller

import com.istecstudent.pl.studentsreg_pl.model.Student
import com.istecstudent.pl.studentsreg_pl.repo.StudentsRepo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController

class RestController {

    var studentsRepo = StudentsRepo()

    @GetMapping("/getStudents")
    fun getStudents(): List<Student> {
        return studentsRepo.retrieveAllStudents()
    }

    @PostMapping("/addStudent", consumes = ["application/json"])
    fun addStudents(@RequestBody std: Student): String {
        return studentsRepo.addStudent(std)
    }
    // curl -X POST -H 'content-type: application/json' -d '{"id":1003,"name": "artista da noite", "active":true}' localhost:8080/addStudent

    // TPC:
    // 1) Rota e funcao para encontrar 1 estudante - find
    // 2) Rota e funcao para apagar 1 estudante  - delete
    // 2) Rota e funcao para alterar 1 estudante - update

    @GetMapping("/findStudent/{id}")
    fun findStudents(@PathVariable id: Int): Student? {
        println(id)
        return studentsRepo.retrieveStudentById(id)
    }

        @PostMapping("/findPostStudent", consumes = ["application/json"])
    fun findPostStudent(@RequestBody id: Int): Student? {
        println(id)
        return studentsRepo.retrieveStudentById(id)
    }

    // curl -X POST -H 'content-type: application/json' -d 1001 localhost:8080/findPostStudent

    @PostMapping("/deleteStudent", consumes = ["application/json"])
    fun deleteStudents(@RequestBody id: Int): List<Student> {
        return studentsRepo.deleteStudentById(id)
    }

    // curl -X POST -H 'content-type: application/json' -d 1003 localhost:8080/deleteStudent


     // aluno пишеться чтобы создать новый обьект который примет новые данные и обновить их
    @PostMapping("/updateStudent", consumes = ["application/json"])
    fun updateStudent(@RequestBody aluno:Student?): List<Student> {
        println(aluno?.name)
        return studentsRepo.updateStudent(aluno?.id, aluno?.name, aluno?.active)
    }

    // curl -X POST -H 'content-type: application/json' -d '{"id":1003, "name": "artista da manha", "actvive":false}' localhost:8080/updateStudent

}