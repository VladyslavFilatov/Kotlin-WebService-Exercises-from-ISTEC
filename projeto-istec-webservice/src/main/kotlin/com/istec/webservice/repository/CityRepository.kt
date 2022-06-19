package com.istec.webservice.repository

import com.fasterxml.jackson.databind.util.JSONPObject
import com.istec.webservice.model.City
import org.json.JSONObject
import org.springframework.stereotype.Repository
import java.net.URL


@Repository

class CityRepository {

    private var allCities = mutableListOf<City>()



    fun weatherCity(nome: String): String {

        // weather
        val city: String = nome
        val key: String = "your-key"
        val urlWeather: String = "https://api.openweathermap.org/data/2.5/weather?q="

        val resp = URL("${urlWeather}${city}&appid=${key}&units=metric").readText()

        //Convert string to JSON
        val json: JSONObject = JSONObject(resp)
        val main = json.getJSONObject("main")
        val temp = main.getDouble("temp")
        val tempStr = temp.toString()

        return "Temperature of the city is ${tempStr}"

    }


    init {
        val lisbon = City(1001,"Lisbon", "Temperature of the city is ${weatherCity("Lisbon")}°")

        allCities.add(lisbon)

    }


    // Data Base operations

    //CREATE
    //READ
    //UPDATE
    //DELETE

    // CREATE:
    fun addCity(std:City): String {
        allCities.add(std)
        return "Foi adicionado a cidade ${std.name}"
    }

    // READ:return all cities
    // ALL
    fun retrieveAllCities(): List<City> {
        return allCities
    }

    // Unique - Filtered
    fun retrieveCityById(id: Int) : City? {
        return allCities.find { tmp ->
            tmp.id == id
        }
    }

    //DELETE:
    fun deleteCityById(id: Int) : List<City> {
        var tmp: City? = retrieveCityById(id)
        allCities.remove(tmp)
        return allCities
    }


    // UPDATE:
    fun updateCity(id: Int?, name: String?, weather: String?): List<City>{
        var tmp: City? = retrieveCityById(id!!)
        if (tmp != null) {
            tmp.name = name!!
            tmp.weather = weather!!
        }
        return allCities
    }




}
