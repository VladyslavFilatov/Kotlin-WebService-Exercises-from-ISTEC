package com.istec.webservice.controller

import com.istec.webservice.model.City
import com.istec.webservice.repository.CityRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController

class RestController {

    var citiesRepo = CityRepository()

    @GetMapping("/getCities")
    fun getStudents(): List<City> {
        return citiesRepo.retrieveAllCities()
    }

    @PostMapping("/addCity", consumes = ["application/json"])
    fun addCities(@RequestBody tmp: City): String {
        tmp.weather = citiesRepo.weatherCity(tmp.name)
        return citiesRepo.addCity(tmp)
    }
    // curl -X POST -H 'content-type: application/json' -d '{"id":1003,"name": "Paris", "weather": ""}' localhost:8080/addCity



    @GetMapping("/findCity/{id}")
    fun findCities(@PathVariable id: Int): City? {
        println(id)
        return citiesRepo.retrieveCityById(id)
    }

    @PostMapping("/findPostCity", consumes = ["application/json"])
    fun findPostCity(@RequestBody id: Int): City? {
        println(id)
        return citiesRepo.retrieveCityById(id)
    }

    // curl -X POST -H 'content-type: application/json' -d 1001 localhost:8080/findPostCity

    @PostMapping("/deleteCity", consumes = ["application/json"])
    fun deleteCities(@RequestBody id: Int): List<City> {
        return citiesRepo.deleteCityById(id)
    }

    // curl -X POST -H 'content-type: application/json' -d 1003 localhost:8080/deleteCity


    @PostMapping("/updateCity", consumes = ["application/json"])
    fun updateCity(@RequestBody cidade:City?): List<City> {
        println(cidade?.name)
        cidade?.weather = citiesRepo.weatherCity(cidade?.name!!)
        return citiesRepo.updateCity(cidade?.id, cidade?.name, cidade?.weather)
    }

    // curl -X POST -H 'content-type: application/json' -d '{"id":1003, "name": "London", "weather": ""}' localhost:8080/updateCity


}