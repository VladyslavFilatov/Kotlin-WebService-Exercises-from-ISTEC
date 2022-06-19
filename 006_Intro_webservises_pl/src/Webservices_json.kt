import java.net.URL

fun main() {

    // tempo
    val key:String = "4f08b3b9ba4e9b4ff1a23f00639c7fb1"
    val  urlTempo:String = "http://api.weatherstack.com/current"
    val cidade:String = "Lisbon"

    val resp = URL("${urlTempo}?access_key=${key}&query=${cidade}").readText()
    println(resp)


}