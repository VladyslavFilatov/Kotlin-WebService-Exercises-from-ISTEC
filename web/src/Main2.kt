import org.json.JSONObject
import java.awt.Image
import java.io.IOException
import java.net.URL
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

fun main() {

    fun weather(name: String): String {

        // weather
        val city: String = name
        val key: String = "fea84863a7eb5714d4c3f947da6c802a"
        val urlWeather: String = "https://api.openweathermap.org/data/2.5/weather?q="

        val resp = URL("${urlWeather}${city}&appid=${key}&units=metric").readText()
        println(resp)

        //Convert string to JSON
        val json: JSONObject = JSONObject(resp)
        val main = json.getJSONObject("main")
        val temp = main.getDouble("temp")
        val tempStr = temp.toString()
        //val tempFloat = temp.toFloat()
        //val tvShowTemp = "Temperature of the city is ${tempFloat}"
        return "Temperature of the city is ${tempStr}"

        // val json: JSONObject = JSONObject(resp)
        // val urls = json.getJSONArray("main")
        // for (i in 0 until urls.length()) {
        //     FIRST = urls.getJSONObject(i).getString("temp").toString()
        //     name = FIRST
        // }

    }


    println(weather("Lisbon"))

}


