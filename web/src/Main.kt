import com.beust.klaxon.Klaxon
import com.beust.klaxon.json
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.net.URL


fun main() {

    // tempo
    val key:String = "your-key"
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

