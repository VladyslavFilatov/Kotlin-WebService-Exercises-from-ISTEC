import com.beust.klaxon.Klaxon
import com.beust.klaxon.json
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.net.URL


fun main() {

    // tempo
    val key:String = "4f08b3b9ba4e9b4ff1a23f00639c7fb1"
    val  urlTempo:String = "http://api.weatherstack.com/current"
    val cidade:String = "Lisbon"

    val resp = URL("${urlTempo}?access_key=${key}&query=${cidade}").readText()
    println(resp)

    val map = Klaxon().parse<Map<String,Any>>(resp)
    if (map is Map) {
        println("Map object")
    }

    println(map)

    var mapJs: Map<String, Any> = HashMap()
    mapJs = Gson().fromJson(resp, mapJs.javaClass)

    println(mapJs)

}

